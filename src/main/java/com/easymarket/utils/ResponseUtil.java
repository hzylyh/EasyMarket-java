package com.easymarket.utils;

import com.easymarket.conf.ResultEnum;
import com.easymarket.entity.Response;

public class ResponseUtil {

    public static Response success(Object data) {
        Response response = new Response(ResultEnum.SUCCESS);
        response.setData(data);
        return response;
    }

    public static Response success(){
        return success(null);
    }

    public static Response error(ResultEnum resultEnum){
        Response response = new Response();
        response.setCode(resultEnum.getCode());
        response.setMsg(resultEnum.getMsg());
        return response;
    }

    public static Response error(String code, String msg){
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
