package com.learnjava.frenemy.annotations;

import com.learnjava.frenemy.annotations.validator.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface CustomAge {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "{invalid-age-message}";

    int lower() default 18;

    int upper() default 60;

}
