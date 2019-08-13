package com.xiaorui.smartweb.service.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo1() {
        return "my test";
    }
}
