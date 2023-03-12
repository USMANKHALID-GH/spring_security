package com.example.spring_security.config;

import com.example.spring_security.service.implementation.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class JwtFilter  extends OncePerRequestFilter {
    private  final JwtService service;

    final String HEADER="";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     final String authHeader=request.getHeader("authorization");
     final String jwt;
     final String userEmail;
     if(authHeader==null|| authHeader.startsWith("Bearer ") ){
     filterChain.doFilter(request,response);
     return;
     }
     jwt=authHeader.substring(7);
 userEmail= service.extractUserName(jwt);

    }
}
