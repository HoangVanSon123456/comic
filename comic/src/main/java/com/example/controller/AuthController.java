package com.example.controller;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.RegisterRequest;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.LoginResponse;
import com.example.dto.response.RegisterResponse;
import com.example.exception.global.TokenException;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public BaseResponse<Object> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return BaseResponse.builder()
                .status(200)
                .message("Success")
                .data(loginResponse)
                .build();
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}
