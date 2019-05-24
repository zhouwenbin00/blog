<%@ page import="com.test.bean.Article" %>
<%@ page import="com.test.utils.DBUtil" %>
<%@ page import="com.test.bean.User" %>
<%@ page import="com.test.utils.QuicklyQuery" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    Article article = (Article) request.getAttribute("article");
    Integer auther = article.getAuther();
    User user =new User();
    user.setId(auther);
    QuicklyQuery quicklyQuery = new QuicklyQuery();
    List<User> list = quicklyQuery.selectByObject(user);
    if (!list.isEmpty()){
        user = list.get(0);
    }
    String content = new String(article.getContent());
%>
<jsp:include page="header.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <%--路径导航--%>
    <ol class="breadcrumb">
        <li class="active"><span class="glyphicon glyphicon-map-marker"></span>当前位置：</li>
        <li><a href="<%=basePath%>index.jsp">首页</a></li>
        <li><a href="<%=basePath%>article_list.jsp">博文列表</a></li>
        <li class="active">博文详情</li>
    </ol>
    <div class="row">
        <%--左侧帮助--%>
        <jsp:include page="left_help.jsp" />
        <%--首页左侧--%>
        <div class="col-md-9">
            <%--博文列表--%>
            <div class="panel panel-default">
              <div class="panel-body">
                  <div class="page-header">
                      <h2>${requestScope.article.title}<span class="label label-success"><c:choose>
                          <c:when test="${requestScope.article.original==1}">
                              原
                          </c:when>
                          <c:otherwise>
                              转
                          </c:otherwise>
                      </c:choose></span></h2>
                      <label style="color: #999999">作者：<a href="<%=basePath%>author_homepage.jsp"><%=user.getNickname()%></a> <span class="glyphicon glyphicon-time"></span> ${requestScope.article.createDate} <a href="#"><span
                              class="glyphicon glyphicon-thumbs-up"></span> ${requestScope.article.like}</a></label>
                  </div>
                  <div>
                      <%=content%>
                  </div>

              </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
