package com.easymarket.dao;

import com.easymarket.VO.TemplateInfoVO;
import com.easymarket.entity.UserTemplateEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UserTemplateDao {
    void saveUserTemplate(UserTemplateEntity userTemplateEntity);

    TemplateInfoVO selectTempInfo(@Param("templateId") String templateId);

    List<TemplateInfoVO> selectTempList(@Param("userId") String userId, @Param("isPreview") Boolean isPreview);

    void updateUserTemplate(UserTemplateEntity userTemplateEntity);
}
