package com.lestscode.ecommerce.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DddValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DDD {
    String message() default "Invalid DDD";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
