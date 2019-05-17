package com.test.servlet;

import com.test.bean.User;
import com.test.utils.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zwb
 * @Date: 2019-05-19 13:27
 */
@WebServlet(name = "TestServlet",value = "/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = BeanUtil.newObjFromRequest(request, User.class);

        System.out.println(user.getId());
        System.out.println( user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getNickname());
        System.out.println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
