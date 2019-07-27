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
import java.util.List;
import java.util.Map;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private OrderLogDao orderLogDao;

    /**
     * 通过集合名称+过滤条件查询mongodb中的数据
     *
     * 这个方法的优点是不需要实体
     *
     * @param orderNo
     * @return
     */
    @Override
    public List<Map> getByOrderNoListMap(String orderNo) {
        Query q = new Query(new Criteria("orderNo").regex(".*" + orderNo + ".*"));
        return mongoTemplate.find(q,Map.class,"orderInfo");
    }

    public List<OrderLog> getByOrderNo(String orderNo) {
        return orderLogDao.getByOrderNo(orderNo);
    }


    public void saveOrder(OrderLog OrderLog) {
        orderLogDao.save(OrderLog);

    }

    public List<OrderLog> getByOrderNoLike(String orderNo) {
        Query q = new Query(new Criteria("orderNo").regex(".*" + orderNo + ".*"));
        return mongoTemplate.findAllAndRemove(q, OrderLog.class);
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
