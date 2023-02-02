package com.Customer.strategy;

import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT_NAME strategyContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:03
 */
@Service
public class strategyContent implements InitializingBean, ApplicationContextAware {
    private static final Map<LoginTypeEnum, loginStrategy> LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP = new HashMap<>();

    private ApplicationContext appContext;

    public static loginStrategy getLoginStrategy(LoginTypeEnum LoginType) {
        if (LoginType == null) {
            throw new IllegalArgumentException("Login type is empty.");
        }
        if (!LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.containsKey(LoginType)) {
            throw new IllegalArgumentException("Login type not supported.");
        }
        return LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.get(LoginType);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        appContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        //
        appContext.getBeansOfType(loginStrategy.class)
                .values()
                .forEach(loginStrategy -> LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(loginStrategy.getPayType(), loginStrategy));
    }
}

