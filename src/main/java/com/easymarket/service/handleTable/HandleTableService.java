package com.easymarket.service.handleTable;

import com.alibaba.fastjson.JSONObject;

public interface HandleTableService {
    String createTable(JSONObject jsonObject);

    void getTableInfo(JSONObject jsonObject);
}
