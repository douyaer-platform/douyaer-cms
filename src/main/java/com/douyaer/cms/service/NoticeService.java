package com.douyaer.cms.service;

import java.util.Date;

import com.douyaer.cms.dao.NoticeMapper;
import com.douyaer.cms.pojo.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    public String getNewestNotice() {
        Notice notice = noticeMapper.getNewestNotice();
        if (notice == null || notice.getContent() == null) {
            return "";
        }
        return notice.getContent();
    }

    public String add(String content) {
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setCtime(new Date());
        notice.setStatus(0);
        noticeMapper.insert(notice);
        return content;
    }

}