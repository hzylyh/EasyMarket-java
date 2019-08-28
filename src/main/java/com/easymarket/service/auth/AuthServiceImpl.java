package com.easymarket.service.auth;

import com.easymarket.dao.UserDao;
import com.easymarket.entity.UserEntity;
import com.easymarket.utils.JWTUtil;
import com.easymarket.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserEntity verifyUser(UserEntity userEntity) {
        UserEntity resUser = userDao.selectOneUser(userEntity.getUsername());
        if (null != resUser && resUser.getPassword().equals(userEntity.getPassword())) {
            String token = JWTUtil.generateToken(userEntity.getUsername());
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("token", token);
            userInfo.put("userId", resUser.getId());
            userInfo.put("username", resUser.getUsername());
            redisUtil.set(userEntity.getUsername(), userInfo, 1200);
            resUser.setPassword(null);
            return resUser;
        } else {
            log.info("密码错误");
            return null;
        }
    }

    @Override
    public void removeAuth(UserEntity userEntity) {
        redisUtil.del(userEntity.getUsername());
    }

    @Override
    public boolean register(UserEntity u) {
        UserEntity resUser = userDao.selectOneUser(u.getUsername());
        if (null == resUser) {
            userDao.insertUser(u);
            return true;
        } else {
            return false;
        }
    }
}
