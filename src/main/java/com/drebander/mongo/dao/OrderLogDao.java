package com.drebander.mongo.dao;

import com.drebander.mongo.pojo.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLogDao extends MongoRepository<OrderLog, Integer> {
    OrderLog getByOrderNo(String orderId);

    OrderLog getByOrderNoLike(String orderId);
}
