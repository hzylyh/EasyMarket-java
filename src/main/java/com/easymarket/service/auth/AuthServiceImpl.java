package com.easymarket.service.auth;

import com.easymarket.dao.UserDao;
import com.easymarket.entity.UserEntity;
import com.easymarket.utils.JWTUtil;
import com.easymarket.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            redisUtil.set(userEntity.getUsername(), token, 1200);
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
}
