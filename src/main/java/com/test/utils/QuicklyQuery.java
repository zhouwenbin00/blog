package com.test.utils;

import com.test.bean.User;
import com.test.utils.sql.Insert;
import com.test.utils.sql.Prepare;
import com.test.utils.sql.Select;
import com.test.utils.sql.Where;
import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** @Auther: zhouwenbin @Date: 2019/5/20 13:46 */
public class QuicklyQuery {

  public <T> List<T> selectByObject(T t) {
    ConditionsUtil.checkNotNull(t);
    List<T> list = new ArrayList<>();
    try {
      Class<T> clazz = (Class<T>) t.getClass();
      String name = clazz.getName().toLowerCase();
//      String table = "t_" + name.toLowerCase().substring(name.lastIndexOf(".") + 1, name.length());
      String table = name.toLowerCase().substring(name.lastIndexOf(".") + 1, name.length());
      Map<String, Field> fieldMap = BeanUtil.getFieldMap(clazz);
      Where where = Where.create();
      for (Field field : fieldMap.values()) {
        Object o = field.get(t);
        if (o == null) {
          continue;
        }
        where.whereEquals(field.getName(), o).and();
      }
      Select select = Prepare.select("*").from(table).where(where.whereOther("1=1"));
      list = DBUtil.QueryList(select, clazz);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return list;
  }

  public <T> int insertObject(T t) {
    ConditionsUtil.checkNotNull(t);
    int i = 0;
    try {
      Class<T> clazz = (Class<T>) t.getClass();
      String name = clazz.getName().toLowerCase();
//      String table = "t_" + name.toLowerCase().substring(name.lastIndexOf(".") + 1, name.length());
      String table = name.toLowerCase().substring(name.lastIndexOf(".") + 1, name.length());
      Map<String, Field> fieldMap = BeanUtil.getFieldMap(clazz);
      List<Object> params = new ArrayList<>();
      for (Field field : fieldMap.values()) {
        Object o = field.get(t);
        if (o == null) {
          continue;
        }
        params.add(field.getName());
        params.add(o);
      }
      Insert insert = Prepare.insert().into(table).values(params.toArray());
      i = DBUtil.executeUpdate(insert);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return i;
  }

  public static void main(String[] args) {
    QuicklyQuery quicklyQuery = new QuicklyQuery();

    User user = new User();
    user.setUsername("lisi");
    user.setPassword("lisi");
    user.setNickname("李四");
    quicklyQuery.insertObject(user);
  }
}
