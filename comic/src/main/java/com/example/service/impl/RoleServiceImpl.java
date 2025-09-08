package com.example.service.impl;

import com.example.dto.request.RoleDTO;
import com.example.dto.response.IdResponse;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public IdResponse save(RoleDTO roleDTO) {
        Role role = Role.builder()
                .code(roleDTO.getCode())
                .name(roleDTO.getName())
                .build();
        roleRepository.save(role);
        return IdResponse.builder().
                id(role.getId()).
                build();
    }

    @Override
    public IdResponse edit(RoleDTO roleDTO) {
        Role role = roleRepository.findById(roleDTO.getId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleDTO.getId()));
        if (role != null) {
            role.setCode(roleDTO.getCode());
            role.setName(roleDTO.getName());
            roleRepository.save(role);
        }
        return IdResponse.builder().
                id(role.getId()).
                build();
    }

    @Override
    public void delete(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        if (role != null) {
            roleRepository.delete(role);
        }
    }

    @Override
    public RoleDTO findById(Integer id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList();
    }
}
