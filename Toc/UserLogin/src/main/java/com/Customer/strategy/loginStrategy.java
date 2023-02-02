package com.Customer.strategy;

import org.springframework.stereotype.Component;

/*
 * PROJECT_NAME loginStrategy
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~11:59
 */
@Component
public interface loginStrategy {
    boolean loginStrategy();

    LoginTypeEnum getloginType();
}
