package com.douyaer.cms.service;

import java.util.List;

import com.douyaer.cms.dao.ComplaintMapper;
import com.douyaer.cms.entity.ComplaintEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.pojo.Complaint;
import com.douyaer.cms.redis.RedisClient;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    
    @Autowired
    public ComplaintMapper complaintMapper;

    @Autowired
    private RedisClient redisClient;

    public Pager list(int page, int limit, String phone) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<ComplaintEntity> list = complaintMapper.list(phone);
		PageInfo<ComplaintEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public boolean handle(long id) {
        Complaint complaint = complaintMapper.selectByPrimaryKey(id);
        if (complaint == null) {
            return false;
        }
        complaint.setStatus(1);
        complaintMapper.updateByPrimaryKey(complaint);
        // 前端接口的需求
        redisClient.cleanCache();
        return true;
    }

}