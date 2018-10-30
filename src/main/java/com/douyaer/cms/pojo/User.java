package com.douyaer.cms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Long userId;

    private String userRole;

    private String phone;

    private String password;

    private String realName;

    private String avatar;

    private String sex;

    private String identifyNo;

    private BigDecimal coin;

    private BigDecimal freezeCoin;

    private Integer integral;

    private String taobaoAccount;

    private String ip;

    private String address;

    private String alitm;

    private String storeUrl;

    private Integer inviterUserId;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String identifyNoUrl;

    public User(Long userId, String userRole, String phone, String password, String realName, String avatar, String sex, String identifyNo, BigDecimal coin, BigDecimal freezeCoin, Integer integral, String taobaoAccount, String ip, String address, String alitm, String storeUrl, Integer inviterUserId, Date createTime, Date updateTime, Integer status, String identifyNoUrl) {
        this.userId = userId;
        this.userRole = userRole;
        this.phone = phone;
        this.password = password;
        this.realName = realName;
        this.avatar = avatar;
        this.sex = sex;
        this.identifyNo = identifyNo;
        this.coin = coin;
        this.freezeCoin = freezeCoin;
        this.integral = integral;
        this.taobaoAccount = taobaoAccount;
        this.ip = ip;
        this.address = address;
        this.alitm = alitm;
        this.storeUrl = storeUrl;
        this.inviterUserId = inviterUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.identifyNoUrl = identifyNoUrl;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentifyNo() {
        return identifyNo;
    }

    public void setIdentifyNo(String identifyNo) {
        this.identifyNo = identifyNo == null ? null : identifyNo.trim();
    }

    public BigDecimal getCoin() {
        return coin;
    }

    public void setCoin(BigDecimal coin) {
        this.coin = coin;
    }

    public BigDecimal getFreezeCoin() {
        return freezeCoin;
    }

    public void setFreezeCoin(BigDecimal freezeCoin) {
        this.freezeCoin = freezeCoin;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount == null ? null : taobaoAccount.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAlitm() {
        return alitm;
    }

    public void setAlitm(String alitm) {
        this.alitm = alitm == null ? null : alitm.trim();
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl == null ? null : storeUrl.trim();
    }

    public Integer getInviterUserId() {
        return inviterUserId;
    }

    public void setInviterUserId(Integer inviterUserId) {
        this.inviterUserId = inviterUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdentifyNoUrl() {
        return identifyNoUrl;
    }

    public void setIdentifyNoUrl(String identifyNoUrl) {
        this.identifyNoUrl = identifyNoUrl == null ? null : identifyNoUrl.trim();
    }
}