package com.test.service.impl;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.service.UserService;

import java.sql.SQLException;
import java.util.List;

/** @Author: zwb @Date: 2019-05-18 22:29 */
public class UserServiceImpl implements UserService {

  private UserDao userDao = new UserDaoImpl();

  @Override
  public User login(String username, String password) throws SQLException {
    return userDao.login(username, password);
  }

  @Override
  public int register(User user) {
    List<User> list = userDao.selectByUser(user);
    if (!list.isEmpty()) {
      return -1;
    }
    return userDao.insertUser(user);
  }

  @Override
  public boolean checkUnique(String username) {
    User user = new User();
    user.setUsername(username);
    return userDao.selectByUser(user).isEmpty();
  }
}
