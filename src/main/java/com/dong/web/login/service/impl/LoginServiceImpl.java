package com.dong.web.login.service.impl;

import com.dong.web.login.dao.UserJpaDao;
import com.dong.web.login.entity.User;
import com.dong.web.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserJpaDao userJpaDao;

    @Override
    public User getUserInfo(String username) {
        return userJpaDao.getUserByUsername(username);
    }
}
