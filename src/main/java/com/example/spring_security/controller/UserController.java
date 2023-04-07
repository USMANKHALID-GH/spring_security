package com.example.spring_security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/")
    public ResponseEntity<String> hell(){
        log.info("come home");
        return  ResponseEntity.ok("First Api");

    }


    @GetMapping("/get")
    public  ResponseEntity<String> user(){
        return ResponseEntity.ok("""
                <form>
                 <input type="text"> enter your name 
                 <br>
                 <button> save</button>
                 </form>
                """);
    }
}
