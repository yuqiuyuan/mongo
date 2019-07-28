package com.drebander.mongo.service.impl;

import com.drebander.mongo.annotation.LoggerName;
import com.drebander.mongo.manager.ChargeHubManager;
import com.drebander.mongo.pojo.ChargeHubLog;
import com.drebander.mongo.pojo.ChargeOrderReport;
import com.drebander.mongo.pojo.query.ChargeHubLogQuery;
import com.drebander.mongo.service.ChargeHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class ChargeHubServiceImpl implements ChargeHubService {

    @Autowired
    ChargeHubManager chargeHubManager;


    @Override
    public List<ChargeHubLog> getQueryList(String key) {
        return null;
    }


    @Override
    public ChargeOrderReport getValidMethodByOrder(String orderNo) {
        ChargeOrderReport charOrderReport = new ChargeOrderReport();
        List<ChargeHubLog> logs = chargeHubManager.getListByContentLike(orderNo);
        logs.forEach(item -> writeOrderReport(charOrderReport, item, "已推送"));
        logs = chargeHubManager.getListByContentLike(orderNo);
        logs.forEach(item -> writeOrderReport(charOrderReport, item, "已返回"));
        return charOrderReport;
    }

    /**
     * 仅使用订单号进行查找
     *
     * @param orderNo
     * @return
     */
    @Override
    public ChargeOrderReport getValidMethodByOrder2(String orderNo) {
        ChargeOrderReport charOrderReport = new ChargeOrderReport();
        ChargeHubLogQuery query = new ChargeHubLogQuery();
        query.setMessageKey(Arrays.asList(orderNo));
        List<Map> logs = chargeHubManager.getQueryList(query);
        logs.forEach(item -> writeOrderReport(charOrderReport, item, "已推送"));
        return charOrderReport;
    }

    /**
     * 目前认为这种方法是最靠谱的方法
     * 日志名称+方法名+订单号 对日志进行查找
     *
     * @param orderNo
     * @return
     */
    @Override
    public ChargeOrderReport getChargeOrderReport(String orderNo) {
        ChargeOrderReport charOrderReport = new ChargeOrderReport();
        Field[] fields = charOrderReport.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            ChargeHubLogQuery query = new ChargeHubLogQuery();
            query.setLoggerName(fields[i].getName());
            query.setMessageKey(Arrays.asList(fields[i].getName(), orderNo));
            Map log = chargeHubManager.getQueryOne(query);
            try {
                fields[i].setAccessible(true);
                if (null == log || log.isEmpty()) {
                    fields[i].set(charOrderReport, fields[i].getAnnotation(LoggerName.class).no());
                } else {
                    fields[i].set(charOrderReport, fields[i].getAnnotation(LoggerName.class).yes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return charOrderReport;
    }

    /**************************************私有方法************************************************/

    /**
     * 根据日志写报告
     *
     * @param charOrderReport
     * @param item
     */
    private void writeOrderReport(ChargeOrderReport charOrderReport, ChargeHubLog item, String content) {
        Field[] fields = charOrderReport.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (item.getMessage().contains(fields[i].getName())) {
                try {
                    fields[i].setAccessible(true);
                    fields[i].set(charOrderReport, content);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据日志写报告
     *
     * @param charOrderReport
     * @param item
     */
    private void writeOrderReport(ChargeOrderReport charOrderReport, Map<String, String> item, String content) {
        Field[] fields = charOrderReport.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (item.get("message").contains(fields[i].getName())) {
                try {
                    fields[i].setAccessible(true);
                    fields[i].set(charOrderReport, content);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
