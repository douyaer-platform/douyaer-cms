package com.douyaer.cms.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class WebController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin/updatePassword")
    public String adminUpdatePassword() {
        return "admin/updatePassword";
    }

    @RequestMapping("/brushhand/certList")
    public String brushhandCertList() {
        return "brushhand/certList";
    }

    @RequestMapping("/brushhand/list")
    public String brushhandList() {
        return "brushhand/list";
    }

    @RequestMapping("/business/certList")
    public String businessCertList() {
        return "business/certList";
    }

    @RequestMapping("/business/list")
    public String businessList() {
        return "business/list";
    }

    @RequestMapping("/task/list")
    public String taskList() {
        return "task/list";
    }

    @RequestMapping("/order/list")
    public String orderList() {
        return "order/list";
    }

    @RequestMapping("/invite/list")
    public String inviteList() {
        return "invite/list";
    }

    @RequestMapping("/deposit/add")
    public String depositAdd() {
        return "deposit/add";
    }

    @RequestMapping("/deposit/list")
    public String depositList() {
        return "deposit/list";
    }

    @RequestMapping("/withdraw/add")
    public String withdrawAdd() {
        return "withdraw/add";
    }

    @RequestMapping("/withdraw/list")
    public String withdrawList() {
        return "withdraw/list";
    }

    @RequestMapping("/coin/list")
    public String coinList() {
        return "coin/list";
    }

    @RequestMapping("/notice/edit")
    public String noticeEdit() {
        return "notice/edit";
    }

    @RequestMapping("/complaint/list")
    public String complaintList() {
        return "complaint/list";
    }
}