package com.pragma.powerup.infrastructure.security;

import com.pragma.powerup.infrastructure.out.feingclient.IUserFeignClient;
import com.pragma.powerup.infrastructure.out.feingclient.dto.UserFeingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final IUserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserFeingDto userFeingDto = userFeignClient.getUserByEmail(email);
        return new UserDetailsImpl(userFeingDto);
    }
}
