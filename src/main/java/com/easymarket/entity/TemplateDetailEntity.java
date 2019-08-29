package com.easymarket.entity;

import lombok.Data;

@Data
public class TemplateDetailEntity {
    private Integer id;
    private String username;
    private String phone;
    private String templateId;
    private String sourceIP;
    private String comeSite;
    private Long registerTime;
}
