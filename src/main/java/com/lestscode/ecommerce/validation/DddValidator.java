package com.lestscode.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class DddValidator implements ConstraintValidator<DDD,String> {


    @Override
    public void initialize(DDD constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[0-9]{2}");
    }
}
