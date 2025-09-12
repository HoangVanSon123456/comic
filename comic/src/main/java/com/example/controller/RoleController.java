package com.example.controller;

import com.example.dto.request.RoleDTO;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.IdResponse;
import com.example.dto.response.PageResponse;
import com.example.service.RoleService;
import com.example.utils.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteRole(@RequestParam Integer id) {
        roleService.delete(id);
        return BaseResponse.<Void>builder()
                .status(200)
                .message("Success")
                .build();
    }

    @GetMapping()
    public PageResponse<List<RoleDTO>> getRoles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {

        Page<RoleDTO> roles = roleService.findAll(PageRequest.of(page, size));
        return PaginationUtil.buildPaginatedResponse(
                roles,
                200,
                "Thành công!"
        );
    }

}
