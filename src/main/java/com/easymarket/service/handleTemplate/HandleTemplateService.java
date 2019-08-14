package com.easymarket.service.handleTemplate;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface HandleTemplateService {
    void saveTemplateInfo(JSONObject jsonObject);

    List getTemplateInfo(JSONObject jsonObject);
}
