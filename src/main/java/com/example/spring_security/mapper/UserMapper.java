package com.example.spring_security.mapper;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper  extends  EntityMapper<UserDto, User> {

    UserDto toDto(User blog);
    User toEntity(UserDto blogDto);
}
