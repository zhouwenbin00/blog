package com.test.dao;

import com.test.bean.User;

/**
 * @Author: zwb
 * @Date: 2019-05-18 22:29
 */
public interface UserDao {

    User login(String username, String password);


}
