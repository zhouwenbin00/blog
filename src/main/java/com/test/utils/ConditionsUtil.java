package com.test.utils;

import com.sun.istack.internal.Nullable;

/** 条件工具类 @Auther: zhouwenbin @Date: 2019/5/17 15:06 */
public class ConditionsUtil {

  /**
   * 检查对象为是否为空
   *
   * @param obj
   * @param <T>
   * @return
   */
  public static <T> T checkNotNull(T obj) {
    if (obj == null) throw new NullPointerException();
    return obj;
  }

  /**
   * 检查对象为是否为空，为空则跑出空指针异常
   *
   * @param obj
   * @param errMsg
   * @param params
   * @param <T>
   * @return
   */
  public static <T> T checkNotNull(T obj, String errMsg, Object params) {
    //    if (obj == null) throw new NullPointerException(String.format(errMsg, params));
    if (obj == null) throw new NullPointerException(format(errMsg, params));
    return obj;
  }

  /**
   * 检查参数是否正确，否则抛异常
   *
   * @param isRight
   */
  public static void args(boolean isRight) {
    if (!isRight) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * 检查参数是否正确，否则抛异常
   *
   * @param isRight
   * @param errMsg
   * @param params
   */
  public static void checkArgument(boolean isRight, String errMsg, Object... params) {
    if (!isRight) {
      throw new IllegalArgumentException(format(errMsg, params));
    }
  }

  public static void checkArgument(boolean isRight) {
    if (!isRight) {
      throw new IllegalArgumentException();
    }
  }

  private static String format(String template, Object... args) {
    template = String.valueOf(template);
    StringBuilder sb = new StringBuilder();
    int templateStart = 0;
    int placeholderStart;
    int i;
    for (i = 0; i < args.length; templateStart = placeholderStart + 2) {
      // 寻找占位符
      placeholderStart = template.indexOf("%s", templateStart);
      // 没有占位符了
      if (placeholderStart == -1) {
        break;
      }
      sb.append(template, templateStart, placeholderStart);
      sb.append(args[i]);
      i++;
    }
    // 如果一个占位符都没得，就会是空串！！
    sb.append(template, templateStart, template.length());
    // 如果占位符比对象少，就会漏掉对象,所以要补在尾巴上
    if (i < args.length) {
      sb.append(" [");
      sb.append(args[i++]);
      while (i < args.length) {
        sb.append(", ");
        sb.append(args[i++]);
      }
      sb.append("]");
    }
    // 字符串拼完了toString一下
    return sb.toString();
  }
}
