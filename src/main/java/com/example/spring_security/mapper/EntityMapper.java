package com.example.spring_security.mapper;

import com.example.spring_security.dto.BaseDto;
import com.example.spring_security.model.AbstractModel;

import java.util.List;

public interface EntityMapper<D extends BaseDto, E extends AbstractModel> {

    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
