package com.easymarket.entity;


import lombok.Data;

@Data
public class UserTemplateEntity {
    private Integer id;
    private Integer userId;
    private String templateId;
    private String templateName;
    private String templateInfo;
    private Boolean isPreview;
    private Long createTime;
    private Long modifyTime;
}
