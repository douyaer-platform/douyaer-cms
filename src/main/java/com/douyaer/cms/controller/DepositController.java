package com.douyaer.cms.controller;

import javax.servlet.http.HttpServletRequest;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.pojo.Admin;
import com.douyaer.cms.service.DepositWithdrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

    @Autowired
    private DepositWithdrawService depositWithdrawService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@RequestParam("phone") String phone, @RequestParam("totalFee") Double totalFee, HttpServletRequest request) {
        if (totalFee <= 0) {
            return Response.error("费用不能小于或等于0");
        }
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        return depositWithdrawService.add(phone, totalFee, "deposit", admin.getId());
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public Response confirm(@RequestParam("id") Long id) {
        return depositWithdrawService.confirm(id);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = depositWithdrawService.getDepositList(phone, start, end, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }
    
}