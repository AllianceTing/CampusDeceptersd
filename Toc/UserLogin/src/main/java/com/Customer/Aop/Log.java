package com.Customer.Aop;

import java.lang.annotation.*;

/**
 * PROJECT_NAME Log
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~21:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {
}
