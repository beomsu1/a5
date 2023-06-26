package org.zerock.a5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableMethodSecurity
public class CustomSecurityConfig {

    @Bean // 이 메소드의 결과를 Bean으로 등록하겠다!
    public PasswordEncoder passwordEncoder(){

        // 비밀번호를 암호화 하는데 사용하는 메소드를 가진 클래스
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)throws Exception {

    log.info("-----------------------configuration---------------------");

    http.formLogin(Customizer.withDefaults()); // 기본 로그인 페이지 창

    // http.authorizeHttpRequest(request -> {
    //     requests.anyRequest().authticated();
    //     // 로그인 안 했을 떄 모든 설정을 확인해라
    // })

    return http.build();

    }
}
