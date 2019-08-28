package com.easymarket.controller;


import com.alibaba.fastjson.JSONObject;
import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.entity.Response;
import com.easymarket.entity.TemplateInfoEntity;
import com.easymarket.service.handleTemplate.HandleTemplateService;
import com.easymarket.service.handleUserTemplate.UserTemplateService;
import com.easymarket.utils.ResponseUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/template")
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
    public Response saveTemplateInfo(@RequestBody JSONObject jsonObject) {
        handleTemplateService.saveTemplateInfo(jsonObject);
        return ResponseUtil.success();
    }

    @PostMapping(value = "/save/userTemplate")
    public Response saveUserTemplate(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        Map templateId = userTemplateService.saveUserTemplate(jsonObject, request);
        return ResponseUtil.success(templateId);
    }

//    @PostMapping(value = "/getInfo")
//    public Response getTemplateInfo(@RequestBody JSONObject jsonObject) {
//        List<TemplateInfoEntity> templateList =  handleTemplateService.getTemplateInfo(jsonObject);
//        return ResponseUtil.success(templateList);
//    }

    @PostMapping(value = "/get/templateInfo")
    public Response getTemplateInfo(@RequestBody JSONObject jsonObject) {
        TemplateInfoVO template =  userTemplateService.getTempInfo(jsonObject);
        return ResponseUtil.success(template);
    }

    @PostMapping(value = "/del/templateInfo")
    public Response delTemplateInfo(@RequestBody JSONObject jsonObject) {
        userTemplateService.delTempInfo(jsonObject);
        return ResponseUtil.success();
    }

    @PostMapping(value = "/get/templateList")
    public Response getTemplateList(@RequestBody JSONObject jsonObject) {
        PageInfo<TemplateInfoVO> templateList =  userTemplateService.getTempList(jsonObject);
        return ResponseUtil.success(templateList);
    }

    @PostMapping(value = "/submit/form")
    public Response submitForm(@RequestBody JSONObject jsonObject) {
        userTemplateService.submitForm(jsonObject);
        return ResponseUtil.success();
    }

    @PostMapping(value = "/visit")
    public Response submitVisitInfo(@RequestBody JSONObject jsonObject) {
        userTemplateService.submitVisitInfo(jsonObject);
        return ResponseUtil.success();
    }
}
