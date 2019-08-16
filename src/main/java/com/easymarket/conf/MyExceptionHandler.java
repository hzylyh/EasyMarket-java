package com.easymarket.conf;


import com.easymarket.entity.Response;
import com.easymarket.utils.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public Response errHandler(MyException e) {
        e.printStackTrace();
        return ResponseUtil.error(e.getErrCode(), e.getErrMsg());
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public Response errHandler(ArithmeticException e) {
        e.printStackTrace();
        return ResponseUtil.error("123", "14414");
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Response errHandler(NullPointerException e) {
        e.printStackTrace();
        return ResponseUtil.error("123", "空指针了");
    }
}
