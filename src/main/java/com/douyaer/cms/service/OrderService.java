package com.douyaer.cms.service;

import java.util.List;

import com.douyaer.cms.dao.OrderMapper;
import com.douyaer.cms.entity.OrderEntity;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.pojo.Order;
import com.douyaer.cms.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Pager list(String phone, String busPhone, Long orderId, Integer status, String start, String end, int page, int limit) {
        Pager pager = new Pager();
		PageHelper.startPage(page, limit);
		List <OrderEntity> list = orderMapper.list(phone, busPhone, orderId, status, CommonUtil.getDateStart(start), CommonUtil.getDateEnd(end));
		PageInfo<OrderEntity> pageInfo = new PageInfo<>(list);
		pager.setPage(page);
		pager.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pager.setList(list);
		return pager;
    }

    public Order getOrderById(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    public boolean updateOrder(Order order) {
        orderMapper.updateByPrimaryKey(order);
        return true;
    }

}