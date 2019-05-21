package com.test.dao;

import com.test.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: zwb
 * @Date: 2019-05-18 22:29
 */
public interface UserDao {

    User login(String username, String password) throws SQLException;

    int insertUser(User user);

    List<User> selectByUser(User user);


}
