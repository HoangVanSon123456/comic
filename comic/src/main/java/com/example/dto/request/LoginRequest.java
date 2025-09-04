package com.example.dto.request;

import com.example.utils.annotation.ValidEmail;
import com.example.utils.annotation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
//    @ValidEmail
    @NotBlank
    private String email;

    @NotBlank
//    @ValidPassword
    private String password;
}
