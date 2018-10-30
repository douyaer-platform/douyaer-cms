package com.douyaer.cms.entity;

import java.util.Date;

import com.douyaer.cms.pojo.Invite;

public class InviteEntity extends Invite {

    private String realName;
    private String phone;
    private String descRealName;
    private String descPhone;
    private String descTaobaoAccount;
    private Integer orderCount;

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

    public void setDescRealName(String descRealName) {
        this.descRealName = descRealName == null ? null : descRealName.trim();
    }

    public String getDescRealName() {
        return descRealName;
    }

    public void setDescPhone(String descPhone) {
        this.descPhone = descPhone == null ? null : descPhone.trim();
    }

    public String getDescPhone() {
        return descPhone;
    }

    public void setDescTaobaoAccount(String descTaobaoAccount) {
        this.descTaobaoAccount = descTaobaoAccount == null ? null : descTaobaoAccount.trim();
    }

    public String getDescTaobaoAccount() {
        return descTaobaoAccount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public InviteEntity(String inviteId, Long userId, Long descUserId, Integer status, Date ctime, Date receiveCtime, Integer integral, String realName, String phone, String descRealName, String descPhone, String descTaobaoAccount, Integer orderCount) {
        super(inviteId, userId, descUserId, status, ctime, receiveCtime, integral);
        this.realName = realName;
        this.phone = phone;
        this.descPhone = descPhone;
        this.descRealName = descRealName;
        this.descTaobaoAccount = descTaobaoAccount;
        this.orderCount = orderCount;
    }
    
}