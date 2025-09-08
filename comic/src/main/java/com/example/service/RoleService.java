package com.example.service;

import com.example.dto.request.RoleDTO;
import com.example.dto.response.IdResponse;

import java.util.List;

public interface RoleService {
    IdResponse save (RoleDTO roleDTO);
    IdResponse edit (RoleDTO roleDTO);
    void delete (Integer id);
    RoleDTO findById (Integer id);
    List<RoleDTO> findAll();
}
