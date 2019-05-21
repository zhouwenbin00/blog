package com.test.servlet;

import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import com.test.utils.sql.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** @Auther: zhouwenbin @Date: 2019/5/21 15:28 */
@WebServlet(name = "UserUniqueServlet", value = "/user/checkUnique")
public class UserUniqueServlet extends HttpServlet {
  static final Logger LOGGER = LoggerFactory.getLogger(UserUniqueServlet.class);

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    if (username == null) {
      LOGGER.error("用户名是空的，看哈你前端验证");
    }
    UserService userServic = new UserServiceImpl();
    Map<String,Boolean> map = new HashMap<>();
    map.put("valid",userServic.checkUnique(username));

    response.getWriter().write(JsonUtil.getInstance().toString(map));
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
