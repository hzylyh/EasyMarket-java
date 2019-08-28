package com.easymarket.service.handleUserTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.entity.TemplateInfoEntity;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserTemplateService {
    Map saveUserTemplate(JSONObject jsonObject, HttpServletRequest request);

    TemplateInfoVO getTempInfo(JSONObject jsonObject);

    void submitForm(JSONObject jsonObject);

    void submitVisitInfo(JSONObject jsonObject);

    PageInfo<TemplateInfoVO> getTempList(JSONObject jsonObject);

    void delTempInfo(JSONObject jsonObject);
}
