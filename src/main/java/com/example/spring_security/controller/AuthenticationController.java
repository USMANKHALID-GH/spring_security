package com.example.spring_security.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@ResponseBody ResgisterRequest request){

    }

    @PostMapping("/authenticate")
    public ResponseEntity<> register(@ResponseBody AuthenticateRequest request){

    }
}
}
