package com.test.servlet;

import com.test.bean.Article;
import com.test.bean.User;
import com.test.service.ArticleService;
import com.test.service.impl.ArticleServiceImpl;
import com.test.utils.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @Author: zwb @Date: 2019-05-19 13:27 */
@WebServlet(name = "TestServlet", value = "/testServlet")
public class TestServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    Article article = BeanUtil.newObjFromRequest(request, Article.class);
    ArticleService service = new ArticleServiceImpl();
    service.add(article);
    System.out.println(article);
    request.setAttribute("article", article);
    request.getRequestDispatcher("/test.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
