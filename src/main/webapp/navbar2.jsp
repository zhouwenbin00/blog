<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--导航条--%>
<nav class="navbar navbar-inverse" style="border-radius:0">
    <div class="container-fluid">
        <%--Logo图标--%>
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=basePath%>index.jsp"> J2EE 博客</a>
        </div>
        <%--导航页--%>
        <div>
            <ul class="nav navbar-nav navbar-left">
                <li><a href="<%=basePath%>index.jsp">首页</a></li>
                <li><a href="<%=basePath%>article_list.jsp">博文</a></li>
                <li><a href="#">个人随笔</a></li>
                <li><a href="<%=basePath%>message_board.jsp">留言板</a></li>
                <li><a href="<%=basePath%>about.jsp">关于本站</a></li>
            </ul>
        </div>
        <%--搜索框--%>
        <%--<form class="navbar-form navbar-left">--%>
        <div class="input-group ">
            <input type="text" class="form-control" placeholder="搜索博文、作者">
            <span class="input-group-btn">
                    <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                </span>
        </div>
        <%--</form>--%>
        <%--退出、后台--%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle"><span
                        class="glyphicon glyphicon-user"></span>李浩源<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>article_manager.jsp">博客管理</a></li>
                    <li><a href="<%=basePath%>message_manager.jsp">消息管理</a></li>
                    <li><a href="<%=basePath%>edit_information.jsp">修改资料</a></li>
                    <li><a href="<%=basePath%>my_collection.jsp">我的收藏</a></li>
                    <li><a href="<%=basePath%>my_follow.jsp">我的关注</a></li>
                    <li><a href="#">退出</a></li>
                </ul>
            </li>
            <li><a href="login.jsp">登陆</a></li>
        </ul>
    </div>
</nav>
