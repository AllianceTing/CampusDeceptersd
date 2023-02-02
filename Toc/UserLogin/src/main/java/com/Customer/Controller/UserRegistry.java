package com.Customer.Controller;

import com.Customer.Exception.ResultUtils;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.concurrent.ThreadLocalRandom;

/**
 * PROJECT_NAME UserRegistry
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:28
 */

@RestController
@RequestMapping(value = "/registry")
public class UserRegistry {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Object registryUserByNumber(@RequestBody @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$"
            , message = "手机号格式有误") String phoneNumber, HttpServletRequest req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phoneNumber);
        User user = userService.getOne(queryWrapper);
        if (user != null) {
            return ResultUtils.error(50400, "登录失败，手机号已存在", "");
        } else {
            String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            HttpSession session = req.getSession(true);
            session.setAttribute("authCode", authCode);
            session.setMaxInactiveInterval(60);
            return ResultUtils.success("OK");
        }
    }

    @PostMapping("/register/authcode")
    public Object verifyAuthCode(@RequestBody @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
                                 String phoneNumber, @RequestBody @RequestParam("authCode") @NotNull String userAuthCode,
                                 @SessionAttribute(value = "authCode", required = false) String authCode) {
        if (authCode == null) {
            return ResultUtils.error(50400, "验证码已经失效", "");
        }
        if (!userAuthCode.equals(authCode)) {
            return ResultUtils.error(50404, "验证码错误", "");
        }
        return ResultUtils.success("OK");
    }
}




