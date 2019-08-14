package com.easymarket.entity;


import lombok.Data;

@Data
public class UserTemplateEntity {
    private Integer userId;
    private Integer templateId;
    private String customTemplate;
}
