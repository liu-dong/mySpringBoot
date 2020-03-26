package com.dong.web.service;

import com.dong.utils.ResponseResult;
import com.dong.web.model.LoginBean;

public interface LoginService {

    /**
     * 登录
     *
     * @param bean
     * @return
     */
    ResponseResult login(LoginBean bean);
}
