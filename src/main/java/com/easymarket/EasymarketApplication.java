package com.easymarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.easymarket.controller", "com.easymarket.service", "com.easymarket.conf", "com.easymarket.utils"})
@MapperScan("com.easymarket.dao")
@EnableAsync
@EnableSwagger2
public class EasymarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasymarketApplication.class, args);
    }

}
