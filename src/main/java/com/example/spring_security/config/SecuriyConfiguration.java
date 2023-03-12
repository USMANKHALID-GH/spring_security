package com.example.spring_security.config;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
@EnableWebSecurity
public class SecuriyConfiguration {

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws  Exception{
       http.authorizeHttpRequests()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();
       return http.build();

    }
}
