package com.example.utils.validator;

import com.example.utils.annotation.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN =
            "^(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9._%+-]{3,30}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.matches(EMAIL_PATTERN);
    }
}
