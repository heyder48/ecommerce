package com.lestscode.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CpfConstraint,String> {

    @Override
    public void initialize(CpfConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return cpf != null && cpf.matches("[0-9]{11}");
    }
}
