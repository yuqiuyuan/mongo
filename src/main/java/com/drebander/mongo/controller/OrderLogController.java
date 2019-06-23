package com.drebander.mongo.controller;

import com.drebander.mongo.pojo.OrderLog;
import com.drebander.mongo.service.OrderLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderLogController {

    @Resource
    private OrderLogService orderLogService;

    @RequestMapping("/saveOrder")
    @ResponseBody
    public String saveOrder() {

        OrderLog orderLog = new OrderLog();
        orderLog.setLogType("Exception");
        orderLog.setOrderNo("110250105");
        orderLogService.saveOrder(orderLog);

        return "OK";
    }

    @RequestMapping("/getOrderByOrderNo")
    @ResponseBody
    public OrderLog getOrderByOrderNo() {
        OrderLog orderLog = orderLogService.getByOrderNo("X797466");
        return orderLog;
    }

    @RequestMapping("/getOrderByOrderNoLike")
    @ResponseBody
    public OrderLog getOrderByOrderNoLike() {
        OrderLog order = orderLogService.getByOrderNoLike("X797");
        return order;
    }

    @RequestMapping("/removeOrderByOrderNo")
    @ResponseBody
    public String removeOrderByOrderNo() {
        orderLogService.removeOrderByOrderNo("X797468");
        return "OK";
    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public String updateOrder() {
        OrderLog order = new OrderLog();
        order.setLogType("Justin Timberlake");
        order.setOrderNo("X797467");
        orderLogService.updateOrder(order);
        return "OK";
    }

}
