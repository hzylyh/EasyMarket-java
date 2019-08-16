package com.easymarket.conf;

public class MyException extends RuntimeException {

    private String errCode;

    private String errMsg;

    public MyException(String code, String msg) {
        super(msg);
        this.errCode = code;
        this.errMsg = msg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
