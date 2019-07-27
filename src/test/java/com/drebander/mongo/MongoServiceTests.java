package com.drebander.mongo;


import com.drebander.mongo.pojo.OrderLog;
import com.drebander.mongo.service.OrderLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceTests {
    @Autowired
    OrderLogService orderLogService;

    @Test
    public void testInsertLog() {
        OrderLog log1 = new OrderLog();
        log1.setLogType("Charging");
        log1.setOrderNo("110250109");
        orderLogService.saveOrder(log1);
        OrderLog log2 = new OrderLog();
        log2.setLogType("Exception");
        log2.setOrderNo("110250109");
        orderLogService.saveOrder(log2);
    }
    @Test
    public void testLikeLog(){
         orderLogService.getByOrderNoLike("110");
    }
}
