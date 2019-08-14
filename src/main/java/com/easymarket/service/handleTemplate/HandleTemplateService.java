package com.easymarket.service.handleTemplate;


import com.alibaba.fastjson.JSONObject;
import com.easymarket.entity.TemplateInfoEntity;

import java.util.List;

public interface HandleTemplateService {
    void saveTemplateInfo(TemplateInfoEntity templateInfoEntity);

    List getTemplateInfo(JSONObject jsonObject);
}
