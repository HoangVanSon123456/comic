package com.example.service;

import com.example.dto.request.RoleDTO;

import java.util.List;

public interface RoleService {
    void save (RoleDTO roleDTO);
    void edit (RoleDTO roleDTO);
    void delete (Integer id);
    RoleDTO findById (Integer id);
    List<RoleDTO> findAll();
}
