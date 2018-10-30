package com.douyaer.cms.controller;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.ComplaintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "phone", required = false) String phone) {
        Pager pager = complaintService.list(page, limit, phone);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Response handle(@RequestParam("id") Long id) {
        if (complaintService.handle(id)) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

}