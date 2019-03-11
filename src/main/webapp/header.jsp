<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>J2EE Blog</title>

    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/common.css">
    <link rel="stylesheet" href="<%=basePath%>fonts/iconfont.css">

    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
</head>

<body>
