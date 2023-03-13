package com.example.spring_security.service.implementation;

import com.example.spring_security.dto.AuthenticationResponse;

import com.example.spring_security.model.Roles;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;
import com.example.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserImp  implements UserService {

    private final UserRepository userRepository;
    private  final  JwtService jwtService;
    private  final AuthenticationManager authenticationManager;


    private  final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.USER);
        userRepository.save(user);
        var token=jwtService.generateToken(user);
        log.info("\n,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,serve");
        return AuthenticationResponse.builder()
                        .token(token).build();
    }

    @Override
    public AuthenticationResponse authenticate(User user) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    user.getUserEmail(),
                    user.getPassword()
            )
                );

        var userEmail=userRepository.findByUserEmail(user.getUserEmail()).orElseThrow(()->
               new UsernameNotFoundException("There is no such user in our System"));
        var token=jwtService.generateToken(userEmail);

        return AuthenticationResponse.builder()
                .token(token).build();


    }



}
