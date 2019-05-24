package com.test;

import com.test.utils.BeanUtil;
import com.test.utils.DBUtil;
import com.test.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhouwenbin @Date: 2019/5/17 10:27
 */
public class InitDb {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitDb.class);

    /**
     * 初始化数据库
     *
     * @param config
     * @throws Exception
     */
    public static void initDB(SerivceEnviroment config) throws Exception {
        // 创建数据库
        String url = config.getDbUrl().substring(0, config.getDbUrl().lastIndexOf("/"));
        String database =
                config.getDbUrl().split("[?]")[0].substring(config.getDbUrl().lastIndexOf("/") + 1);
        String sql =
                "CREATE DATABASE IF NOT EXISTS `"
                        + database
                        + "` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;";

        // todo 获取连接
        LOGGER.info("开始初始化数据库");
        try (Connection connection = DBUtil.getConnection(url, config.getDbUsr(), config.getDbPwd())) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                //        LOGGER.info("\n" + sql);
                LOGGER.info("创建数据库{}", database);
            }
        }
        // 建表
        // todo 获取连接
        try (Connection connection =
                     DBUtil.getConnection(config.getDbUrl(), config.getDbUsr(), config.getDbPwd())) {
            String sqlFile = "table.sql";
            InputStream stream = FileUtil.newFileInputStream(sqlFile);
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len;
            while ((len = stream.read(buf)) > 0) {
                sb.append(new String(buf, 0, len));
            }
            String sqls = sb.toString();
            stream.close();
            for (String s : sqls.split("[;]")) {
                try (PreparedStatement tablePrepare = connection.prepareStatement(s)) {
                    tablePrepare.execute();
                    LOGGER.info("创建表");
                }
            }
        }
        LOGGER.info("数据库初始化完成");
    }

    /**
     * 通过实体类建表
     */
    public static void CreateTable() {
        String packageName = "com.test.bean";
        List<Class<?>> clazzes = FileUtil.getClasssFromPackage(packageName, true);
        for (Class<?> clazz : clazzes) {
            StringBuilder sb = new StringBuilder();
            String name = clazz.getName();
            String table = "t_" + name.toLowerCase().substring(name.lastIndexOf(".") + 1, name.length());
            sb.append("CREATE TABLE IF NOT EXISTS `").append(table).append("`").append("\n");
            sb.append("(" + "\n");
            Map<String, Field> fieldMap = BeanUtil.getFieldMap(clazz);
            //todo NOT NULL?
            for (String key : fieldMap.keySet()) {
                Field field = fieldMap.get(key);
                String type = field.getType().toString();
                if (type.endsWith("String")) {
                    sb.append("`").append(key).append("` VARCHAR(255),").append("\n");
                } else if (type.endsWith("int")) {
                    sb.append("`").append(key).append("` INT NOT NULL,").append("\n");
                } else if (type.endsWith("Date")) {
                    sb.append("`").append(key).append("` DATE,").append("\n");
                }else if (type.endsWith("Integer")) {
                    sb.append("`").append(key).append("` INTEGER,").append("\n");
                } else {
                    LOGGER.error("{}类型属性没注入进去", type);
                }
            }
            //todo PRIMARY KEY?
            if (fieldMap.containsKey("id")) {
                sb.append("PRIMARY KEY (`id`)" + "\n");
            }
            sb.append(") ENGINE = INNODB" +
                    "  DEFAULT CHARSET = utf8; " + "\n");
            String sql = sb.toString();
            System.out.println(sql);
            DBUtil.executeUpdate(sql);
        }


    }


    public static void main(String[] args) throws Exception {
//    InitDb.initDB( SerivceEnviroment.getSerivceEnviroment());
        CreateTable();
    }
}
