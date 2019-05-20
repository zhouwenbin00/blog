package com.test.utils.create;

/** 数据库字段对应的java字段 @Auther: zhouwenbin @Date: 2019/5/20 16:27 */
public enum Type {
  INT {
    @Override
    String type() {
      return "Integer";
    }
  },
  VARCHAR {
    @Override
    String type() {
      return "String";
    }
  },
  DATE {
    @Override
    String type() {
      return "Date";
    }

    String backage() {
      return "java.util.Date";
    }
  },
  ;

  abstract String type();

  String backage() {
    return null;
  }
}
