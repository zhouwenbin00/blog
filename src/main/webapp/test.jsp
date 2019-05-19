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
<script src="js/jquery.min.js" type="text/javascript"></script>
<body>
 <%--${sessionScope.user.nickname}--%>
 <%--${sessionScope.user.username}--%>
<%
//User user =   (User)session.getAttribute("user");
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        String name = cookie.getName();
        String value = cookie.getValue();
%>
<%=name%>
<%=value%>
<%
    }
%>
<%--<%=user.getNickname()%>--%>
<%--${cookie.username.value}--%>
 <button onclick="send()">点"</button>
 <script>
     function send(){
         $.post("<%=basePath%>testServlet",{id:'1',username:'zhangsan',password:'123',birthday:'2018-05-07'},function(result){
         });
     }

 </script>





</body>
</html>
