package com.lestscode.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[0-9]{9}|[0-9]{8}");
    }
}
