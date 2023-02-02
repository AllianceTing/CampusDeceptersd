package com.Customer.Aop;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * PROJECT_NAME PhoneValidateByConstriant
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~20:00
 */

public class PhoneValidateByConstriant implements ConstraintValidator<PhoneCheck, Object> {
    @Override
    public void initialize(PhoneCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
       //todo phone check
        return false;
    }
}
