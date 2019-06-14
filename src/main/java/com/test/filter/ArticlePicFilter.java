package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/** 文章图片过滤器 防止文章图片过大超出容器 @Auther: zhouwenbin @Date: 2019/6/14 11:12 */
@WebFilter(filterName = "articlePicFilter", urlPatterns = "/article/add")
public class ArticlePicFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    System.out.println(1);
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    MyHttpServletRequestWrapper requestWrapper =
        new MyHttpServletRequestWrapper((HttpServletRequest) servletRequest);
    String content = requestWrapper.getParameter("content");
    if (content != null && !content.isEmpty()) {
      String s1 = content.replaceAll("<img ", "<img class=\"img-responsive\" ");
      requestWrapper.setParameter("content", s1);
    }

    filterChain.doFilter(requestWrapper, servletResponse);
  }

  @Override
  public void destroy() {}
}
