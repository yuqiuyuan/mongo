package com.drebander.mongo.pojo;


import com.drebander.mongo.annotation.LoggerName;

public class ChargeOrderReport {

    /**
     * 开始充电
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已推送", no = "未推送")
    private String query_start_charge;
    /**
     * 通知开始充电结果
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已返回", no = "未返回")
    private String notification_start_charge_result;
    /**
     * 充电中状态查询
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已推送", no = "未推送")
    private String query_equip_charge_status;
    /**
     * 通知充电状态接口
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已返回", no = "未返回")
    private String notify_equip_charge_status;
    /**
     * 停止充电
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已推送", no = "未推送")
    private String query_stop_charge;
    /**
     * 通知停止充电结果
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已返回", no = "未返回")
    private String notification_stop_charge_result;
    /**
     * 通知订单信息
     */
    @LoggerName(value = "com.czb.chargehub.service.core.impl.ChargeHubPlatformImpl", yes = "已返回", no = "未返回")
    private String notification_charge_order_info;

    public String getQuery_start_charge() {
        return query_start_charge;
    }

    public void setQuery_start_charge(String query_start_charge) {
        this.query_start_charge = query_start_charge;
    }

    public String getNotification_start_charge_result() {
        return notification_start_charge_result;
    }

    public void setNotification_start_charge_result(String notification_start_charge_result) {
        this.notification_start_charge_result = notification_start_charge_result;
    }

    public String getQuery_equip_charge_status() {
        return query_equip_charge_status;
    }

    public void setQuery_equip_charge_status(String query_equip_charge_status) {
        this.query_equip_charge_status = query_equip_charge_status;
    }

    public String getNotify_equip_charge_status() {
        return notify_equip_charge_status;
    }

    public void setNotify_equip_charge_status(String notify_equip_charge_status) {
        this.notify_equip_charge_status = notify_equip_charge_status;
    }

    public String getQuery_stop_charge() {
        return query_stop_charge;
    }

    public void setQuery_stop_charge(String query_stop_charge) {
        this.query_stop_charge = query_stop_charge;
    }

    public String getNotification_stop_charge_result() {
        return notification_stop_charge_result;
    }

    public void setNotification_stop_charge_result(String notification_stop_charge_result) {
        this.notification_stop_charge_result = notification_stop_charge_result;
    }

    public String getNotification_charge_order_info() {
        return notification_charge_order_info;
    }

    public void setNotification_charge_order_info(String notification_charge_order_info) {
        this.notification_charge_order_info = notification_charge_order_info;
    }

    @Override
    public String toString() {
        return "ChargeOrderReport{" +
                "query_start_charge='" + query_start_charge + '\'' +
                ", notification_start_charge_result='" + notification_start_charge_result + '\'' +
                ", query_equip_charge_status='" + query_equip_charge_status + '\'' +
                ", notify_equip_charge_status='" + notify_equip_charge_status + '\'' +
                ", query_stop_charge='" + query_stop_charge + '\'' +
                ", notification_stop_charge_result='" + notification_stop_charge_result + '\'' +
                ", notification_charge_order_info='" + notification_charge_order_info + '\'' +
                '}';
    }
}
