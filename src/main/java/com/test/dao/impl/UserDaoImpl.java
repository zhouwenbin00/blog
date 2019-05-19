package com.test.dao.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.utils.DBUtil;
import com.test.utils.sql.Prepare;
import com.test.utils.sql.Select;
import com.test.utils.sql.Where;

import java.util.Arrays;

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

  public static void main(String[] args) {

    Select select =
        Prepare.select("*")
            .from("t_user")
            .where(
                Where.create()
                    .whereEquals("username", "zhangsan")
                    .and()
                    .whereEquals("password", "123"));
    System.out.println(select.sql());

    System.out.println(Arrays.toString(select.params()));
    User user = DBUtil.QueryOne(select, User.class);
    System.out.println(user);
  }
}
