package com.douyaer.cms.controller;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "taobaoAccount", required = false) String taobaoAccount,
        @RequestParam("page") Integer page, 
        @RequestParam("limit") Integer limit) {
        Pager pager = taskService.list(phone, taobaoAccount, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

    @RequestMapping(value = "/cert", method = RequestMethod.POST)
    public Response cert(@RequestParam("id") String id, @RequestParam("status") int status) {
        if (taskService.cert(id, status)) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

}