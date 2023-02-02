package com.Customer.chains;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * PROJECT_NAME piepleContentDataPreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Service
@Component
public class piepleContentDataPreChecker implements Contenxthandler<UserLoginReuestContent> {
    /**
     * @param context - > piepleContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent context) {
        return false;
    }
}
