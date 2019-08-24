package com.easymarket.entity;

import lombok.Data;

@Data
public class TemplateInfoEntity {
    /**
     * 模板ID
     */
    private Integer id;

    /**
     * 浏览次数
     */
    private Integer viewCount;

    /**
     * 使用次数
     */
    private Integer userCount;

    /**
     * 模板信息
     */
    private String templateInfo;
}
