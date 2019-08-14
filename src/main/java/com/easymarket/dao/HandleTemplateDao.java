package com.easymarket.dao;

import com.easymarket.entity.TemplateInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HandleTemplateDao {
    void saveTemplateInfo(TemplateInfoEntity templateInfoEntity);

    List<TemplateInfoEntity> getTemplateInfo(@Param("templateId") Integer templateId);
}
