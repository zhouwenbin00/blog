package com.test.utils;

import com.test.SerivceEnviroment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

/**
 * DB工具类
 *
 * @Auther: zhouwenbin @Date: 2019/5/17 16:47
 */
public class DBUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtil.class);
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url;
    private static String usr;
    private static String pwd;

    private DBUtil() {
    }

    static {
        /** 驱动注册 */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SerivceEnviroment serivceEnviroment = SerivceEnviroment.getSerivceEnviroment();
        url = serivceEnviroment.getDbUrl();
        usr = serivceEnviroment.getDbUsr();
        pwd = serivceEnviroment.getDbPwd();
    }

    /**
     * 通过url, user, password获取 Connetion
     *
     * @param url
     * @param user
     * @param password
     * @return
     * @throws SQLException
     */
    public static Connection getConnection(String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(url, usr, pwd);
    }

    /**
     * 执行update
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = -1;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement = setSqlParams(connection, sql, params);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(connection, preparedStatement, null);
        }
        return i;
    }

    /**
     * 执行查询，返回bean集合
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> QueryList(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
            connection = getConnection();
            preparedStatement = setSqlParams(connection, sql, params);
            resultSet = preparedStatement.executeQuery();
            list = BeanUtil.newListFromResultSet(resultSet, clazz);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(connection, preparedStatement, resultSet);
        }

        return list;
    }

    /**
     * 执行查询，返回bean对象
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T QueryOne(String sql, Class<T> clazz, Object[] params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        T t = null;
        try {
            connection = getConnection();
            preparedStatement = setSqlParams(connection, sql, params);
            resultSet = preparedStatement.executeQuery();
            t = BeanUtil.newObjFromResultSet(resultSet, clazz);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return t;
    }

//    public static <T> void QueryOneByObject(T t) throws IllegalAccessException {
//        Map<String, Field> fieldMap = BeanUtil.getFieldMap(t.getClass());
//        for (String key : fieldMap.keySet()) {
//            Field field = fieldMap.get(key);
//            String type = field.getType().toString();
//            Object value = field.get(t);
//            String s = String.valueOf(value);
//
//            System.out.println(value);
//
//        }
//
////        QueryOne(sql,t.getClass(),params);
//
//    }

    /**
     * 设置sql参数
     *
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    private static PreparedStatement setSqlParams(Connection connection, String sql, Object... params) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @param statement
     * @param rs
     */
    private static void close(Connection connection, Statement statement, ResultSet rs) {
        close(rs);
        close(statement);
        close(connection);
    }

    private static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
