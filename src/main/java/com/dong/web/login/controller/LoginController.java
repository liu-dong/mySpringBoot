package com.dong.web.login.controller;

import com.dong.utils.ResponseResult;
import com.dong.web.login.model.LoginBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录模块
 *
 * @author LD
 * @date 2020/3/22 20:59
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public ResponseResult login(LoginBean bean){
        ResponseResult result = new ResponseResult();

        return result;
    }
}
