package com.easymarket.controller;


import com.alibaba.fastjson.JSONObject;
import com.easymarket.entity.Response;
import com.easymarket.entity.TemplateInfoEntity;
import com.easymarket.service.handleTemplate.HandleTemplateService;
import com.easymarket.service.handleUserTemplate.UserTemplateService;
import com.easymarket.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/template")
public class HandleTemplate {

    @Autowired
    private HandleTemplateService handleTemplateService;

    @Autowired
    private UserTemplateService userTemplateService;

    @PostMapping(value = "/save/templateInfo")
    public Response saveTemplateInfo(@RequestBody JSONObject jsonObject) {
        handleTemplateService.saveTemplateInfo(jsonObject);
        return ResponseUtil.success();
    }

    @PostMapping(value = "/save/userTemplate")
    public Response saveUserTemplate(@RequestBody JSONObject jsonObject) {
        userTemplateService.saveUserTemplate(jsonObject);
        return ResponseUtil.success();
    }

    @PostMapping(value = "/getInfo")
    public Response getTemplateInfo(@RequestBody JSONObject jsonObject) {
        List<TemplateInfoEntity> templateList =  handleTemplateService.getTemplateInfo(jsonObject);
        return ResponseUtil.success(templateList);
    }
}
