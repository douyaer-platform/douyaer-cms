package com.douyaer.cms.controller;

import javax.servlet.http.HttpServletRequest;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.pojo.Admin;
import com.douyaer.cms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business")
public class BusinessController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/certList", method = RequestMethod.GET)
    public Response verifyList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "phone", required = false) String phone) {
        Pager pager = userService.getBusinessCertList(page, limit, phone);
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
    public Response list(@RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "alitm", required = false) String alitm,
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = userService.getBusinessList(phone, alitm, start, end, page, limit);
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

    @RequestMapping(value = "/addIntegral", method = RequestMethod.POST)
    public Response addIntegral(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("integral") Integer integral) {
        if (integral <= 0) {
            return Response.error("参数错误");
        }
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (userService.addIntegral(id, integral, "" + admin.getId())) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/removeIntegral", method = RequestMethod.POST)
    public Response removeIntegral(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("integral") Integer integral) {
        if (integral <= 0) {
            return Response.error("参数错误");
        }
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (userService.removeIntegral(id, integral, "" + admin.getId())) {
            return Response.success();
        } else {
            return Response.error();
        }
    }
}