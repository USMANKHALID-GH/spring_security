package com.example.spring_security.mapper;

import com.example.spring_security.dto.ResgisterRequest;
import com.example.spring_security.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper extends  EntityMapper<ResgisterRequest, User> {

    ResgisterRequest toDto(User blog);
    User toEntity(ResgisterRequest blogDto);
}
