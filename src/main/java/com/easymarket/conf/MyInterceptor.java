package com.easymarket.conf;

import com.alibaba.fastjson.JSONObject;
import com.easymarket.entity.Response;
import com.easymarket.utils.JWTUtil;
import com.easymarket.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截了");
//        System.out.println(request.getRequestURI());
        String reqToken = request.getHeader("Authorization");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        if (reqToken != null) {
            String userId = JWTUtil.getUserId(reqToken);
            Map<String, Object> userInfo = (Map<String, Object>) redisUtil.get(userId);
            if (userInfo != null) {
                String tokenInRedis = (String) userInfo.get("token");
                if (tokenInRedis.equals(reqToken)) {
                    return true;
                } else {
                    PrintWriter printWriter = response.getWriter();
                    Response res = new Response(ResultEnum.USER_OUT_VALID);
//                printWriter.write("{\"code\":\"21001\",\"message\":\"not login!\"}");
                    printWriter.write(JSONObject.toJSONString(res));
                    return false;
                }
            } else {
                PrintWriter printWriter = response.getWriter();
                Response res = new Response(ResultEnum.USER_OUT_VALID);
//                printWriter.write("{\"code\":\"21001\",\"message\":\"not login!\"}");
                printWriter.write(JSONObject.toJSONString(res));
                return false;
            }
        }else {
            PrintWriter printWriter = response.getWriter();
            Response res = new Response();
            res.setCode("21002");
            res.setMsg("未登录");
//            printWriter.write("{\"code\":\"21001\",\"message\":\"not login!\"}");
            printWriter.write(JSONObject.toJSONString(res));
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
