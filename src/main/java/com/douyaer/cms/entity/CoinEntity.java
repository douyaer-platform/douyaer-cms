package com.douyaer.cms.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.pojo.Coin;

public class CoinEntity extends Coin {

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public CoinEntity(Long id, Long userId, String event, String eventId, String comment, BigDecimal count, BigDecimal accountBalance, Date ctime, String phone) {
        super(id, userId, event, eventId, comment, count, accountBalance, ctime);
        this.phone = phone;
    }

}