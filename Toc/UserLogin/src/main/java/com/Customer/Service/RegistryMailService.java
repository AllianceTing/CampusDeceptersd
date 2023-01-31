package com.Customer.Service;
/*
 * PROJECT_NAME RegistryMailService
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:14.
 */

import com.Customer.VO.MailVo;

/**
 * @author zzt
 */
public interface RegistryMailService {
    /**
     * do send qq mail
     *
     * @return
     */
    void registryMail(MailVo mailVo);
}
