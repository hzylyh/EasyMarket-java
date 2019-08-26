package com.easymarket.service.auth;

import com.easymarket.entity.UserEntity;

public interface AuthService {

    UserEntity verifyUser(UserEntity u);

    void removeAuth(UserEntity userEntity);

    void register(UserEntity u);
}
