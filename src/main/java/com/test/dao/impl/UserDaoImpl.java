package com.test.dao.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.utils.DBUtil;


/**
 * @Author: zwb
 * @Date: 2019-05-18 22:30
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User login(String username, String password) {
        String sql = "SELECT * FROM t_user WHERE username =? and password=?";
        Object[] params = {username, password};
        return  DBUtil.QueryOne(sql, User.class, params);
    }
}
