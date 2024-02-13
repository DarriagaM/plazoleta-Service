package com.pragma.powerup.infrastructure.out.feingclient;

import com.pragma.powerup.infrastructure.out.feingclient.dto.UserFeingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-Service", url = "localhost:8091/user")
public interface IUserFeignClient {
    @GetMapping("existsUserById/{id}")
    boolean existsUserById(@PathVariable(value = "id") Long id);
    @GetMapping("/{id}")
    UserFeingDto getUserById(@PathVariable(value = "id") Long id);
    @GetMapping("email/{email}")
    UserFeingDto getUserByEmail(@PathVariable(value = "email") String email);
}
