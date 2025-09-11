package com.example.mapper;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenericMapper <D, E>{
    D toDTO(E entity);
    E toEntity(D dto);
    List<D> toDTOList(List<E> entityList);
    List<E> toEntityList(List<D> dtoList);
}
