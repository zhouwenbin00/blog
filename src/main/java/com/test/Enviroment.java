package com.test;

import java.util.Properties;

/** 环境变量 @Auther: zhouwenbin @Date: 2019/5/17 10:47 */
public class Enviroment extends Properties {

  public int getInt(String key, int defaultValue) {
    String property = getProperty(key);
    return property == null ? defaultValue : Integer.parseInt(property);
  }

  public int getInt(String key) {
    return getInt(key, 0);
  }

  public String getString(String key, String defaultValue) {
    return getProperty(key, defaultValue);
  }

  public String getString(String key) {
    return getProperty(key, "");
  }

  public long getLong(String key, long defaultValue) {
    String property = getProperty(key);
    return property == null ? defaultValue : Long.parseLong(property);
  }

  public long getLong(String key) {
    return getLong(key, 0);
  }
}
