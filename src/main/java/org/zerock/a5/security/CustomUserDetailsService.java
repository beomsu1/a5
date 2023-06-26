package org.zerock.a5.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: " + username );
        // 유저의 아이디와 비밀번호 생성 , USER , G1의 권한을 줌
        UserDetails user = User.builder()
        .username(username)
        .password("1111")
        .authorities("ROLE_USER", "ROLE_G1")
        .build();

        return user;

    }
    
}
