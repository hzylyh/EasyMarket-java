package com.easymarket.entity;


import lombok.Data;

@Data
public class UserTemplateEntity {
    private Integer id;
    private Integer userId;
    private String templateId;
    private String templateInfo;
}
