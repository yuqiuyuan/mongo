package com.drebander.mongo.pojo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * chargehub日志查询实体
 *
 * @Author 虞秋元
 * @CreateTime 2019-07-25
 */
@Document(collection = "chargehublog_test")
public class ChargeHubLog {

    @Id
    private String id;
    @Field("level")
    private String level;
    @Field("loggerName")
    private String loggerName;
    @Field("message")
    private String message;
//    @Field("source")
//    private Document source;
    @Field("marker")
    private Null marker;
    @Field("threadName")
    private String threadName;
    @Field("millis")
    private long millis;
    @Field("date")
    private Date date;
    @Field("thrown")
    private String thrown;
    @Field("contextMap")
    private Map<Object, Object> contextMap;
    @Field("contextStack")
    private List contextStack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public Document getSource() {
//        return source;
//    }
//
//    public void setSource(Document source) {
//        this.source = source;
//    }

    public Null getMarker() {
        return marker;
    }

    public void setMarker(Null marker) {
        this.marker = marker;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getThrown() {
        return thrown;
    }

    public void setThrown(String thrown) {
        this.thrown = thrown;
    }

    public Map<Object, Object> getContextMap() {
        return contextMap;
    }

    public void setContextMap(Map contextMap) {
        this.contextMap = contextMap;
    }

    public List getContextStack() {
        return contextStack;
    }

    public void setContextStack(List contextStack) {
        this.contextStack = contextStack;
    }
}
