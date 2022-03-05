package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/accounts/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin();
    }
}

// SecurityConfig : 사용자 정의 보안 설정 클래스
// WebSecurityConfigurerAdapter : 스프링 시큐리티의 웹 보안 기능 설정
// HttpSecurity : 세부적인 보안 기능을 설정
// 인증 API & 인가 API 를 구분하여 작성