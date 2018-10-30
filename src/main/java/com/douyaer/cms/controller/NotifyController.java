package com.douyaer.cms.controller;

import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notice")
public class NotifyController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Response detail() {
        return Response.success(noticeService.getNewestNotice());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response edit(@RequestParam("content") String content) {
        if (content == null || content.trim().length() == 0) {
            return Response.error("内容不能为空");
        }
        return Response.success(noticeService.add(content));
    }

}