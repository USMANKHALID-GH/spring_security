package com.example.spring_security.service;

import com.example.spring_security.dto.AuthenticationResponse;


import com.example.spring_security.model.User;


public interface UserService {

   AuthenticationResponse register(User user);


   AuthenticationResponse authenticate(User user);
}
