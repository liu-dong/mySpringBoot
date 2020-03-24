package com.dong.web.login.model;

import lombok.Data;

/**
 * @author LD
 * @date 2020/3/22 22:02
 */
@Data
public class LoginBean {

    private String username;
    private String password;
    private String userToken;//用户token
    private String captcha;//验证码
}

