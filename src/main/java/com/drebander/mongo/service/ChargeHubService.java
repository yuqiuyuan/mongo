package com.drebander.mongo.service;


import com.drebander.mongo.pojo.ChargeHubLog;
import com.drebander.mongo.pojo.ChargeOrderReport;

import java.util.List;

public interface ChargeHubService {

    List<ChargeHubLog> getQueryList(String key);

    ChargeOrderReport getValidMethodByOrder(String orderNo);

    ChargeOrderReport getValidMethodByOrder2(String orderNo);

    ChargeOrderReport getChargeOrderReport(String orderNo);
}
