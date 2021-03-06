package com.dong.web.service.impl;

import com.dong.common.ResponseResult;
import com.dong.web.dao.UserJpaDao;
import com.dong.web.entity.User;
import com.dong.web.model.LoginBean;
import com.dong.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserJpaDao userJpaDao;


    /**
     * 登录
     *
     * @param bean
     * @return
     */
    @Override
    public ResponseResult login(LoginBean bean) {
        ResponseResult result;
        User user = userJpaDao.getUserByUsername(bean.getUsername());
        if (user != null) {
            if (bean.getPassword().equals(user.getPassword())){
                bean.setUserToken(String.valueOf(System.currentTimeMillis()));
                result = ResponseResult.success(bean,"登录成功!");
            }else {
                result = ResponseResult.error("登录失败,密码错误!");
            }
        }else {
            result = ResponseResult.error("登录失败,无该用户!");
        }
        return result;
    }
}
