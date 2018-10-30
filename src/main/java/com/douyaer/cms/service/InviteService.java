package com.douyaer.cms.service;

import java.util.List;

import com.douyaer.cms.dao.InviteMapper;
import com.douyaer.cms.entity.InviteEntity;
import com.douyaer.cms.model.Pager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteService {

    @Autowired
    public InviteMapper inviteMapper;

    public Pager list(String phone, String descPhone, String taobaoAccount, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List<InviteEntity> list = inviteMapper.list(phone, descPhone, taobaoAccount);
		PageInfo<InviteEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

}
