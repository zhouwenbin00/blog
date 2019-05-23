package com.test.dao.impl;

import com.test.bean.Article;
import com.test.dao.ArticleDao;
import com.test.utils.DBUtil;
import com.test.utils.QuicklyQuery;
import com.test.utils.sql.Prepare;
import com.test.utils.sql.Select;
import com.test.utils.sql.Where;

import java.util.List;

/** @Auther: zhouwenbin @Date: 2019/5/23 20:52 */
public class ArticleDaoImpl implements ArticleDao {
  @Override
  public int add(Article article) {
    QuicklyQuery quicklyQuery = new QuicklyQuery();
    return quicklyQuery.insertObject(article);
  }

  @Override
  public List<Article> hotList() {
    //    Select select =
    //        Prepare.select("*")
    //            .from("article")
    //            .where(Where.create().whereOther("limit 5 order by like desc"));
    String sql = "SELECT * FROM article ORDER BY `like` DESC LIMIT 5";
    List<Article> articles = DBUtil.QueryList(sql, Article.class);
    return articles;
  }

  @Override
  public List<Article> newList() {
    String sql = " SELECT * FROM article ORDER BY `create_date` DESC LIMIT 20";
    List<Article> articles = DBUtil.QueryList(sql, Article.class);
    return articles;
  }

  @Override
  public Article queryOne(Article article) {
    QuicklyQuery quicklyQuery = new QuicklyQuery();
    List<Article> articles = quicklyQuery.selectByObject(article);
    if (!articles.isEmpty()) {
      return articles.get(0);
    }
    return null;
  }
}
