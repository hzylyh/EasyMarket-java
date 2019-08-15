package com.easymarket.service.auth;

import com.easymarket.entity.UserEntity;

public interface AuthService {

    boolean verifyUser(UserEntity u);
}
