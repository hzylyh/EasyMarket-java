package com.easymarket.entity;

import lombok.Data;

@Data
public class TemplateInfoEntity {
    private Integer id;
    private Integer viewCount;
    private Integer userCount;
    private String templateInfo;
}
