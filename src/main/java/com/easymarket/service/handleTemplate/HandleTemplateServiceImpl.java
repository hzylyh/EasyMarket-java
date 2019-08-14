package com.easymarket.service.handleTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.dao.HandleTemplateDao;
import com.easymarket.entity.TemplateInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandleTemplateServiceImpl implements HandleTemplateService {

    @Autowired
    private HandleTemplateDao handleTemplateDao;

    @Override
    public void saveTemplateInfo(JSONObject jsonObject) {
        TemplateInfoEntity templateInfoEntity = new TemplateInfoEntity();
        templateInfoEntity.setTemplateInfo(jsonObject.getString("templateInfo"));
        handleTemplateDao.saveTemplateInfo(templateInfoEntity);
    }

    @Override
    public List<TemplateInfoEntity> getTemplateInfo(JSONObject jsonObject) {
        Integer templateId = jsonObject.getInteger("templateId");
        List<TemplateInfoEntity> templateInfos = handleTemplateDao.getTemplateInfo(templateId);
        return templateInfos;
    }
}
