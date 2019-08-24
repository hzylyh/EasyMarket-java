package com.easymarket.dao;

import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.entity.UserTemplateEntity;
import org.apache.ibatis.annotations.Param;

public interface UserTemplateDao {
    void saveUserTemplate(UserTemplateEntity userTemplateEntity);

    TemplateInfoVO selectTempInfo(@Param("templateId") String templateId);
}
