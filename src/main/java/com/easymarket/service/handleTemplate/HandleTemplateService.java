package com.easymarket.service.handleTemplate;


import com.alibaba.fastjson.JSONObject;
import com.easymarket.entity.TemplateInfoEntity;

import java.util.List;

public interface HandleTemplateService {
    void saveTemplateInfo(JSONObject jsonObject);

    List getTemplateInfo(JSONObject jsonObject);
}
