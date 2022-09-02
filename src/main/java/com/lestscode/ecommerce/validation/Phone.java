package com.lestscode.ecommerce.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
