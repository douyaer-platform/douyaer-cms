package com.douyaer.cms.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.douyaer.cms.pojo.User;

public class BrushhandEntity extends User {

    private String inviteRealName;

    public void setInviteRealName(String inviteRealName) {
        this.inviteRealName = inviteRealName == null ? null : inviteRealName.trim();
    }

    public String getInviteRealName() {
        return inviteRealName;
    }

    public BrushhandEntity(Long userId, String userRole, String phone, String password, String realName, String avatar, String sex, String identifyNo, BigDecimal coin, BigDecimal freezeCoin, Integer integral, String taobaoAccount, String ip, String address, String alitm, String storeUrl, Integer inviterUserId, Date createTime, Date updateTime, Integer status, String identifyNoUrl, String inviteRealName) {
        super(userId, userRole, phone, password, realName, avatar, sex, identifyNo, coin, freezeCoin, integral, taobaoAccount, ip, address, alitm, storeUrl, inviterUserId, createTime, updateTime, status, identifyNoUrl);
        this.inviteRealName = inviteRealName;
    }
}