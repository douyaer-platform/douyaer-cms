package com.douyaer.cms.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.douyaer.cms.dao.CoinMapper;
import com.douyaer.cms.dao.DepositWithdrawMapper;
import com.douyaer.cms.dao.UserMapper;
import com.douyaer.cms.entity.DepositEntity;
import com.douyaer.cms.entity.WithdrawEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.pojo.Coin;
import com.douyaer.cms.pojo.DepositWithdraw;
import com.douyaer.cms.pojo.User;
import com.douyaer.cms.redis.RedisClient;
import com.douyaer.cms.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositWithdrawService {

    @Autowired
    DepositWithdrawMapper depositWithdrawMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CoinMapper coinMapper;

    @Autowired
    RedisClient redisClient;

    public Pager getDepositList(String phone, String start, String end, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<DepositEntity> list = depositWithdrawMapper.getDepositList(phone, CommonUtil.getDateStart(start), CommonUtil.getDateEnd(end));
		PageInfo<DepositEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public Pager getWithdrawList(String phone, String start, String end, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<WithdrawEntity> list = depositWithdrawMapper.getWithdrawList(phone, CommonUtil.getDateStart(start), CommonUtil.getDateEnd(end));
		PageInfo<WithdrawEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public Response confirm(long id) {
        DepositWithdraw depositWithdraw = depositWithdrawMapper.selectByPrimaryKey(id);
        if (depositWithdraw == null) {
            return Response.error("找不到该充值记录");
        }
        if (depositWithdraw.getStatus() == 1) {
            return Response.error("已完成");
        }

        User user = userMapper.selectByPrimaryKey(depositWithdraw.getUserId());
        if (user == null) {
            return Response.error("找不到该充值记录的用户");
        }
        
        if (depositWithdraw.getExchangeType().equals("deposit")) {
            user.setCoin(user.getCoin().add(depositWithdraw.getTotalFee()));
        } else if (depositWithdraw.getExchangeType().equals("withdraw")) {
            BigDecimal usefulFreezeCoin = user.getFreezeCoin().subtract(depositWithdraw.getTotalFee());
            if (usefulFreezeCoin.compareTo(new BigDecimal(0)) < 0) {
                return Response.error("冻结金币不够提现抵扣");
            }
            user.setFreezeCoin(usefulFreezeCoin);
        } else {
            return Response.error("非法参数");
        }
        userMapper.updateByPrimaryKey(user);

        Coin coin = new Coin();
        coin.setUserId(depositWithdraw.getUserId());
        // 记录对应的申请ID
        coin.setEventId("" + depositWithdraw.getId());
        // 记录余额
        coin.setAccountBalance(user.getCoin());
        coin.setCtime(new Date());
        if (depositWithdraw.getExchangeType().equals("deposit")) {
            coin.setCount(depositWithdraw.getTotalFee());
            coin.setEvent("web_recharge_check");
            coin.setComment("充值");
            // 不要问为什么，业务接口要求的
            coinMapper.insert(coin);
        } else {
            coin.setCount((new BigDecimal(0)).subtract(depositWithdraw.getTotalFee()));
            coin.setEvent("web_withdraw_check");
            coin.setComment("提现");
        }
        // 提现的时候不产生流水
        // coinMapper.insert(coin);

        depositWithdraw.setStatus(1);
        depositWithdrawMapper.updateByPrimaryKey(depositWithdraw);

        // 前端接口的需求
        redisClient.cleanCache();
        return Response.success();
    }

    public Response add(String phone, double totalFee, String exchangeType, Long adminId) {
        User user = userMapper.getUserByPhone(phone);
        if (user == null) {
            return Response.error("找不到手机号码为" + phone + "的用户");
        }

        if (exchangeType.equals("deposit")) {
            user.setCoin(user.getCoin().add(new BigDecimal(totalFee)));
        } else if (exchangeType.equals("withdraw")) {
            if (user.getCoin().subtract(new BigDecimal(totalFee)).compareTo(new BigDecimal(0)) < 0) {
                return Response.error("金币不够提现抵扣");
            }
            user.setCoin(user.getCoin().subtract(new BigDecimal(totalFee)));
        } else {
            return Response.error("非法参数");
        }
        userMapper.updateByPrimaryKey(user);

        DepositWithdraw depositWithdraw = new DepositWithdraw();
        depositWithdraw.setUserId(user.getUserId());
        depositWithdraw.setTotalFee(new BigDecimal(totalFee));
        depositWithdraw.setExchangeType(exchangeType);
        depositWithdraw.setWechatName("");
        if (exchangeType.equals("deposit")) {
            depositWithdraw.setRemark("手动充值，充值管理员ID：" + adminId);
        } else {
            depositWithdraw.setRemark("手动提现，提现管理员ID：" + adminId);
        }
        depositWithdraw.setCtime(new Date());
        depositWithdraw.setStatus(1);
        depositWithdrawMapper.insertSelective(depositWithdraw);

        Coin coin = new Coin();
        coin.setUserId(user.getUserId());
        if (exchangeType.equals("deposit")) {
            coin.setCount(new BigDecimal(totalFee));
            coin.setEvent("admin_recharge");
            coin.setComment("手动充值，充值管理员ID：" + adminId);
        } else {
            coin.setCount(new BigDecimal(-totalFee));
            coin.setEvent("admin_withdraw");
            coin.setComment("手动提现，提现管理员ID：" + adminId);
        }
        
        coin.setEventId("" + depositWithdraw.getId());
        // 记录余额
        coin.setAccountBalance(user.getCoin());
        coin.setCtime(new Date());
        coinMapper.insert(coin);

        // 前端接口的需求
        redisClient.cleanCache();
        return Response.success();
    }

}