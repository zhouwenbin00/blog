package com.test.utils.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/** 生成实体类@Auther: zhouwenbin @Date: 2019/5/20 15:21 */
public class GenerateBeanCode {
  private static final Logger LOGGER = LoggerFactory.getLogger(GenerateBeanCode.class);

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL =
      "jdbc:mysql://127.0.0.1:3306/blog?autoReconnect=true&characterEncoding=UTF-8";
  private static final String USERNAME = "game";
  private static final String PASSWORD = "game";

  private static final String SQL = "SELECT * FROM "; // 数据库操作

  static List<String> importList = new ArrayList<>();

  private String packageName;
  private String path;

  static {
    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      LOGGER.error("can not load jdbc driver", e);
    }
  }

  /**
   * 获取数据库连接
   *
   * @return
   */
  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
      LOGGER.error("get connection failure", e);
    }
    return conn;
  }

  /**
   * 关闭数据库连接
   *
   * @param conn
   */
  public static void closeConnection(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        LOGGER.error("close connection failure", e);
      }
    }
  }

  /**
   * 设置包路径
   *
   * @param path
   */
  public void setPath(String path) {
    this.packageName = path;
    String srcPath = System.getProperty("user.dir") + "\\src\\main\\java";
    System.out.println("srcPath:" + srcPath);
    path = path.replace(".", "\\");
    this.path = srcPath + "\\" + path;
    File file = new File(this.path);
    if (!file.exists()) {
      file.mkdirs();
    }
    System.out.println(this.path);
  }

  /**
   * 获取全部表名
   *
   * @return
   * @throws SQLException
   */
  public List<String> getTableNames() throws SQLException {
    List<String> tableNames = new ArrayList<>();
    Connection conn = getConnection();
    ResultSet rs = null;
    try {
      // 获取数据库的元数据
      DatabaseMetaData db = conn.getMetaData();
      // 从元数据中获取到所有的表名
      rs = db.getTables(null, null, null, new String[] {"TABLE"});
      while (rs.next()) {
        tableNames.add(rs.getString(3));
      }
    } catch (SQLException e) {
      LOGGER.error("getTableNames failure", e);
    } finally {
      try {
        rs.close();
        closeConnection(conn);
      } catch (SQLException e) {
        LOGGER.error("close ResultSet failure", e);
      }
    }
    return tableNames;
  }

  /**
   * 获取表中所有字段名称
   *
   * @param tableName 表名
   * @return
   */
  public static List<String> getColumnNames(String tableName) {
    List<String> columnNames = new ArrayList<>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL + tableName;
    try {
      pStemt = conn.prepareStatement(tableSql);
      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        columnNames.add(rsmd.getColumnName(i + 1));
      }
    } catch (SQLException e) {
      LOGGER.error("getColumnNames failure", e);
    } finally {
      if (pStemt != null) {
        try {
          pStemt.close();
          closeConnection(conn);
        } catch (SQLException e) {
          LOGGER.error("getColumnNames close pstem and connection failure", e);
        }
      }
    }
    return columnNames;
  }

  /**
   * 获取FieldBean列表
   *
   * @param tableName
   * @return
   */
  public static List<FieldBean> getFeildBeanList(String tableName) {
    List<FieldBean> list = new ArrayList<>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL + tableName;
    try {
      pStemt = conn.prepareStatement(tableSql);
      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        list.add(
            new FieldBean(
                Type.valueOf(rsmd.getColumnTypeName(i + 1)).type(), rsmd.getColumnName(i + 1)));
        addToImportList(Type.valueOf(rsmd.getColumnTypeName(i + 1)).backage());
      }
    } catch (SQLException e) {
      LOGGER.error("getFeildBean failure", e);
    } finally {
      if (pStemt != null) {
        try {
          pStemt.close();
          closeConnection(conn);
        } catch (SQLException e) {
          LOGGER.error("test close pstem and connection failure", e);
        }
      }
    }
    return list;
  }

  private static void addToImportList(String type) {
    // 类型判断是否需要导包
    // 然后放到importList
    if (type == null) {
      return;
    }
    if (importList.contains(type)) {
      return;
    }
    importList.add(type);
  }

  /**
   * 获取表中所有字段类型
   *
   * @param tableName
   * @return
   */
  public static List<String> getColumnTypes(String tableName) {
    List<String> columnTypes = new ArrayList<>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL + tableName;
    try {
      pStemt = conn.prepareStatement(tableSql);
      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        columnTypes.add(rsmd.getColumnTypeName(i + 1));
      }
    } catch (SQLException e) {
      LOGGER.error("getColumnTypes failure", e);
    } finally {
      if (pStemt != null) {
        try {
          pStemt.close();
          closeConnection(conn);
        } catch (SQLException e) {
          LOGGER.error("getColumnTypes close pstem and connection failure", e);
        }
      }
    }
    return columnTypes;
  }

  /**
   * 获取表中字段的所有注释
   *
   * @param tableName
   * @return
   */
  public static Map<String, String> getColumnComments(String tableName) {
    Map<String, String> map = new HashMap<>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL + tableName;
    ResultSet rs = null;
    try {
      pStemt = conn.prepareStatement(tableSql);
      rs = pStemt.executeQuery("show full columns from " + tableName);
      while (rs.next()) {
        String field = rs.getString("Field");
        String comment = rs.getString("Comment");
        if (comment.equals("")) {
          continue;
        }
        map.put(field, comment);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
          closeConnection(conn);
        } catch (SQLException e) {
          LOGGER.error("getColumnComments close ResultSet and connection failure", e);
        }
      }
    }
    return map;
  }

  public Map<String, List<FieldBean>> getTableFeildMap() throws SQLException {
    Map<String, List<FieldBean>> map = new HashMap<>();
    List<String> tableNames = getTableNames();
    for (String tableName : tableNames) {
      List<FieldBean> list = getFeildBeanList(tableName);
      map.put(tableName, list);
    }
    return map;
  }

  /**
   * java驼峰转换
   *
   * @param flag
   * @param name
   * @return
   */
  public String toCamelCase(int flag, String name) {
    for (int i = 0; i < name.length(); i++) {
      if (name.substring(i, i + 1).equals("_")) {
        if (name.substring(i + 1).length() == 0) {
          name = name = name.substring(0, i);
        } else {
          name =
              name.substring(0, i)
                  + name.substring(i + 1).substring(0, 1).toUpperCase()
                  + name.substring(i + 2);
        }
      }
    }
    if (flag == 0) {
      if (name.length() > 1) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
      } else {
        name = name.toLowerCase();
      }
    } else {
      // 如果flag=1 大驼峰
      if (name.length() > 1) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
      } else {
        name = name.toUpperCase();
      }
    }
    return name;
  }

  private void append(File file, String content) {
    try {
      FileWriter fileWriter = new FileWriter(file, true);
      fileWriter.append(content);
      fileWriter.close();
    } catch (IOException e) {
      LOGGER.error("append failure", e);
    }
  }

  /**
   * 如果文件存在，那就删除然后新建，不存在就直接新建
   *
   * @param file
   */
  private void setFile(File file) {
    // 如果不存在
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
        LOGGER.error("create New File failure", e);
      }
    } else {
      file.delete();
      try {
        file.createNewFile();
      } catch (IOException e) {
        LOGGER.error("create New File failure", e);
      }
    }
  }

  /**
   * 创建bean文件
   *
   * @throws SQLException
   */
  public void generate() throws SQLException {
    // 创建java文件
    path = path == null || path.equals("") ? "e:\\" : path;
    Map<String, List<FieldBean>> map = getTableFeildMap();

    for (String key : map.keySet()) {
      Map<String, String> columnComments = getColumnComments(key);
      System.out.println(key);
      // 这里创建文件
      File file = new File(path + "\\" + toCamelCase(1, key) + ".java");
      setFile(file);
      // package 声明
      append(file, String.format("package %s;" + "\r\n\r\n", packageName));
      // 导包文本添加
      for (String str : importList) {
        append(file, String.format("import %s;" + "\r\n\r\n", str));
      }
      append(file, String.format("public class %s {" + "\r\n", toCamelCase(1, key)));
      for (FieldBean fieldBean : map.get(key)) {
        // 写入文本
        // 写入注释
        if (columnComments.containsKey(fieldBean.getName())) {
          append(
              file,
              String.format(
                  "\r\n" + "\t" + "/** %s*/" + "\r\n", columnComments.get(fieldBean.getName())));
        } else {
          append(file, "\r\n");
        }

        // 写入变量声明部分
        append(
            file,
            String.format(
                "\t" + "private %s %s;" + "\r\n",
                fieldBean.getType(), toCamelCase(0, fieldBean.getName())));
      }
      append(file, "\r\n");
      for (FieldBean fieldBean : map.get(key)) {
        // 写入setter getter
        append(
            file,
            String.format(
                "\t"
                    + "public void %s(%s %s) {"
                    + "\r\n"
                    + "\t"
                    + "\t"
                    + "this.%s = %s;"
                    + "\r\n"
                    + "\t"
                    + "}"
                    + "\r\n"
                    + "\r\n",
                toCamelCase(1, fieldBean.getName()),
                fieldBean.getType(),
                toCamelCase(0, fieldBean.getName()),
                toCamelCase(0, fieldBean.getName()),
                toCamelCase(0, fieldBean.getName())));
        append(
            file,
            String.format(
                "\t"
                    + "public %s %s() {"
                    + "\r\n"
                    + "\t"
                    + "\t"
                    + "return %s;"
                    + "\r\n"
                    + "\t"
                    + "}"
                    + "\r\n"
                    + "\r\n",
                fieldBean.getType(),
                toCamelCase(1, fieldBean.getName()),
                toCamelCase(0, fieldBean.getName())));
      }
      append(file, "}");
      importList.clear();
    }
  }

  public static void main(String[] args) throws SQLException {
    GenerateBeanCode code = new GenerateBeanCode();
    code.setPath("com.test.bean");
    code.generate();
  }
}
