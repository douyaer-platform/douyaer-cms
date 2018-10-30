package com.douyaer.cms.pojo;

import java.util.Date;

public class Notice {
    private Long noticeId;

    private String content;

    private Date ctime;

    private Integer status;

    public Notice(Long noticeId, String content, Date ctime, Integer status) {
        this.noticeId = noticeId;
        this.content = content;
        this.ctime = ctime;
        this.status = status;
    }

    public Notice() {
        super();
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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