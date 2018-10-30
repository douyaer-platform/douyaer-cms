package com.douyaer.cms.entity;

import java.util.Date;

import com.douyaer.cms.pojo.Complaint;

public class ComplaintEntity extends Complaint {

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public ComplaintEntity(Long id, Long orderId, Long complaintUserId, String remark, Integer status, Date ctime, String phone) {
        super(id, orderId, complaintUserId, remark, status, ctime);
        this.phone = phone;
    }
    
}