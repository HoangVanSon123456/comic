package com.example.service;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.RegisterRequest;
import com.example.dto.response.LoginResponse;
import com.example.dto.response.RegisterResponse;

public interface AuthService {
     LoginResponse login(LoginRequest loginRequest);
     RegisterResponse register(RegisterRequest registerRequest);
}
