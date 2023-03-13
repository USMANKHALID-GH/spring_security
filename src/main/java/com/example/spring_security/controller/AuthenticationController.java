package com.example.spring_security.controller;


import com.example.spring_security.dto.AuthenticateRequest;
import com.example.spring_security.dto.AuthenticationResponse;
import com.example.spring_security.dto.ResgisterRequest;
import com.example.spring_security.mapper.AuthenticateMapper;
import com.example.spring_security.mapper.RegisterMapper;
import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final UserService service;

    private final RegisterMapper registerMapper;
    private  final AuthenticateMapper authenticateMapper;




    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody ResgisterRequest request){
        User user=registerMapper.toEntity(request);
        log.info("\n,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
       return  ResponseEntity.ok(service.register(user));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody  AuthenticateRequest request){
        User user=authenticateMapper.toEntity(request);
        return  ResponseEntity.ok(service.authenticate(user));
    }
}

