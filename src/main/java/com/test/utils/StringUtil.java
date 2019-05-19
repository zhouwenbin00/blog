package com.test.utils;

/** String工具类 @Auther: zhouwenbin @Date: 2019/5/20 10:49 */
public class StringUtil {

  public static boolean emptyOrNull(String value) {
    return value == null || value.trim().length() == 0;
  }


    public static boolean notEmptyOrNull(String value) {
        return !emptyOrNull(value);
    }
}
