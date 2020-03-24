package com.dong.web.login.service;

import com.dong.utils.ResponseResult;
import com.dong.web.login.model.LoginBean;

public interface LoginService {

    /**
     * 登录
     *
     * @param bean
     * @return
     */
    ResponseResult login(LoginBean bean);
}
