package com.example.mapper;

import com.example.dto.request.RoleDTO;
import com.example.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoleMapper extends BaseMapper<RoleDTO, Role> {

}