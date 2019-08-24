package com.easymarket.controller;

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
@RequestMapping(value = "/api/user")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping(value = "/login")
    public Response login(@RequestBody UserEntity u) {
        UserEntity res = authService.verifyUser(u);
        if (null != res) {
//            Map<String, Object> loginRes = new HashMap<String, Object>();
//            loginRes.put("token", redisUtil.get(u.getUsername()));
//            loginRes.put("userId", res.getId());
//            loginRes.put("username", res.getUsername());
            return ResponseUtil.success(redisUtil.get(u.getUsername()));
        }else {
            return ResponseUtil.error(ResultEnum.UP_NOT_MATCH);
        }

    }

    @PostMapping(value = "/logout")
    public Response logout(@RequestBody UserEntity userEntity) {
        authService.removeAuth(userEntity);
        return ResponseUtil.success("退出成功");
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
