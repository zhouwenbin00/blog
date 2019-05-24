package com.test.servlet;

import com.test.bean.Article;
import com.test.service.ArticleService;
import com.test.service.impl.ArticleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/** @Auther: zhouwenbin @Date: 2019/5/24 15:30 */
@WebServlet(name = "ArticleIndexServlet", value = "/article/index")
public class ArticleIndexServlet extends HttpServlet {
    final static Logger LOGGER = LoggerFactory.getLogger(ArticleIndexServlet.class);
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArticleService service = new ArticleServiceImpl();
    List<Article> hotList = service.hotList();
    request.getSession().setAttribute("hotList", hotList);
    List<Article> newList = service.newList();
    request.getSession().setAttribute("newList", newList);
    if (hotList.isEmpty()||newList.isEmpty()){
        LOGGER.error("搞啥呢？数据库没有数据吗");
    }
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
