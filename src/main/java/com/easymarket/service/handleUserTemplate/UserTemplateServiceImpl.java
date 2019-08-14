package com.easymarket.service.handleUserTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.dao.UserTemplateDao;
import com.easymarket.entity.UserTemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTemplateServiceImpl implements UserTemplateService {

    @Autowired
    private UserTemplateDao userTemplateDao;

    @Override
    public void saveUserTemplate(JSONObject jsonObject) {
        UserTemplateEntity userTemplateEntity = new UserTemplateEntity();
        userTemplateEntity.setUserId(1);
        userTemplateEntity.setTemplateId(jsonObject.getInteger("templateId"));
        userTemplateEntity.setCustomTemplate(jsonObject.getString("customTemplate"));
        userTemplateDao.saveUserTemplate(userTemplateEntity);
    }
}
