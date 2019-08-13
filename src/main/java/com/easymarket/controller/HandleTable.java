package com.easymarket.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easymarket.service.handleTable.HandleTableService;
import com.easymarket.utils.ResponseUtil;
import com.easymarket.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1")
public class HandleTable {

    @Autowired
    private HandleTableService handleTableService;

    @PostMapping(value = "/table/create")
    public Response createTable(@RequestBody JSONObject jsonObject) {
        handleTableService.createTable(jsonObject);
        return ResponseUtil.success();
    }
}
