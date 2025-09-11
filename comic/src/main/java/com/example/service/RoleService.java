package com.example.service;

import com.example.dto.request.RoleDTO;
import com.example.dto.response.IdResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    IdResponse save (RoleDTO roleDTO);
    IdResponse edit (RoleDTO roleDTO);
    void delete (Integer id);
    RoleDTO findById (Integer id);
    Page<RoleDTO> findAll(Pageable pageable);
}
