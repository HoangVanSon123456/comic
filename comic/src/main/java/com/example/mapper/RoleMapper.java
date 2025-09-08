package com.example.mapper;

import com.example.dto.request.RoleDTO;
import com.example.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends  GenericMapper<RoleDTO , Role>{
    @Override
    RoleDTO toDTO(Role entity);
    @Override
    Role toEntity(RoleDTO dto);
}
