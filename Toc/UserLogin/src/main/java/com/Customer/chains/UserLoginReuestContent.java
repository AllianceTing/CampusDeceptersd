package com.Customer.chains;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.common.value.qual.MinLen;

import javax.validation.constraints.Max;

/**
 * PROJECT_NAME UserLoginReuestContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:27
 */
@Getter
@Setter
public class UserLoginReuestContent extends piepleContent {
    private static final long serialVersionUID = 1L;

    @MinLen(2)
    @Max(18)
    private String userAccount;
    @MinLen(2)
    @Max(18)
    private String userPassword;

    @Override
    public String getName() {
        return this.getClass().getSimpleName() + "Starting Building";
    }
}
