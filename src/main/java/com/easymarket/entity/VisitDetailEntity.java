package com.easymarket.entity;

import lombok.Data;

@Data
public class VisitDetailEntity {
    private Integer id;
    private String templateId;
    private String comeSite;
    private Long visitTime;
}
