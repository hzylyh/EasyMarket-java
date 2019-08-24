package com.easymarket.dao;

import com.easymarket.entity.TemplateInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HandleTemplateDao {
    void saveTemplateInfo(@Param("templateInfo") String templateInfo);

    List<TemplateInfoEntity> getTemplateInfo(@Param("templateId") Integer templateId);
}
