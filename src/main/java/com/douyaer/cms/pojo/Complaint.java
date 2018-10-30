package com.douyaer.cms.pojo;

import java.util.Date;

public class Complaint {
    private Long id;

    private Long orderId;

    private Long complaintUserId;

    private String remark;

    private Integer status;

    private Date ctime;

    public Complaint(Long id, Long orderId, Long complaintUserId, String remark, Integer status, Date ctime) {
        this.id = id;
        this.orderId = orderId;
        this.complaintUserId = complaintUserId;
        this.remark = remark;
        this.status = status;
        this.ctime = ctime;
    }

    public Complaint() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getComplaintUserId() {
        return complaintUserId;
    }

    public void setComplaintUserId(Long complaintUserId) {
        this.complaintUserId = complaintUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}