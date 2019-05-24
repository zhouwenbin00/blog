package com.test.servlet;

import com.test.bean.Article;
import com.test.service.ArticleService;
import com.test.service.impl.ArticleServiceImpl;
import com.test.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @Auther: zhouwenbin @Date: 2019/5/24 16:25 */
@WebServlet(name = "ArticleDetailsServlet", value = "/article/details")
public class ArticleDetailsServlet extends HttpServlet {
  static final Logger LOGGER = LoggerFactory.getLogger(ArticleDetailsServlet.class);

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Article demo = BeanUtil.newObjFromRequest(request, Article.class);
    ArticleService service = new ArticleServiceImpl();
    Article article = service.queryOne(demo);
    if (article != null) {
      request.setAttribute("article", article);
    } else {
      LOGGER.error("你咋子没查到？");
    }
    request.getRequestDispatcher("/article_details.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
