package com.douyaer.cms.controller;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.dao.CoinMapper;
import com.douyaer.cms.dao.SysDicMapper;
import com.douyaer.cms.dao.TaskMapper;
import com.douyaer.cms.dao.UserMapper;
import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.pojo.Coin;
import com.douyaer.cms.pojo.Order;
import com.douyaer.cms.pojo.SysDic;
import com.douyaer.cms.pojo.SysDicKey;
import com.douyaer.cms.pojo.Task;
import com.douyaer.cms.pojo.User;
import com.douyaer.cms.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private Logger log = LoggerFactory.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private OrderService orderService;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    private SysDicMapper sysDicMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "busPhone", required = false) String busPhone,
        @RequestParam(value = "orderId", required = false) Long orderId,
        @RequestParam(value = "status", required = false) Integer status,
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = orderService.list(phone, busPhone, orderId, status, start, end, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

    @Transactional(value="transactionManager")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public Response cancel(@RequestParam(value = "orderId") Long orderId) {
        log.info("==============cancel order Id:" + orderId);
        // 1、更新订单表(t_user_order)状态status字段为4(4=已结束)
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return Response.error("找不到订单");
        }
        if (order.getStatus() == 4) {
            return Response.error("订单已结束");
        }
        if (order.getStatus() == -1) {
            return Response.error("订单已取消");
        }
        order.setStatus(4);
        

        // 2、计算退还给商家的金额refundCoin,计算方法，任务表(t_user_task)中的模板价格(order_price)字段减去平台手续费(在配置表中读取t_sys_dic)
        Task task = taskMapper.selectByPrimaryKey(order.getTaskId());
        if (task == null) {
            return Response.error("找不到任务");
        }

        SysDicKey key = new SysDicKey("fee", "commission_charge");
        SysDic sysDic = sysDicMapper.selectByPrimaryKey(key);
        log.info("==============fee commission_charge:" + sysDic.getDicValue());
        BigDecimal refundCoin = task.getOrderPrice().subtract(new BigDecimal(sysDic.getDicValue()));
        log.info("==============refundCoin:" + refundCoin);

        // 3、执行退还操作，用户表（商家）中coin字段加上退还金额refundCoin,用户表中冻结金额字段freeze_coin减去退还金额refundCoin，用户金币流水表t_user_coin_log新增金币退还流水，事件为order_refund,事件id为订单id，描述字段为'退还金币，管理员关闭刷手订单'
        User user = userMapper.selectByPrimaryKey(task.getUserId());
        user.setCoin(user.getCoin().add(refundCoin));
        if (user.getFreezeCoin().subtract(refundCoin).compareTo(new BigDecimal(0)) < 0) {
            return Response.error("冻结金币不够抵扣");
        }
        user.setFreezeCoin(user.getFreezeCoin().subtract(refundCoin));

        Coin coin = new Coin();
        coin.setUserId(user.getUserId());
        coin.setCount(refundCoin);
        coin.setEvent("order_refund");
        coin.setComment("退还金币，管理员关闭刷手订单");
        coin.setEventId("" + orderId);
        coin.setAccountBalance(user.getCoin());
        coin.setCtime(new Date());

        // 4、按照这个操作，务必保证这些操作在同一个事件中提交
        Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint(); 
        try {
            orderService.updateOrder(order);
            userMapper.updateByPrimaryKey(user);
            coinMapper.insert(coin);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
            return Response.error("系统异常");
        }
    }

}