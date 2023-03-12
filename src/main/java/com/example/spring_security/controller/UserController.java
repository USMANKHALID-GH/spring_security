package com.example.spring_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public ResponseEntity<String> hell(){
        return  ResponseEntity.ok("First Api");

    }
}
