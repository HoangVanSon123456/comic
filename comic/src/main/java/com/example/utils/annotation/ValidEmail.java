package com.example.utils.annotation;

import com.example.utils.validator.EmailValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default "Tên email không hợp lệ. Chỉ được chứa chữ, số";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
