package com.easymarket.conf;


import com.easymarket.entity.Response;
import com.easymarket.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public Response errHandler(MyException e) {
        log.error("", e);
        return ResponseUtil.error(e.getErrCode(), e.getErrMsg());
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public Response errHandler(ArithmeticException e) {
        log.error("", e);
        return ResponseUtil.error(ResultEnum.SYSTEMT_TEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Response errHandler(NullPointerException e) {
        log.error("", e);
        return ResponseUtil.error(ResultEnum.SYSTEM_NULL_POINT);
    }
}
