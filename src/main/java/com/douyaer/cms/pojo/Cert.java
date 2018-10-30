package com.douyaer.cms.pojo;

import java.util.Date;

public class Cert {
    private Long id;

    private Long userId;

    private String realName;

    private String identifyNo;

    private String sex;

    private String ip;

    private String provnce;

    private String city;

    private String address;

    private String taobaoAccount;

    private String alitm;

    private String storeUrl;

    private String identifyNoUrl;

    private String ipScreenshotUrl;

    private String taobaoScreenshotUrl;

    private String alipayScreenshotUrl;

    private Date createTime;

    private Integer status;

    public Cert(Long id, Long userId, String realName, String identifyNo, String sex, String ip, String provnce, String city, String address, String taobaoAccount, String alitm, String storeUrl, String identifyNoUrl, String ipScreenshotUrl, String taobaoScreenshotUrl, String alipayScreenshotUrl, Date createTime, Integer status) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.identifyNo = identifyNo;
        this.sex = sex;
        this.ip = ip;
        this.provnce = provnce;
        this.city = city;
        this.address = address;
        this.taobaoAccount = taobaoAccount;
        this.alitm = alitm;
        this.storeUrl = storeUrl;
        this.identifyNoUrl = identifyNoUrl;
        this.ipScreenshotUrl = ipScreenshotUrl;
        this.taobaoScreenshotUrl = taobaoScreenshotUrl;
        this.alipayScreenshotUrl = alipayScreenshotUrl;
        this.createTime = createTime;
        this.status = status;
    }

    public Cert() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdentifyNo() {
        return identifyNo;
    }

    public void setIdentifyNo(String identifyNo) {
        this.identifyNo = identifyNo == null ? null : identifyNo.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getProvnce() {
        return provnce;
    }

    public void setProvnce(String provnce) {
        this.provnce = provnce == null ? null : provnce.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount == null ? null : taobaoAccount.trim();
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

    public String getIdentifyNoUrl() {
        return identifyNoUrl;
    }

    public void setIdentifyNoUrl(String identifyNoUrl) {
        this.identifyNoUrl = identifyNoUrl == null ? null : identifyNoUrl.trim();
    }

    public String getIpScreenshotUrl() {
        return ipScreenshotUrl;
    }

    public void setIpScreenshotUrl(String ipScreenshotUrl) {
        this.ipScreenshotUrl = ipScreenshotUrl == null ? null : ipScreenshotUrl.trim();
    }

    public String getTaobaoScreenshotUrl() {
        return taobaoScreenshotUrl;
    }

    public void setTaobaoScreenshotUrl(String taobaoScreenshotUrl) {
        this.taobaoScreenshotUrl = taobaoScreenshotUrl == null ? null : taobaoScreenshotUrl.trim();
    }

    public String getAlipayScreenshotUrl() {
        return alipayScreenshotUrl;
    }

    public void setAlipayScreenshotUrl(String alipayScreenshotUrl) {
        this.alipayScreenshotUrl = alipayScreenshotUrl == null ? null : alipayScreenshotUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}