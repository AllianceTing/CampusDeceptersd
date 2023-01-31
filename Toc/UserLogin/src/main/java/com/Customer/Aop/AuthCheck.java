package com.Customer.Aop;

import java.lang.annotation.*;

/**
 * PROJECT_NAME AuthCheck
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/17~20:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Inherited
@Documented
public @interface AuthCheck {
    String value() default "defaultUser";
}
