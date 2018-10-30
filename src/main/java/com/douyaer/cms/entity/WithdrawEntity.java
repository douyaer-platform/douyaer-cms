package com.douyaer.cms.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.pojo.DepositWithdraw;

public class WithdrawEntity extends DepositWithdraw {

    private String realName;
    private String phone;

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public WithdrawEntity(Long id, Long userId, String exchangeType, BigDecimal totalFee, String wechatName, String remark, Date ctime, Integer status, String realName, String phone) {
        super(id, userId, exchangeType, totalFee, wechatName, remark, ctime, status);
        this.realName = realName;
        this.phone = phone;
    }
    
}