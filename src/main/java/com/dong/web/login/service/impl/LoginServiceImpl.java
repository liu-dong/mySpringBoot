package com.dong.web.login.service.impl;

import com.dong.utils.ResponseResult;
import com.dong.web.login.dao.UserJpaDao;
import com.dong.web.login.entity.User;
import com.dong.web.login.model.LoginBean;
import com.dong.web.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserJpaDao userJpaDao;


    @Override
    public ResponseResult login(LoginBean bean) {
        ResponseResult result = new ResponseResult();
        User user = userJpaDao.getUserByUsername(bean.getUsername());
        if (user != null) {
            if (bean.getPassword().equals(user.getPassword())){
                result.setMessage("登录成功!");
                bean.setUserToken("202003231731");
                result.setData(bean);
            }else {
                result.setCode(500);
                result.setSuccess(false);
                result.setMessage("登录失败,密码错误!");
            }
        }else {
            result.setCode(500);
            result.setMessage("登录失败,无该用户!");
        }
        return result;
    }
}
