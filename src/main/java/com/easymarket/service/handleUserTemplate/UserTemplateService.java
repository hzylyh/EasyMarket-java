package com.easymarket.service.handleUserTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.entity.TemplateInfoEntity;

import java.util.List;
import java.util.Map;

public interface UserTemplateService {
    Map saveUserTemplate(JSONObject jsonObject);

    TemplateInfoVO getTempInfo(JSONObject jsonObject);
}
