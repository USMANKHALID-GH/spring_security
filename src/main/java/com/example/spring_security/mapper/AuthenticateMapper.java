package com.example.spring_security.mapper;

import com.example.spring_security.dto.AuthenticateRequest;

import com.example.spring_security.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticateMapper  extends  EntityMapper<AuthenticateRequest, User>{
    AuthenticateRequest toDto(User blog);
    User toEntity(AuthenticateRequest blogDto);
}
