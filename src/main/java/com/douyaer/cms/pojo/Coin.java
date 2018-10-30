package com.douyaer.cms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Coin {
    private Long id;

    private Long userId;

    private String event;

    private String eventId;

    private String comment;

    private BigDecimal count;

    private BigDecimal accountBalance;

    private Date ctime;

    public Coin(Long id, Long userId, String event, String eventId, String comment, BigDecimal count, BigDecimal accountBalance, Date ctime) {
        this.id = id;
        this.userId = userId;
        this.event = event;
        this.eventId = eventId;
        this.comment = comment;
        this.count = count;
        this.accountBalance = accountBalance;
        this.ctime = ctime;
    }

    public Coin() {
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}