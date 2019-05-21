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
  BIGINT {
    @Override
    String type() {
      return "Long";
    }
  },
  TINYINT {
    @Override
    String type() {
      return "Byte";
    }
  },
  TEXT {
    @Override
    String type() {
      return "String";
    }
  },
  TIMESTAMP {
    @Override
    String type() {
      return "Timestamp";
    }

    String backage() {
      return "java.sql.Timestamp";
    }
  },
  MEDIUMBLOB {
    @Override
    String type() {
      return "Integer";
    }
  },
  CHAR {
    @Override
    String type() {
      return "String";
    }
  },
  LONGVARCHAR {
    @Override
    String type() {
      return "String";
    }
  },
  NUMERIC {
    @Override
    String type() {
      return "BigDecimal";
    }

    String backage() {
      return " java.math.BigDecimal";
    }
  },
  DECIMAL {
    @Override
    String type() {
      return "BigDecimal";
    }

    String backage() {
      return " java.math.BigDecimal";
    }
  },
  BIT {
    @Override
    String type() {
      return "Boolean";
    }
  },
  BOOLEAN {
    @Override
    String type() {
      return "Boolean";
    }
  },
  DATETIME {
    @Override
    String type() {
      return "Timestamp";
    }

    String backage() {
      return "java.sql.Timestamp";
    }
  },
  ;

  abstract String type();

  String backage() {
    return null;
  }
}
