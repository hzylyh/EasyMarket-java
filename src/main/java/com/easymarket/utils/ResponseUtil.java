package com.easymarket.utils;

import com.easymarket.vo.Response;

public class ResponseUtil {

    public static Response success(Object data) {
        Response response = new Response();
        response.setCode("20000");
        response.setMsg("请求成功");
        response.setData(data);
        return response;
    }

    public static Response success(){
        return success(null);
    }

    public static Response error(String code,String msg){
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
