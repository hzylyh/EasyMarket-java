package com.easymarket.service.handleUserTemplate;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.dao.HandleTemplateDao;
import com.easymarket.dao.TemplateDetailDao;
import com.easymarket.dao.UserTemplateDao;
import com.easymarket.dao.VisitDetailDao;
import com.easymarket.entity.TemplateDetailEntity;
import com.easymarket.entity.UserTemplateEntity;
import com.easymarket.entity.VisitDetailEntity;
import com.easymarket.utils.IDGenerate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTemplateServiceImpl implements UserTemplateService {

    @Autowired
    private UserTemplateDao userTemplateDao;

    @Autowired
    private HandleTemplateDao handleTemplateDao;

    @Autowired
    private TemplateDetailDao templateDetailDao;

    @Autowired
    private VisitDetailDao visitDetailDao;

    @Override
    public Map saveUserTemplate(JSONObject jsonObject) {
        String templateId = jsonObject.getString("templateId");
        UserTemplateEntity userTemplateEntity = new UserTemplateEntity();
        if (null == templateId) {
            userTemplateEntity.setUserId(1);
            templateId = IDGenerate.getID();
            userTemplateEntity.setTemplateId(templateId);
            userTemplateEntity.setTemplateInfo(jsonObject.getString("templateInfo"));
            userTemplateEntity.setTemplateName(jsonObject.getString("templateName"));
            userTemplateDao.saveUserTemplate(userTemplateEntity);
            Map res = new HashMap();
            res.put("templateId", templateId);
            return res;
        } else {
            System.out.println("xiugai");
            userTemplateEntity.setTemplateId(templateId);
            userTemplateEntity.setTemplateInfo(jsonObject.getString("templateInfo"));
            userTemplateEntity.setTemplateName(jsonObject.getString("templateName"));
            userTemplateDao.updateUserTemplate(userTemplateEntity);
            return null;
        }

    }

    @Override
    public TemplateInfoVO getTempInfo(JSONObject jsonObject) {
        TemplateInfoVO res = userTemplateDao.selectTempInfo(jsonObject.getString("templateId"));
        return res;
    }

    @Override
    public void submitForm(JSONObject jsonObject) {
        TemplateDetailEntity templateDetailEntity = new TemplateDetailEntity();
        templateDetailEntity.setUsername(jsonObject.getString("username"));
        templateDetailEntity.setPhone(jsonObject.getString("phone"));
        templateDetailEntity.setTemplateId(jsonObject.getString("templateId"));
        templateDetailEntity.setComeSite(jsonObject.getString("comeSite"));
        templateDetailDao.insertRegisterInfo(templateDetailEntity);
    }

    @Override
    public void submitVisitInfo(JSONObject jsonObject) {
        VisitDetailEntity visitDetailEntity = new VisitDetailEntity();
        visitDetailEntity.setTemplateId(jsonObject.getString("templateId"));
        visitDetailEntity.setComeSite(jsonObject.getString("comeSite"));
        visitDetailDao.insertVisitInfo(visitDetailEntity);
    }

    @Override
    public PageInfo<TemplateInfoVO> getTempList(JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        Integer pageNum = jsonObject.getInteger("pageNum");
        Integer pageSize = jsonObject.getInteger("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<TemplateInfoVO> templateInfoVOList = userTemplateDao.selectTempList(userId);
        PageInfo<TemplateInfoVO> result = new PageInfo<TemplateInfoVO>(templateInfoVOList);
        return result;
    }

    @Override
    public void delTempInfo(JSONObject jsonObject) {
        String templateId = jsonObject.getString("templateId");
    }

}
