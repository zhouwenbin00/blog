package com.test.utils.sql;

import com.test.utils.ConditionsUtil;

/** 插入@Auther: zhouwenbin @Date: 2019/5/20 11:13 */
public class Insert implements SQL {
  private static final String TEMPLATE = "INSERT INTO `%s`(%s) VALUES(%s);";
  private String tableName;
  private String[] fieldNames;
  private Object[] fieldValues;

  private Insert() {}

  public static Insert create() {
    return new Insert();
  }

  private Insert into(String tableName) {
    this.tableName = tableName;
    return this;
  }

  private Insert values(Object... values) {
    ConditionsUtil.checkArgument(
        values != null && values.length > 0 && (values.length & 1) == 0, "长度必须为2n");
    int length = values.length >> 1;
    fieldNames = new String[length];
    fieldValues = new Object[length];
    for (int i = 0; i < length; i++) {
      fieldNames[i] = values[i << 1].toString();
      fieldValues[i] = values[(i << 1) + 1];
    }
    return this;
  }

  @Override
  public String sql() {
    StringBuilder nameBuilder = new StringBuilder();
    StringBuilder pos = new StringBuilder();
    for (String name : fieldNames) {
      nameBuilder.append("`").append(name).append("`").append(",");
      pos.append("?").append(",");
    }
    nameBuilder.deleteCharAt(nameBuilder.length() - 1);
    pos.deleteCharAt(pos.length() - 1);
    return String.format(Insert.TEMPLATE, tableName, nameBuilder.toString(), pos.toString());
  }

  @Override
  public Object[] params() {
    return fieldValues;
  }
}
