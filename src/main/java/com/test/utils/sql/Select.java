package com.test.utils.sql;

import com.test.utils.ConditionsUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/** 查询 @Auther: zhouwenbin @Date: 2019/5/20 11:37 */
public class Select implements SQL {
  private static String TEMPLATE = "SELECT %s FROM `%s` %s;";
  private String[] fields;
  private String tableName;
  private Where where;

  public static Select create(String... fields) {
    return new Select(fields);
  }

  private Select(String... fields) {
    ConditionsUtil.checkArgument(fields != null && fields.length > 0);
    this.fields = fields;
  }

  public Select from(String tableName) {
    this.tableName = tableName;
    return this;
  }

  public Select where(Where where) {
    this.where = where;
    return this;
  }

  @Override
  public String sql() {
    StringBuilder fieldPos = new StringBuilder();
//    if (Arrays.asList(fields).contains("*")) {
//      if (fields.length == 1) {
//        fieldPos.append("`").append("*").append("`").append(",");
//      } else {
//
//      }
//    }

    for (String fieldName : fields) {
      if (fieldName.contains("*")) {

        fieldPos.append(fieldName).append(",");
      } else {
        fieldPos.append("`").append(fieldName).append("`").append(",");
      }
    }
    fieldPos.deleteCharAt(fieldPos.length() - 1);
    return String.format(
        TEMPLATE, fieldPos.toString(), tableName, where == null ? "" : "WHERE " + where.sql());
  }

  @Override
  public Object[] params() {
    return where == null ? null : where.params();
  }
}
