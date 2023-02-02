package com.Customer.strategy;

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
public class strategyContent {
    public static final Map<LoginTypeEnum, loginStrategy> LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP = new HashMap<>();

    static {
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(LoginTypeEnum.MailLogin, new loginStrategyByMail());
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(LoginTypeEnum.MessageLogin, new loginStrategyByMessage());
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(LoginTypeEnum.WeChatLogin, new loginStrategyByWeChat());
    }

    public static loginStrategy getLoginStrategy(LoginTypeEnum LoginType) {
        if (LoginType == null) {
            throw new IllegalArgumentException("Login type is empty.");
        }
        if (!LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.containsKey(LoginType)) {
            throw new IllegalArgumentException("Login type not supported.");
        }
        return LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.get(LoginType);
    }

}

