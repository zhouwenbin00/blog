<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<%--登陆页面--%>
<div class="container" style="padding: 20px">
    <div class="row col-md-4">
        <div class="page-header">
            <h1>用户登陆</h1>
        </div>
        <%--表单--%>
        <form action="" method="post" onsubmit="">
            <%--用户名--%>
            <div class="form-group">
                <label for="username">账号：</label>
                <input id="username" type="text" class="form-control" placeholder="请输入您的账号" name="username">
            </div>
            <%--密码--%>
            <div class="form-group">
                <label for="password">密码：</label>
                <input id="password" type="password" class="form-control" placeholder="请输入您的密码" name="password">
            </div>
            <%--记住密码--%>
            <div class="checkbox">
                <label>
                    <input type="checkbox">记住密码
                </label>
            </div>
            <%--登陆按钮--%>
            <a type="submit" class="btn btn-success btn-block" href="index.jsp">登陆</a>
            <a href="<%=basePath%>register.jsp" class="btn btn-link">没有账号？立即注册>>></a>
        </form>
    </div>
</div>
<%--底部--%>
<div class="container" style="margin-top: 5%;">
    <footer>
        <div class="col-md-8 col-md-offset-2">
            <hr>
            <p>Copyright &copy; 2019 &middot; UI based on Bootstrap 3
                &middot; <a href="<%=basePath %>AdminLogin.jsp" target="_blank">admin</a>
                &middot; 2825075112@qq.com
                &middot;访问人数：${num}
            </p>
        </div>
    </footer>
</div>
</body>
</html>