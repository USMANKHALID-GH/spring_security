package com.example.spring_security.config;

import com.example.spring_security.repository.UserRepository;
import jakarta.servlet.FilterChain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecuriyConfiguration {

    private final UserRepository userRepository;
     private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws  Exception{
       http.csrf()
               .disable()
               .authorizeHttpRequests()
               .requestMatchers("").permitAll()
               .anyRequest().authenticated()
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authenticationProvider(authenticationProvider())
               .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return  daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(23);
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return (userName)->userRepository.findByUserEmail(userName).
                orElseThrow(()->new UsernameNotFoundException("User not found"));
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
         return config.getAuthenticationManager();

        }
    }

