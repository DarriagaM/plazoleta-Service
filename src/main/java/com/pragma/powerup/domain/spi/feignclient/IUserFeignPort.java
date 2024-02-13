package com.pragma.powerup.domain.spi.feignclient;

import com.pragma.powerup.domain.model.UserModel;

public interface IUserFeignPort {
    boolean existsUserById(Long id);
    UserModel getUserById(Long id);
    UserModel getUserByEmail(String email);
}
