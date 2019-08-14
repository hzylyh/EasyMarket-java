package com.easymarket.controller;


import com.alibaba.fastjson.JSONObject;
import com.easymarket.entity.Response;
import com.easymarket.entity.TemplateInfoEntity;
import com.easymarket.service.handleTemplate.HandleTemplateService;
import com.easymarket.service.handleUserTemplate.UserTemplateService;
import com.easymarket.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/v1/template", description = "操作模板对应接口")
public class HandleTemplate {

    @Autowired
    private HandleTemplateService handleTemplateService;

    @Autowired
    private UserTemplateService userTemplateService;

    @PostMapping(value = "/save/templateInfo")
    @ApiOperation(value="保存模板信息", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateInfo", value = "模板信息", required = true, dataType = "String",paramType = "String"),
    })
    public Response saveTemplateInfo(@RequestBody TemplateInfoEntity templateInfoEntity) {
        handleTemplateService.saveTemplateInfo(templateInfoEntity);
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
