package com.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;


/**
 * Bean工具类
 *
 * @Author: zwb
 * @Date: 2019-05-19 12:55
 */
public class BeanUtil {

    final static Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * 从request获取对象
     *
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T newObjFromRequest(ServletRequest request, Class<T> clazz) {
        //检查非空
        ConditionsUtil.checkNotNull(request);
        ConditionsUtil.checkNotNull(clazz);
        //获取所有请求参数
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, Field> fieldMap = getFieldMap(clazz);
        T t = null;
        try {
            t = clazz.newInstance();
            while (parameterNames.hasMoreElements()) {
                //获取参数key
                String element = parameterNames.nextElement();
                if (fieldMap.containsKey(element)) {
                    Field declaredField = fieldMap.get(element);
                    //获取参数value
                    Object attribute = request.getParameter(element);
                    //获取类型
                    String type = declaredField.getType().toString();
                    //封装属性
                    if (type.endsWith("String")) {
                        declaredField.set(t, String.valueOf(attribute));
                    } else if (type.endsWith("int")) {
                        declaredField.set(t, Integer.parseInt(String.valueOf(attribute)));
                    } else if (type.endsWith("long")) {
                        declaredField.set(t, Long.parseLong(String.valueOf(attribute)));
                    } else {
                        LOGGER.error("{}类型属性没注入进去", type);
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 从结果集封装一个bean对象
     *
     * @param resultSet
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T newObjFromResultSet(ResultSet resultSet, Class<T> clazz) {
        //检查非空
        ConditionsUtil.checkNotNull(resultSet);
        ConditionsUtil.checkNotNull(clazz);
        T t = null;
        try {
            Map<String, Field> tmpField = getFieldMap(resultSet, clazz);
            //遍历结果集
            if (resultSet.next()) {
                t = clazz.newInstance();
                setField(tmpField, resultSet, t);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将结果集的bean对象封装一个List对象
     *
     * @param resultSet
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> newListFromResultSet(ResultSet resultSet, Class<T> clazz) {
        //检查非空
        ConditionsUtil.checkNotNull(resultSet);
        ConditionsUtil.checkNotNull(clazz);
        List<T> beanList = new ArrayList<>();
        try {
            Map<String, Field> tmpField = getFieldMap(resultSet, clazz);
            //遍历结果集
            while (resultSet.next()) {
                T t = clazz.newInstance();
                setField(tmpField, resultSet, t);
                beanList.add(t);
            }
        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return beanList;
    }

    /**
     * 获取结果集对应的属性集合
     *
     * @param resultSet
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> Map<String, Field> getFieldMap(ResultSet resultSet, Class<T> clazz) {
        //临时属性名集合
        Map<String, Field> tmpField = new HashMap<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            //临时列名集合
            List<String> tmpResultSet = new LinkedList<>();
            //遍历列名
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                tmpResultSet.add(columnName);
            }

            //遍历属性
            for (Field declaredField : clazz.getDeclaredFields()) {
                //获取属性key
                String name = declaredField.getName();
                //设置可访问
                declaredField.setAccessible(true);
                //匹配则注入该属性
                if (tmpResultSet.contains(name)) {
                    tmpField.put(name, declaredField);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpField;
    }

    /**
     * 获取bean对象的全部属性
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String, Field> getFieldMap(Class<T> clazz) {
        //临时属性名集合
        Map<String, Field> tmpField = new HashMap<>();
        //遍历属性
        for (Field declaredField : clazz.getDeclaredFields()) {
            //获取属性key
            String name = declaredField.getName();
            //设置可访问
            declaredField.setAccessible(true);
            //匹配则注入该属性
            tmpField.put(name, declaredField);
        }
        return tmpField;
    }

    /**
     * 将结果集的属性装入bean
     *
     * @param tmpField
     * @param resultSet
     * @param t
     * @param <T>
     */
    private static <T> void setField(Map<String, Field> tmpField, ResultSet resultSet, T t) {
        try {
            for (String key : tmpField.keySet()) {
                Field field = tmpField.get(key);
                //获取属性类型
                String type = field.getType().toString();
                if (type.endsWith("String")) {
                    field.set(t, resultSet.getString(key));
                } else if (type.endsWith("int")) {
                    field.set(t, resultSet.getInt(key));
                } else if (type.endsWith("long")) {
                    field.set(t, resultSet.getLong(key));
                } else {
                    LOGGER.error("{}类型属性没注入进去", type);
                }
            }
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }
}
