package com.pragma.powerup.infrastructure.out.feingclient.adapter;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.feignclient.IUserFeignPort;
import com.pragma.powerup.infrastructure.out.feingclient.IUserFeignClient;
import com.pragma.powerup.infrastructure.out.feingclient.dto.UserFeingDto;
import com.pragma.powerup.infrastructure.out.feingclient.mapper.IUserFeignMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeingAdapter implements IUserFeignPort {
    private final IUserFeignClient userFeignClient;
    private final IUserFeignMapper userFeignMapper;

    @Override
    public boolean existsUserById(Long id) {
        return userFeignClient.existsUserById(id);
    }

    @Override
    public UserModel getUserById(Long id) {
        UserFeingDto userFeingDto = userFeignClient.getUserById(id);
        return userFeignMapper.toUserModel(userFeingDto);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        UserFeingDto userFeingDto = userFeignClient.getUserByEmail(email);
        return userFeignMapper.toUserModel(userFeingDto);
    }
}
