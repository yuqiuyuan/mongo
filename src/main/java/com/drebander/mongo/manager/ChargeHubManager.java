package com.drebander.mongo.manager;


import com.drebander.mongo.pojo.ChargeHubLog;
import com.drebander.mongo.pojo.query.ChargeHubLogQuery;

import java.util.List;
import java.util.Map;


public interface ChargeHubManager {
    List<ChargeHubLog> getListByContentLike(String... keys);

    List<Map> getQueryList(ChargeHubLogQuery query);

    Map getQueryOne(ChargeHubLogQuery query);

}
