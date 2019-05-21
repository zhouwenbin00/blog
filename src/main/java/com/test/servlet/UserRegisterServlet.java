package com.test.servlet;

import com.test.bean.User;;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import com.test.utils.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 用户注册@Auther: zhouwenbin @Date: 2019/5/20 12:42 */
@WebServlet(name = "UserRegisterServlet", value = "/user/register")
public class UserRegisterServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    User user = BeanUtil.newObjFromRequest(request, User.class);
    UserService userService = new UserServiceImpl();
    int isRegister = userService.register(user);

    if (isRegister > 0) {
      // 成功
      request
          .getRequestDispatcher(
              String.format(
                  "/user/login?username=%s&password=%s&remember=on", user.getUsername(), user.getPassword()))
          .forward(request, response);
    } else {
      // 失败
      request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
