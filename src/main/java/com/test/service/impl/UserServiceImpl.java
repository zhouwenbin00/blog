package com.test.service.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.service.UserService;

/**
 * @Author: zwb
 * @Date: 2019-05-18 22:29
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    @Override
    public User login(String username, String password) {
        return userDao.login(username,password );
    }
}