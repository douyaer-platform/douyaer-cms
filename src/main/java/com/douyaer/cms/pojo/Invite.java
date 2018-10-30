package com.douyaer.cms.pojo;

import java.util.Date;

public class Invite {
    private String inviteId;

    private Long userId;

    private Long descUserId;

    private Integer status;

    private Date ctime;

    private Date receiveCtime;

    private Integer integral;

    public Invite(String inviteId, Long userId, Long descUserId, Integer status, Date ctime, Date receiveCtime, Integer integral) {
        this.inviteId = inviteId;
        this.userId = userId;
        this.descUserId = descUserId;
        this.status = status;
        this.ctime = ctime;
        this.receiveCtime = receiveCtime;
        this.integral = integral;
    }

    public Invite() {
        super();
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId == null ? null : inviteId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDescUserId() {
        return descUserId;
    }

    public void setDescUserId(Long descUserId) {
        this.descUserId = descUserId;
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

    public Date getReceiveCtime() {
        return receiveCtime;
    }

    public void setReceiveCtime(Date receiveCtime) {
        this.receiveCtime = receiveCtime;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}