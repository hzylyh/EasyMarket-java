package com.easymarket.service.handleTable;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.dao.HandleTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HandleTableServiceImpl implements HandleTableService {

    @Autowired
    private HandleTableDao handleTableDao;

    @Override
    public String createTable(JSONObject jsonObject) {
        String tableName = jsonObject.getString("tableName");
        List columns = jsonObject.getJSONArray("columns");
        handleTableDao.createTable(tableName, columns);
        return null;
    }
}
