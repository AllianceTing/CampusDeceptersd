package com.Customer.strategy;

import com.Customer.chains.piepleContent;
import com.Customer.chains.pipelineExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME loginStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByMail implements loginStrategy {
    @Resource
    pipelineExecutor pipelineExecutor;

    @Override
    public boolean loginStrategy(piepleContent data) {
        return pipelineExecutor.acceptSync(data);
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MailLogin;
    }
}
