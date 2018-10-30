package com.douyaer.cms.controller;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brushhand")
public class BrushhandController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/certList", method = RequestMethod.GET)
    public Response verifyList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "phone", required = false) String phone) {
        Pager pager = userService.getBrushhandCertList(page, limit, phone);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/cert", method = RequestMethod.POST)
    public Response cert(@RequestParam("id") Long id, @RequestParam("status") Integer status) {
        if (userService.cert(id, status)) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(
        @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "taobaoAccount", required = false) String taobaoAccount,
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = userService.getBrushhandList(phone, taobaoAccount, start, end, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/blacklist", method = RequestMethod.POST)
    public Response blacklist(@RequestParam("id") Long id) {
        if (userService.blacklist(id)) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/notblacklist", method = RequestMethod.POST)
    public Response notblacklist(@RequestParam("id") Long id) {
        if (userService.notblacklist(id)) {
            return Response.success();
        } else {
            return Response.error();
        }
    }
}