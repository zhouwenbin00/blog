package com.test.utils.sql;

import com.sun.istack.internal.NotNull;
import com.test.utils.ConditionsUtil;
import com.test.utils.StringUtil;
import com.test.utils.Triple;

import java.util.ArrayList;
import java.util.List;

/** SQL构建器Where部件 @Auther: zhouwenbin @Date: 2019/5/20 10:25 */
public class Where implements SQL {
  private List<Triple<Conditions, String, Object>> wheres = new ArrayList<>();
  private int condtionsValueCounts;
  private String otherCondtions;

  private Where() {}

  public static Where create() {
    return new Where();
  }

  private void addWhere(Conditions conditions, String fieldName, Object value) {
    if (conditions != Conditions.QUOTE && !conditions.isRelation()) {
      ConditionsUtil.checkArgument(StringUtil.notEmptyOrNull(fieldName), "参数:%s不正确", fieldName);
    }
    if (wheres.isEmpty()) {
      ConditionsUtil.checkArgument(
          conditions != Conditions.AND && conditions != Conditions.OR, "不能以and（or）开头");
    } else {
      Triple<Conditions, String, Object> where = wheres.get(wheres.size() - 1);
      ConditionsUtil.checkArgument(
          conditions.isRelation() != where.getA().isRelation(), "非法的条件%s", conditions.name());
    }
    if (value != null) {
      ++condtionsValueCounts;
    }
    wheres.add(Triple.ofImmutable(conditions, fieldName, value));
  }
  public  Where whereOther(String other) {
    this.otherCondtions = other;
    return this;
  }


  /**
   * 等于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereEquals(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.EQUALS, fieldName, value);
    return this;
  }

  /**
   * 不等于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereNotEquals(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.NOT_EQUALS, fieldName, value);
    return this;
  }

  /**
   * 大于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereGreaterThan(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.GREATER_THAN, fieldName, value);
    return this;
  }

  /**
   * 大于等于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereEqualOrGreaterThan(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.EQUAL_OR_GREATER_THAN, fieldName, value);
    return this;
  }

  /**
   * 小于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereLessThan(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.LESS_THAN, fieldName, value);
    return this;
  }

  /**
   * 小于等于
   *
   * @param fieldName
   * @param value
   * @return
   */
  public Where whereEqualOrLessThan(@NotNull String fieldName, @NotNull Object value) {
    addWhere(Conditions.EQUAL_OR_LESS_THAN, fieldName, value);
    return this;
  }

  /**
   * 为空
   *
   * @param fieldName
   * @return
   */
  public Where whereNull(@NotNull String fieldName) {
    addWhere(Conditions.NULL, fieldName, null);
    return this;
  }

  /**
   * 不为空
   *
   * @param fieldName
   * @return
   */
  public Where whereNotNull(@NotNull String fieldName) {
    addWhere(Conditions.NOT_NULL, fieldName, null);
    return this;
  }

  /**
   * 括号
   *
   * @param another
   * @return
   */
  public Where quote(@NotNull Where another) {
    addWhere(Conditions.QUOTE, null, another);
    return this;
  }

  /**
   * 并且
   *
   * @return
   */
  public Where and() {
    addWhere(Conditions.AND, null, null);
    return this;
  }

  /**
   * 或者
   *
   * @return
   */
  public Where or() {
    addWhere(Conditions.OR, null, null);
    return this;
  }

  @Override
  public String sql() {
    StringBuilder builder = new StringBuilder();
    for (Triple<Conditions, String, Object> where : wheres) {
      Conditions conditions = where.getA();
      String fieldName = where.getB();
      Object value = where.getC();
      if (conditions == Conditions.QUOTE) {
        builder.append("(").append(((Where) value).sql()).append(")");
      } else if (conditions.isRelation()) {
        builder.append(conditions.symbol());
      } else {
        builder.append("`").append(fieldName).append("`").append(conditions.symbol());
        if (value != null) {
          builder.append("?");
        }
      }
      builder.append(" ");
    }
    builder.deleteCharAt(builder.length() - 1);
    if (StringUtil.notEmptyOrNull(otherCondtions)){
      builder.append(" "+otherCondtions);
    }
    return builder.toString();
  }

  private enum Conditions {
    // 相等
    EQUALS {
      @Override
      String symbol() {
        return "=";
      }
    },
    // 不等于
    NOT_EQUALS {
      @Override
      String symbol() {
        return "<>";
      }
    },
    // 大于
    GREATER_THAN {
      @Override
      String symbol() {
        return ">";
      }
    },
    // 大于等于
    EQUAL_OR_GREATER_THAN {
      @Override
      String symbol() {
        return ">=";
      }
    },
    // 小于
    LESS_THAN {
      @Override
      String symbol() {
        return "<";
      }
    },
    // 小于等于
    EQUAL_OR_LESS_THAN {
      @Override
      String symbol() {
        return "<=";
      }
    },
    // 为空
    NULL {
      @Override
      String symbol() {
        return "IS NULL";
      }
    },
    // 不为空
    NOT_NULL {
      @Override
      String symbol() {
        return "IS NOT NULL";
      }
    },
    // and
    AND {
      @Override
      String symbol() {
        return "and";
      }

      @Override
      boolean isRelation() {
        return true;
      }
    },
    // or
    OR {
      @Override
      String symbol() {
        return "or";
      }

      @Override
      boolean isRelation() {
        return true;
      }
    },
    // 括号
    QUOTE {
      @Override
      String symbol() {
        return null;
      }
    };

    abstract String symbol();

    boolean isRelation() {
      return false;
    }
  }


  @Override
  public Object[] params() {
    int count = 0;
    Object[] objects = new Object[condtionsValueCounts];
    for (Triple<Conditions, String, Object> where : wheres) {
      if (where.getC() == null) {
        continue;
      }
      objects[count++] = where.getC();
    }
    return objects;
  }
}
