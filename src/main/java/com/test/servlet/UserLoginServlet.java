package com.test.servlet;

import com.test.bean.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import com.test.utils.ConditionsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/** 用户登陆 @Author: zwb @Date: 2019-05-18 20:41 */
@WebServlet(name = "UserLoginServlet", value = "/user/login")
public class UserLoginServlet extends HttpServlet {
  final static Logger LOGGER = LoggerFactory.getLogger(UserLoginServlet.class);

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String remember = request.getParameter("remember");
    UserService userService = new UserServiceImpl();
    // 登陆成功就记住密码，放到session域中
    User user = null;
    try {
      user = userService.login(username, password);
    } catch (SQLException e) {
      LOGGER.error("登录逻辑错误!", e);
    }
    String basePath = (String) request.getSession().getAttribute("basePath");
    int MAX_AGE = 7 * 24 * 60 * 60;
    if (user != null) {
      request.getSession().setAttribute("user", user);
      if (remember != null && remember.equals("on")) {
        Cookie cookie0 = new Cookie("username", username);
        Cookie cookie1 = new Cookie("password", password);
        cookie0.setPath("/");
        cookie1.setPath("/");
        cookie0.setMaxAge(MAX_AGE);
        cookie1.setMaxAge(MAX_AGE);
        response.addCookie(cookie0);
        response.addCookie(cookie1);
      }
      // 跳转
      response.sendRedirect("/index.jsp");

    } else {
      // 失败返回信息
      request.setAttribute("errMsg", "用户名或者密码错误");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
