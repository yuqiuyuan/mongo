package com.drebander.mongo.manager.impl;

import com.drebander.mongo.manager.ChargeHubManager;
import com.drebander.mongo.pojo.ChargeHubLog;
import com.drebander.mongo.pojo.query.ChargeHubLogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ChargeHubManagerImpl implements ChargeHubManager {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * springBoot的环境变量，用于获取application中的配置
     */
    @Autowired
    private Environment env;
    /**
     * mongodb日志集合关键字
     */
    private static final String COLLECTION_KEY = "spring.log.mongodb.collection";
    /**
     * 日志中存储内容的key
     */
    private static final String LOG_MESSAGE_KEY = "message";
    /**
     * 日志存储中级别字段
     */
    private static final String LEVEL_FIELD = "level";
    /**
     * 日志名称字段
     */
    private static final String LOG_NAME_FIELD = "loggerName";

    @Override
    public List<ChargeHubLog> getListByContentLike(String... keys) {
        String regex = generateRegex(Arrays.asList(keys));
        Query q = new Query(new Criteria(LOG_MESSAGE_KEY).regex(regex));
        List<ChargeHubLog> list = mongoTemplate.find(q, ChargeHubLog.class);
        return list;
    }


    @Override
    public List<Map> getQueryList(ChargeHubLogQuery query) {
        String regex = generateRegex(query.getMessageKey());
        Criteria criteria = new Criteria(LOG_MESSAGE_KEY).regex(regex);
        if (null != query.getLevel()) {
            criteria.and(LEVEL_FIELD).is(query.getLevel());
        }
        if (null != query.getLoggerName()) {
            criteria.and(LOG_NAME_FIELD).is(query.getLoggerName());
        }
        List<Map> list = mongoTemplate.find(new Query(criteria), Map.class, env.getProperty(COLLECTION_KEY));
        return list;
    }

    @Override
    public Map getQueryOne(ChargeHubLogQuery query) {
        String regex = generateRegex(query.getMessageKey());
        Criteria criteria = new Criteria(LOG_MESSAGE_KEY).regex(regex);
        if (null != query.getLevel()) {
            criteria.and(LEVEL_FIELD).is(query.getLevel());
        }
        if (null != query.getLoggerName()) {
            criteria.and(LOG_NAME_FIELD).is(query.getLoggerName());
        }
        Map log = mongoTemplate.findOne(new Query(criteria), Map.class, env.getProperty(COLLECTION_KEY));
        return log;
    }

    //    *********************************    私有方法    ************************************

    /**
     * 按照指定关键字的顺序生成包含关键字的正则表达式
     * 此处用于message字段的匹配
     *
     * @param keys
     * @return
     */
    private String generateRegex(List<String> keys) {
        StringBuffer regex = new StringBuffer(".*");
        for (int i = 0; i < keys.size(); i++) {
            regex.append(keys.get(i)).append(".*");
        }
        return regex.toString();
    }
}
