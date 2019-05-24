package com.test.utils;

/** String工具类 @Auther: zhouwenbin @Date: 2019/5/20 10:49 */
public class StringUtil {

  public static boolean emptyOrNull(String value) {
    return value == null || value.trim().length() == 0;
  }


    public static boolean notEmptyOrNull(String value) {
        return !emptyOrNull(value);
    }

  public static String toCamelCase(int flag, String name) {
    for (int i = 0; i < name.length(); i++) {
      if (name.substring(i, i + 1).equals("_")) {
        if (name.substring(i + 1).length() == 0) {
          name = name = name.substring(0, i);
        } else {
          name =
                  name.substring(0, i)
                          + name.substring(i + 1).substring(0, 1).toUpperCase()
                          + name.substring(i + 2);
        }
      }
    }
    if (flag == 0) {
      if (name.length() > 1) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
      } else {
        name = name.toLowerCase();
      }
    } else {
      // 如果flag=1 大驼峰
      if (name.length() > 1) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
      } else {
        name = name.toUpperCase();
      }
    }
    return name;
  }
}
