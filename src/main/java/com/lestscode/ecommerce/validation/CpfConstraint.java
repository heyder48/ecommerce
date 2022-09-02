package com.lestscode.ecommerce.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfConstraint {

    String message() default "Invalid CPF";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
