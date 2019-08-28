package com.easymarket.conf;

public enum  ResultEnum {
    // 成功
    SUCCESS("000000", "请求成功"),

    // 登录错误，用户名密码错误
    UP_NOT_MATCH("300001", "登录名或密码错误"),

    // 用户名已存在
    ALREADY_EXIST("300002", "用户名已存在"),

    // 登录超时
    USER_OUT_VALID("300003", "登录超时，请重新登录"),

    // 上传异常
    UPLOAD_FILE_EMPTY("310001", "文件不能为空"),

    //系统错误，空指针
    SYSTEM_NULL_POINT("500001", "系统错误，空指针异常"),

    //系统错误
    SYSTEMT_TEST("500001", "系统错误，测试")


    ;



    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
