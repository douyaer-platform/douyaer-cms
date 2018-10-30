package com.douyaer.cms.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.pojo.Task;

public class TaskEntity extends Task {

    private String phone;
    private String taobaoAccount;

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount == null ? null : taobaoAccount.trim();
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public TaskEntity(String taskId, Long userId, String brushhandSex, String provinces, Date startTime, Date endTime, Integer orderCount, BigDecimal costTotalCoin, BigDecimal orderPrice, Integer commission, Integer finishScalpingCount, String remark, String storeName, String goodsUrl, String goodsPicUrl, String searchPicUrl, String conditionPicUrl, BigDecimal goodsPrice, String tags, Short buyBackType, Short needAlitm, Date createTime, Integer status, BigDecimal refundCoin, Date refundTime, String phone, String taobaoAccount) {
        super(taskId, userId, brushhandSex, provinces, startTime, endTime, orderCount, costTotalCoin, orderPrice, commission, finishScalpingCount, remark, storeName, goodsUrl, goodsPicUrl, searchPicUrl, conditionPicUrl, goodsPrice, tags, buyBackType, needAlitm, createTime, status, refundCoin, refundTime);
        this.phone = phone;
        this.taobaoAccount = taobaoAccount;
    }

}