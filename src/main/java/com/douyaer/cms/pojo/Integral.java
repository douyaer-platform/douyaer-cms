package com.douyaer.cms.pojo;

import java.util.Date;

public class Integral {
    private Long id;

    private Long userId;

    private String event;

    private String eventId;

    private String comment;

    private Integer count;

    private Date ctime;

    public Integral(Long id, Long userId, String event, String eventId, String comment, Integer count, Date ctime) {
        this.id = id;
        this.userId = userId;
        this.event = event;
        this.eventId = eventId;
        this.comment = comment;
        this.count = count;
        this.ctime = ctime;
    }

    public Integral() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}