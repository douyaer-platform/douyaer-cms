package com.douyaer.cms.service;

import java.util.List;

import com.douyaer.cms.dao.CoinMapper;
import com.douyaer.cms.entity.CoinEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {

    @Autowired
    private CoinMapper coinMapper;

    public Pager list(String phone, Long id, String start, String end, int page, int limit) {
        Pager pager = new Pager();
        PageHelper.startPage(page, limit);
		List<CoinEntity> list = coinMapper.list(phone, id, CommonUtil.getDateStart(start), CommonUtil.getDateEnd(end));
		// 获取分页查询后的数据
		PageInfo<CoinEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

}