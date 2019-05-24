<%@ page import="com.test.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-05-19
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="<%=basePath%>css/common.css">
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<body>
 ${requestScope.article.content}

</body>
</html>
