package com.Customer.Service.impl;

import com.Customer.Service.RegistryMailService;
import com.Customer.VO.MailVo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME RegistryMailServiceimpl
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:16
 */
@Service
public class RegistryMailServiceimpl implements RegistryMailService {
    @Resource
    JavaMailSender javaMailSender;


    /**
     * do send qq mail
     *
     * @return
     */
    @Override
    public void registryMail(MailVo mailVo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailVo.getFrom());
        simpleMailMessage.setSubject(mailVo.getObject());
        simpleMailMessage.setTo(mailVo.getTarget());
        simpleMailMessage.setText(mailVo.getContent());
        javaMailSender.send(simpleMailMessage);
    }
}
