package com.dong.web.login.controller;

import com.dong.utils.ResponseResult;
import com.dong.web.login.entity.User;
import com.dong.web.login.model.LoginBean;
import com.dong.web.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录模块
 *
 * @author LD
 * @date 2020/3/22 20:59
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResponseResult login(LoginBean bean){
        return loginService.login(bean);
    }
}
