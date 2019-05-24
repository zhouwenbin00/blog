package com.test.dao;

import com.test.bean.Article;

import java.util.List;

/**
 * @Auther: zhouwenbin
 * @Date: 2019/5/23 20:52
 */
public interface ArticleDao {

    int add(Article article);
    List<Article> hotList();
    List<Article> newList();
    Article queryOne(Article article);
}
