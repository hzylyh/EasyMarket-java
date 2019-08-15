package com.easymarket.dao;

import com.easymarket.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    UserEntity selectOneUser(@Param("username") String username);
}
