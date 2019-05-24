package com.test.filter;

import com.test.utils.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/** @Auther: zhouwenbin @Date: 2019/5/24 11:12 */

@WebFilter(filterName="CharsetFilter",urlPatterns="/")
public class CharsetFilter implements Filter {
  static final Logger LOGGER = LoggerFactory.getLogger(CharsetFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    servletRequest.setCharacterEncoding(String.valueOf(CharsetUtil.UTF_8));
    servletResponse.setCharacterEncoding(String.valueOf(CharsetUtil.UTF_8));
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {}
}
