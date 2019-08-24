package com.easymarket.VO;

import lombok.Data;

@Data
public class TemplateInfoVO {
    private String templateId;
    private String templateName;
    private Integer viewCount;
    private Integer registerCount;
    private String templateInfo;
}
