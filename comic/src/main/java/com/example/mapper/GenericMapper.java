package com.example.mapper;

import java.util.List;

public interface GenericMapper <D, E>{
    D toDTO(E entity);
    E toEntity(D dto);
    List<D> toDTOList(List<E> entityList);
    List<E> toEntityList(List<D> dtoList);
}
