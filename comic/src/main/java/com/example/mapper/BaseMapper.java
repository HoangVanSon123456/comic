package com.example.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseMapper<D, E> {
    public abstract D toDTO(E entity);
    public abstract E toEntity(D dto);

    public List<D> toDTOList(List<E> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<E> toEntityList(List<D> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}