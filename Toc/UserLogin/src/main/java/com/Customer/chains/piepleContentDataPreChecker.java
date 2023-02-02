package com.Customer.chains;

import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import com.Customer.Service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME piepleContentDataPreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Service
@Component
public class piepleContentDataPreChecker implements Contenxthandler<UserLoginReuestContent> {
    @Resource
    UserService userService;

    /**
     * @param userVo - > piepleContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent userVo) {
        if (userVo == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        var userPassword = userVo.getUserPassword().trim();
        if (userPassword.length() >= 2 && userPassword.length() <= 18) {
            return true;
        } else {
            return false;
        }
    }
}
