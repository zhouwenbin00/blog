package com.test.service;

import com.test.bean.User;

import java.sql.SQLException;

/**
 * @Author: zwb
 * @Date: 2019-05-18 22:26
 */
public interface UserService {

    User login(String username, String password) throws SQLException;

    int register(User user);

    boolean checkUnique(String username);

}
