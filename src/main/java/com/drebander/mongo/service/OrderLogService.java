package com.drebander.mongo.service;

import com.drebander.mongo.pojo.OrderLog;

import java.util.List;
import java.util.Map;

public interface OrderLogService {


    List<Map> getByOrderNoListMap(String orderNo);

    List<OrderLog> getByOrderNo(String orderNo);

    List<OrderLog> getByOrderNoLike(String orderNo);

    void saveOrder(OrderLog order);

    void removeOrderByOrderNo(String orderNo);

    void updateOrder(OrderLog order);


}
