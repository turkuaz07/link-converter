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
@Constraint(validatedBy = DeeplinkValidator.class)
@Documented
public @interface ValidDeeplink {

	String message() default "Invalid/unacceptable deeplink!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
