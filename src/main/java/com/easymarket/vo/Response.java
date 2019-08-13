package com.easymarket.vo;

import lombok.Data;

@Data
public class Response<T> {
    private String code;//状态码

    private String msg;//信息

    private T data;//数据
}
