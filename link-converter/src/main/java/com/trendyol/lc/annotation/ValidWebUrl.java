package com.trendyol.lc.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WebUrlValidator.class)
@Documented
public @interface ValidWebUrl {

	String message() default "Invalid/unacceptable web url address!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
