package com.douyaer.cms.service;

import java.util.Date;
import java.util.List;

import com.douyaer.cms.dao.CertMapper;
import com.douyaer.cms.dao.IntegralMapper;
import com.douyaer.cms.dao.UserMapper;
import com.douyaer.cms.entity.BrushhandEntity;
import com.douyaer.cms.entity.CertEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.pojo.Cert;
import com.douyaer.cms.pojo.Integral;
import com.douyaer.cms.pojo.User;
import com.douyaer.cms.redis.RedisClient;
import com.douyaer.cms.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CertMapper certMapper;

    @Autowired
    IntegralMapper integralMapper;

    @Autowired
    private RedisClient redisClient;

    public Pager getBrushhandCertList(int page, int limit, String phone) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<CertEntity> list = certMapper.getBrushhandCertList(phone);
		PageInfo<CertEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public boolean cert(long id, int status) {
        Cert cert = certMapper.selectByPrimaryKey(id);
        if (cert == null) {
            return false;
        }
        cert.setStatus(status);
        if (status == 2) {
            User user = userMapper.selectByPrimaryKey(cert.getUserId());
            if (user == null) {
                return false;
            }
            user.setRealName(cert.getRealName());
            user.setSex(cert.getSex());
            user.setIdentifyNo(cert.getIdentifyNo());
            user.setIdentifyNoUrl(cert.getIdentifyNoUrl());
            user.setTaobaoAccount(cert.getTaobaoAccount());
            user.setIp(cert.getIp());
            user.setAddress(cert.getProvnce() + cert.getAddress());
            user.setAlitm(cert.getAlitm());
            user.setStoreUrl(cert.getStoreUrl());
            userMapper.updateByPrimaryKey(user);
        }
        certMapper.updateByPrimaryKey(cert);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

    public Pager getBrushhandList(String phone, String taobaoAccount, String start, String end, int page, int limit) {
        Pager pager = new Pager();
        PageHelper.startPage(page, limit);
		List<BrushhandEntity> list = userMapper.getBrushhandList(phone, taobaoAccount, CommonUtil.getDateStart(start), CommonUtil.getDateEnd(end));
		PageInfo<BrushhandEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public boolean blacklist(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return false;
        }
        user.setStatus(1);
        userMapper.updateByPrimaryKey(user);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

    public boolean notblacklist(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return false;
        }
        user.setStatus(0);
        userMapper.updateByPrimaryKey(user);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

    public boolean addIntegral(long id, int integral, String adminId) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return false;
        }
        user.setIntegral(user.getIntegral() + integral);
        userMapper.updateByPrimaryKey(user);

        Integral integralLog = new Integral();
        integralLog.setUserId(user.getUserId());
        integralLog.setEvent("admin_add_integral");
        integralLog.setEventId(adminId);
        integralLog.setComment("管理员增加积分");
        integralLog.setCount(integral);
        integralLog.setCtime(new Date());
        integralMapper.insert(integralLog);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

    public boolean removeIntegral(long id, int integral, String adminId) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return false;
        }
        user.setIntegral(user.getIntegral() - integral);
        userMapper.updateByPrimaryKey(user);

        Integral integralLog = new Integral();
        integralLog.setUserId(user.getUserId());
        integralLog.setEvent("admin_remove_integral");
        integralLog.setEventId(adminId);
        integralLog.setComment("管理员减扣积分");
        integralLog.setCount(-integral);
        integralLog.setCtime(new Date());
        integralMapper.insert(integralLog);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

    public Pager getBusinessCertList(int page, int limit, String phone) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<CertEntity> list = certMapper.getBusinessCertList(phone);
		PageInfo<CertEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public Pager getBusinessList(String phone, String alitm, String start, String end, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<User> list = userMapper.getBusinessList(phone, alitm, CommonUtil.getDateStart(start), CommonUtil.getDateStart(end));
		PageInfo<User> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return true;
    }
}