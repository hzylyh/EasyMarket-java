package com.easymarket.controller;

import com.easymarket.conf.MyException;
import com.easymarket.conf.ResultEnum;
import com.easymarket.entity.Response;
import com.easymarket.entity.UserEntity;
import com.easymarket.service.auth.AuthService;
import com.easymarket.utils.RedisUtil;
import com.easymarket.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/v1/user")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping(value = "/login")
    public Response login(@RequestBody UserEntity u) {
        boolean res = authService.verifyUser(u);
        if (res) {
            Map<String, Object> token = new HashMap<String, Object>();
            token.put("token", redisUtil.get(u.getUsername()));
            return ResponseUtil.success(token);
        }else {
            return ResponseUtil.error(ResultEnum.UP_NOT_MATCH);
        }

    }

//    @PostMapping(value = "/test")
//    public Response test() {
//        return ResponseUtil.success();
//    }
//
//    @GetMapping(value = "/info")
//    public Response userInfo(@RequestParam(name = "token") String token) {
//        return ResponseUtil.success("{\"code\":\"20000\",\"data\":{\"roles\":[\"admin\"],\"name\":\"admin\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"}}");
//    }

}
