package com.test.utils.create;

/** @Auther: zhouwenbin @Date: 2019/5/20 16:36 */
public class FieldBean {

  private String type;
  private String name;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FieldBean(String type, String name) {
    this.type = type;
    this.name = name;
  }
}
