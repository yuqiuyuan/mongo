package com.drebander.mongo.dao;

import com.drebander.mongo.pojo.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderLogDao extends MongoRepository<OrderLog, Integer> {
    List<OrderLog> getByOrderNo(String orderId);

    List<OrderLog> getByOrderNoLike(String orderId);
}
