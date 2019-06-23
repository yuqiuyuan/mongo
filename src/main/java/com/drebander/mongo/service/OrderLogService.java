package com.drebander.mongo.service;

import com.drebander.mongo.pojo.OrderLog;

public interface OrderLogService {


    OrderLog getByOrderNo(String orderNo);

    OrderLog getByOrderNoLike(String orderNo);

    void saveOrder(OrderLog order);

    void removeOrderByOrderNo(String orderNo);

    void updateOrder(OrderLog order);


}
