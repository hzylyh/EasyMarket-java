package com.easymarket.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HandleTableDao {
    void createTable(@Param("tableName") String tableName, @Param("columns")List<String> columns);

    List getTableInfo(@Param("tableName") String tableName);
}
