package com.douyaer.cms.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.douyaer.cms.dao.CoinMapper;
import com.douyaer.cms.dao.IntegralMapper;
import com.douyaer.cms.dao.TaskMapper;
import com.douyaer.cms.dao.UserMapper;
import com.douyaer.cms.entity.TaskEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.pojo.Coin;
import com.douyaer.cms.pojo.Integral;
import com.douyaer.cms.pojo.Task;
import com.douyaer.cms.pojo.User;
import com.douyaer.cms.redis.RedisClient;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TaskService {
    
    private Logger log = LoggerFactory.getLogger(TaskService.class.getSimpleName());

    @Autowired
    public TaskMapper taskMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    IntegralMapper integralMapper;

    @Autowired
    private RedisClient redisClient;

    public Pager list(String phone, String taobaoAccount, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<TaskEntity> list = taskMapper.list(phone, taobaoAccount);
		PageInfo<TaskEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    @Transactional(value="transactionManager")
    public boolean cert(String id, int status) {
        Task task = taskMapper.selectByPrimaryKey(id);
        if (task == null || task.getStatus() != 0) {
            return false;
        }
        task.setStatus(status);

        Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint(); 
        try {
            taskMapper.updateByPrimaryKey(task);

            // 不通过时，要返还金币和积分
            if (status == 1) {
                BigDecimal refundCoin = task.getCostTotalCoin();
                log.info("==============refundCoin:" + refundCoin);

                User user = userMapper.selectByPrimaryKey(task.getUserId());
                user.setCoin(user.getCoin().add(refundCoin));
                if (user.getFreezeCoin().subtract(refundCoin).compareTo(new BigDecimal(0)) < 0) {
                    log.info("==============refundCoin:冻结金币不够抵扣");
                    return false;
                }
                user.setFreezeCoin(user.getFreezeCoin().subtract(refundCoin));
                user.setIntegral(user.getIntegral() + task.getOrderCount());

                Coin coin = new Coin();
                coin.setUserId(user.getUserId());
                coin.setCount(refundCoin);
                coin.setEvent("task_refund");
                coin.setComment("管理员取消任务退还");
                coin.setEventId(task.getTaskId());
                coin.setAccountBalance(user.getCoin());
                coin.setCtime(new Date());

                Integral integral = new Integral();
                integral.setUserId(user.getUserId());
                integral.setEvent("task_refund");
                integral.setEventId(task.getTaskId());
                integral.setComment("管理员取消任务退还");
                integral.setCount(task.getOrderCount());
                integral.setCtime(new Date());

                userMapper.updateByPrimaryKey(user);
                coinMapper.insert(coin);
                integralMapper.insert(integral);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
            return false;
        }
        
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }
    
}