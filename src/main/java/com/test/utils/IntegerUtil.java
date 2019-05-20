package com.test.utils;

/** @Auther: zhouwenbin @Date: 2019/5/20 12:50 */
public class IntegerUtil {

    public static boolean emptyOrZero(Integer value) {
        return value == null || value == 0;
    }

    public static boolean notEmptyOrNull(Integer value) {
        return !emptyOrZero(value);
    }
}
