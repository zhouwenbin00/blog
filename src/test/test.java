import com.test.SerivceEnviroment;
import com.test.bean.User;
import com.test.utils.BeanUtil;
import com.test.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author: zwb
 * @Date: 2019-05-19 0:10
 */
public class test {

    @Test
    public void test1() throws SQLException {
//        Connection connection = DBUtil.getConnection();
//        Connection connection2 = DBUtil.getConnection();
//        SerivceEnviroment serivceEnviroment = SerivceEnviroment.getSerivceEnviroment();
//        if (connection!=null){
//            System.out.println(123);
//        }
//        String sql = "SELECT * FROM t_user WHERE username =? and password=?";
//        ResultSet resultSet = DBUtil.executeQuery(sql, "zhangsan", "123");
//        User user = BeanUtil.newObjFromResultSet(resultSet, User.class);
//        System.out.println(user);
//        BeanUtil.newListFromReSult(resultSet , List<User.class> clazz );
//        User user = null;
//        try {
//            if (resultSet.next()){
//                user= new User();
//                user.setId(resultSet.getInt("id"));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setNickname(resultSet.getString("nickname"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);
    }


    @Test
    public void test2() {
//        String sql = "SELECT * FROM t_user";
//        ResultSet resultSet = DBUtil.executeQuery(sql);
//        List<User> users = BeanUtil.newListFromResultSet(resultSet, User.class);
//        for (User user : users) {
//            System.out.println(user);
//        }
    }


    @Test
    public void test3() throws IllegalAccessException {
//        User user = new User();
////        user.setId(1);
//        user.setUsername("zhansan");
//        DBUtil.QueryOneByObject(user);

    }
}
