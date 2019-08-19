package com.easymarket.entity;

import com.easymarket.conf.ResultEnum;
import lombok.Data;

@Data
public class Response<T> {
    private String code;//状态码

    private String msg;//信息

    private T data;//数据

    public Response() {

    }

    public Response(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
