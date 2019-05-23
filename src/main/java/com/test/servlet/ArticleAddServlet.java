package com.test.servlet;

import com.test.bean.Article;
import com.test.bean.User;
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
import java.sql.Timestamp;

/**
 * @Auther: zhouwenbin
 * @Date: 2019/5/24 11:44
 */
@WebServlet(name = "ArticleAddServlet",value = "/article/add")
public class ArticleAddServlet extends HttpServlet {
    final static Logger LOGGER = LoggerFactory.getLogger(ArticleAddServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Article article = BeanUtil.newObjFromRequest(request, Article.class);
        article.setCreateDate(new Timestamp( System.currentTimeMillis()));
        article.setLike(0);
        article.setLook(0);
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
//            response.sendRedirect("/login.jsp");
            LOGGER.error("小老弟怎么回事？没人登录怎么进的写博客界面?滚回去登录");
        }
        article.setAuther(user.getId());
        ArticleService service = new ArticleServiceImpl();
        boolean flag = service.add(article);
        response.getWriter().print(flag);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
