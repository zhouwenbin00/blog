<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--导航条--%>
<nav class="navbar navbar-inverse">
    <%--外层容器--%>
    <div class="container-fluid">
        <%--LOGO--%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=basePath%>index.jsp"> J2EE 博客</a>
        </div>
        <%--导航--%>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="<%=basePath%>index.jsp">首页</a></li>
                <li><a href="<%=basePath%>article_list.jsp">博文</a></li>
                <li><a href="#">个人随笔</a></li>
                <li><a href="<%=basePath%>message_board.jsp">留言板</a></li>
                <li><a href="<%=basePath%>about.jsp">关于本站</a></li>
            </ul>
            <%--搜索--%>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索博客，博主">
                </div>
                <button type="submit" class="btn btn-default"><span
                        class="glyphicon glyphicon-search"></span></button>
            </form>
            <%--个人中心--%>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle"><span
                                    class="glyphicon glyphicon-user"></span>${sessionScope.user.nickname}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=basePath%>article_manager.jsp">博客管理</a></li>
                                <li><a href="<%=basePath%>message_manager.jsp">消息管理</a></li>
                                <li><a href="<%=basePath%>edit_information.jsp">修改资料</a></li>
                                <li><a href="<%=basePath%>my_collection.jsp">我的收藏</a></li>
                                <li><a href="<%=basePath%>my_follow.jsp">我的关注</a></li>
                                <li><a href="<%=basePath%>user/logout">退出</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="login.jsp">登陆</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
