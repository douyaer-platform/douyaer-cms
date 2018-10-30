package com.douyaer.cms.controller;

import com.douyaer.cms.model.Pager;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.service.CoinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end, 
            @RequestParam("page") Integer page,
            @RequestParam("limit") Integer limit) {
        Pager pager = coinService.list(phone, id, start, end, page, limit);
        if (pager != null) {
            return Response.success(pager.total, pager.list);
        } else {
            return Response.error();
        }
    }

}