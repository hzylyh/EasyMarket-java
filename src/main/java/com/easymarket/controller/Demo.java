package com.easymarket.controller;


import com.easymarket.service.demo.DemoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/v1/demo")
public class Demo {
    @Autowired
    private DemoService demoService;

    @ApiOperation(value="demo样例", notes="demo样例")
    @GetMapping(value = "/demo1")
    public void demo1() {
        log.info(demoService.demo1());
    }
}
