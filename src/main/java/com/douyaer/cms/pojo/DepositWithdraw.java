package com.douyaer.cms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DepositWithdraw {
    private Long id;

    private Long userId;

    private String exchangeType;

    private BigDecimal totalFee;

    private String wechatName;

    private String remark;

    private Date ctime;

    private Integer status;

    public DepositWithdraw(Long id, Long userId, String exchangeType, BigDecimal totalFee, String wechatName, String remark, Date ctime, Integer status) {
        this.id = id;
        this.userId = userId;
        this.exchangeType = exchangeType;
        this.totalFee = totalFee;
        this.wechatName = wechatName;
        this.remark = remark;
        this.ctime = ctime;
        this.status = status;
    }

    public DepositWithdraw() {
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

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType == null ? null : exchangeType.trim();
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}