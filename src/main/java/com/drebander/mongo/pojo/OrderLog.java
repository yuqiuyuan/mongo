package com.drebander.mongo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 订单日志实体类
 * <p>
 * 第一个属性id可要可不要，MongoDB建议使用自带的_id作为主键，这样不会重复；另外如果实体和表名不一致可以使用
 *
 * @Document 注解指定，使用方法如下：
 * @Document(collection="orderInfo") 如果属性和数据库字段不同可以使用@Field("字段名")  指定
 */
@Document(collection = "orderInfo")
public class OrderLog {

    private String orderNo;
    private String logType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}
