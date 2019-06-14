package com.test.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/** @Auther: zhouwenbin @Date: 2019/6/14 11:50 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

  // 用于存储请求参数
  private Map<String, String[]> params = new HashMap<String, String[]>();

  public MyHttpServletRequestWrapper(HttpServletRequest request) {
    super(request);
    this.params.putAll(request.getParameterMap());
  }

  public void setParameterMap(Map<String, Object> extraParams) {
    for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
      setParameter(entry.getKey(), entry.getValue());
    }
  }

  public void setParameter(String name, Object value) {
    if (value != null) {
      System.out.println(value);
      if (value instanceof String[]) {
        params.put(name, (String[]) value);
      } else if (value instanceof String) {
        params.put(name, new String[] {(String) value});
      } else {
        params.put(name, new String[] {String.valueOf(value)});
      }
    }
  }

  @Override
  public String getParameter(String name) {
    String[] values = params.get(name);
    if (values == null || values.length == 0) {
      return null;
    }
    return values[0];
  }

  @Override
  public String[] getParameterValues(String name) {
    return params.get(name);
  }
}
