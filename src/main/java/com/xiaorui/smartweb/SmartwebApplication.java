package com.xiaorui.smartweb;

import org.springframework.boot.SpringApplication;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaorui.smartweb.controller", "com.xiaorui.smartweb.service", "com.xiaorui.smartweb.conf"})
//@MapperScan("com.xiaorui.smartweb.dao")
@EnableAsync
public class SmartwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartwebApplication.class, args);
    }

}
