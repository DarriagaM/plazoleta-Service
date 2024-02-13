package com.pragma.powerup.infrastructure.security;

import com.pragma.powerup.infrastructure.out.feingclient.dto.UserFeingDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserFeingDto userFeingDto;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userFeingDto.getRol().getNombre()));
    }

    @Override
    public String getPassword() {
        return userFeingDto.getClave();
    }

    @Override
    public String getUsername() {
        return userFeingDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return userFeingDto.getNombre();
    }

    public Long getId(){
        return userFeingDto.getId();
    }
}