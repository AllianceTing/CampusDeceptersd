package com.Customer.Aop;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * PROJECT_NAME PhoneCheck
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~19:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
@Constraint(validatedBy = PhoneValidateByConstriant.class)
public @interface PhoneCheck {
    String value() default "";
}
