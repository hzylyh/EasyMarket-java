package com.easymarket.service.handleUserTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.dao.HandleTemplateDao;
import com.easymarket.dao.UserTemplateDao;
import com.easymarket.entity.UserTemplateEntity;
import com.easymarket.utils.IDGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserTemplateServiceImpl implements UserTemplateService {

    @Autowired
    private UserTemplateDao userTemplateDao;

    @Autowired
    private HandleTemplateDao handleTemplateDao;

    @Override
    public Map saveUserTemplate(JSONObject jsonObject) {
        UserTemplateEntity userTemplateEntity = new UserTemplateEntity();
        userTemplateEntity.setUserId(1);
        String templateId = IDGenerate.getID();
        userTemplateEntity.setTemplateId(templateId);
        userTemplateEntity.setTemplateInfo(jsonObject.getString("templateInfo"));
        userTemplateDao.saveUserTemplate(userTemplateEntity);
        Map res = new HashMap();
        res.put("templateId", templateId);
        return res;
    }

    @Override
    public TemplateInfoVO getTempInfo(JSONObject jsonObject) {
        TemplateInfoVO res = userTemplateDao.selectTempInfo(jsonObject.getString("templateId"));
        return res;
    }
}
