package com.drebander.mongo.pojo.query;

import java.io.Serializable;
import java.util.List;

/**
 * chargehub日志查询实体
 *
 * @Author 虞秋元
 * @CreateTime 2019-07-25
 */
public class ChargeHubLogQuery implements Serializable {
    /**
     * 日志级别
     */
    private String level;
    /**
     * 日志名称
     */
    private String loggerName;
    /**
     * 日志内容关键字
     */
    private List<String> messageKey;

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

    public List<String> getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(List<String> messageKey) {
        this.messageKey = messageKey;
    }
}
