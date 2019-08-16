package com.easymarket.conf;

import com.easymarket.utils.JWTUtil;
import com.easymarket.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截了");
        System.out.println(request.getRequestURI());
        String reqToken = request.getHeader("Authorization");


        if (reqToken != null) {
            String userId = JWTUtil.getUserId(reqToken);
            String tokenInRedis = (String) redisUtil.get(userId);
            if (tokenInRedis != null && tokenInRedis.equals(reqToken)) {
                return true;
            } else {
                PrintWriter printWriter = response.getWriter();
                printWriter.write("{\"code\":\"21001\",\"message\":\"not login!\"}");
                return false;
            }
        }else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{\"code\":\"21001\",\"message\":\"not login!\"}");
            return false;
        }
//        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
