package com.test.dao.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.utils.*;
import com.test.utils.sql.Prepare;
import com.test.utils.sql.Select;
import com.test.utils.sql.Where;

import java.util.Arrays;
import java.util.List;

/** @Author: zwb @Date: 2019-05-18 22:30 */
public class UserDaoImpl implements UserDao {

  @Override
  public User login(String username, String password) {
    Select select =
        Prepare.select("*")
            .from("t_user")
            .where(
                Where.create()
                    .whereEquals("username", username)
                    .and()
                    .whereEquals("password", password));
    return DBUtil.QueryOne(select, User.class);
  }

  @Override
  public int insertUser(User user) {
    QuicklyQuery quicklyQuery = new QuicklyQuery();
    return quicklyQuery.insertObject(user);
  }

  @Override
  public List<User> selectByUser(User user) {
    QuicklyQuery quicklyQuery = new QuicklyQuery();
    return quicklyQuery.selectByObject(user);
  }
}
