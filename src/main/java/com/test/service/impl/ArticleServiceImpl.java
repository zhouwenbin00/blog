package com.test.service.impl;

import com.test.bean.Article;
import com.test.dao.ArticleDao;
import com.test.dao.impl.ArticleDaoImpl;
import com.test.service.ArticleService;

import java.util.List;

/** @Auther: zhouwenbin @Date: 2019/5/23 20:51 */
public class ArticleServiceImpl implements ArticleService {
  ArticleDao articleDao = new ArticleDaoImpl();

  @Override
  public boolean add(Article article) {
    return articleDao.add(article) > 0;
  }

  @Override
  public List<Article> hotList() {
    return articleDao.hotList();
  }

  @Override
  public List<Article> newList() {
    return articleDao.newList();
  }

  @Override
  public Article queryOne(Article article) {
    return articleDao.queryOne(article);
  }
}
