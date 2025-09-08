package com.example.controller;

import com.example.dto.request.RoleDTO;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.IdResponse;
import com.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping()
    public BaseResponse<IdResponse> createRole(@RequestBody RoleDTO roleDTO) {
        return BaseResponse.<IdResponse>builder()
                .status(200)
                .message("Success")
                .data(roleService.save(roleDTO))
                .build();
    }

    @PutMapping()
    public BaseResponse<IdResponse> updateRole(@RequestBody RoleDTO roleDTO) {
        return BaseResponse.<IdResponse>builder()
                .status(200)
                .message("Success")
                .data(roleService.edit(roleDTO))
                .build();
    }


    @GetMapping("/{id}")
    public BaseResponse<RoleDTO> getRoleById(@RequestParam Integer id) {
        RoleDTO roleDTO = roleService.findById(id);
        return BaseResponse.<RoleDTO>builder()
                .status(200)
                .message("Success")
                .data(roleDTO)
                .build();
    }
}
