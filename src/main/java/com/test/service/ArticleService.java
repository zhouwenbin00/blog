package com.test.service;

import com.test.bean.Article;

import java.util.List;

/**
 * @Auther: zhouwenbin
 * @Date: 2019/5/23 20:51
 */
public interface ArticleService {

    boolean add(Article article);

    List<Article> hotList();
    List<Article> newList();

    Article queryOne(Article article);
}
