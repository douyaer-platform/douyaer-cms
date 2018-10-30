package com.douyaer.cms.controller;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.InviteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invite")
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "descPhone", required = false) String descPhone,
        @RequestParam(value = "taobaoAccount", required = false) String taobaoAccount,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = inviteService.list(phone, descPhone, taobaoAccount, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

}