package com.test.utils.sql;

/** 删除@Auther: zhouwenbin @Date: 2019/5/20 11:36 */
public class Delete implements SQL {
  private static final String TEMPLATE = "DELETE FROM `%s` WHERE %s;";
  private String tableName;
  private Where where;

  private Delete() {}

  public static Delete create() {
    return new Delete();
  }

  private Delete from(String tableName) {
    this.tableName = tableName;
    return this;
  }

  private Delete where(Where where) {
    this.where = where;
    return this;
  }

  @Override
  public String sql() {
    return String.format(TEMPLATE , tableName ,where.sql());
  }

  @Override
  public Object[] params() {
    return where.params();
  }
}
