package com.test.service;

import com.test.bean.User;

/**
 * @Author: zwb
 * @Date: 2019-05-18 22:26
 */
public interface UserService {

    User login(String username, String password);

    int register(User user);

}
