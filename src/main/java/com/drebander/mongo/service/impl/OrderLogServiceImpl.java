package com.drebander.mongo.service.impl;

import com.drebander.mongo.dao.OrderLogDao;
import com.drebander.mongo.pojo.OrderLog;
import com.drebander.mongo.service.OrderLogService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private OrderLogDao orderLogDao;

    public OrderLog getByOrderNo(String orderNo) {

        return orderLogDao.getByOrderNo(orderNo);
    }


    public void saveOrder(OrderLog OrderLog) {
        orderLogDao.save(OrderLog);

    }

    public OrderLog getByOrderNoLike(String orderNo) {

        return orderLogDao.getByOrderNoLike(orderNo);
    }

    public void removeOrderByOrderNo(String orderNo) {
        Query q = new Query(new Criteria("orderNo").is(orderNo));
        mongoTemplate.remove(q, OrderLog.class);
    }

    public void updateOrder(OrderLog OrderLog) {
        Query q = new Query(new Criteria("orderNo").is(OrderLog.getOrderNo()));
        Update update = new Update().set("logType", OrderLog.getLogType());
        mongoTemplate.updateMulti(q, update, OrderLog.class);
    }


}
