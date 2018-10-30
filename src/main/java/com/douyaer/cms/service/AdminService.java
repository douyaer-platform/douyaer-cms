package com.douyaer.cms.service;

import java.util.List;

import com.douyaer.cms.dao.AdminMapper;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.pojo.Admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

	public Pager list(int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<Admin> list = adminMapper.list();
		// 获取分页查询后的数据
		PageInfo<Admin> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }
    
    public Admin getAdminByName(String name) {
        return adminMapper.getAdminByName(name);
    }

    public boolean updateAdmin(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
        return true;
    }

}