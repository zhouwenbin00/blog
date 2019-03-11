<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 19:38
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
<div class="container">
    <div class="page-header">
        <h1>用户注册</h1>
    </div>
    <div class="row col-md-4">
        <form action="" method="post">
            <div class="form-group">
                <div class="form-group">
                    <label for="nickname">昵称：</label>
                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="昵称">
                </div>
                <div class="form-group">
                    <label for="username">账号：</label>
                    <input type="email" class="form-control"  id="username" name="username" placeholder="账号">
                </div>
                <div class="form-group">
                        <label for="password" >密码：</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="长度为6到18个字符，不能包括空格">
                </div>
                <div class="form-group">
                    <label for="password2">确认密码：</label>
                    <input type="text" class="form-control" id="password2" name="password2" placeholder="长度为6到18个字符，不能包括空格">
                </div>
                <button class="btn btn-success btn-block">注册</button>
                <a href="<%=basePath%>login.jsp" class="btn btn-link">已有账号？立即登陆>>></a>
            </div>
        </form>
    </div>
</div>
<%--底部--%>
<div class="container" >
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