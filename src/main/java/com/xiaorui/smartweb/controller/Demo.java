package com.xiaorui.smartweb.controller;


import com.alibaba.fastjson.JSONObject;
import com.xiaorui.smartweb.service.demo.DemoService;
import com.xiaorui.smartweb.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/v1/demo")
public class Demo {
    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/demo1")
    public void demo1() {
        log.info(demoService.demo1());
    }
}
