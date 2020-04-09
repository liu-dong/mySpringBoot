package com.dong.web.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LD
 * @date 2020/3/22 22:02
 */
@Data
public class LoginBean {

    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
    private String userToken;//用户token
    private String captcha;//验证码
}

