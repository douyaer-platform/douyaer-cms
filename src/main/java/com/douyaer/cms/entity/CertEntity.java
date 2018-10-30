package com.douyaer.cms.entity;

import java.util.Date;

import com.douyaer.cms.pojo.Cert;

public class CertEntity extends Cert {

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public CertEntity(Long id, Long userId, String realName, String identifyNo, String sex, String ip, String provnce, String city, String address, String taobaoAccount, String alitm, String storeUrl, String identifyNoUrl, String ipScreenshotUrl, String taobaoScreenshotUrl, String alipayScreenshotUrl, Date createTime, Integer status, String phone) {
        super(id, userId, realName, identifyNo, sex, ip, provnce, city, address, taobaoAccount, alitm, storeUrl, identifyNoUrl, ipScreenshotUrl, taobaoScreenshotUrl, alipayScreenshotUrl, createTime, status);
        this.phone = phone;
    }
}