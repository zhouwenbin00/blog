<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
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
<%--最外层容器--%>
<div class="container">
    <%--路径导航--%>
    <ol class="breadcrumb">
        <li class="active"><span class="glyphicon glyphicon-map-marker"></span>当前位置：</li>
        <li><a href="<%=basePath%>index.jsp">首页</a></li>
        <li class="active">个人中心</li>
        <li class="active">我的关注</li>
    </ol>
    <div class="row">
        <%--个人信息--%>
        <div class="col-md-3">
            <div class="panel panel-default">
                <%--头像--%>
                <div class="panel-body" style="text-align: center">
                    <div class="center-block" style="width: 100px;">
                        <img src="images/me.jpg" class="img-responsive img-circle" width="100" height="100" alt="">
                        <label>李浩源</label>
                    </div>
                </div>
                <ul class="list-group">
                    <li class="list-group-item clearfix">
                        <div class="pull-left">博文数量</div>
                        <div class="pull-right">11</div>
                    </li>
                    <li class="list-group-item clearfix">
                        <div class="pull-left">粉丝数</div>
                        <div class="pull-right">110</div>
                    </li>
                    <li class="list-group-item clearfix">
                        <div class="pull-left">访问量</div>
                        <div class="pull-right">1511</div>
                    </li>
                </ul>
            </div>
        </div>
        <%--我的关注--%>
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title">修改资料</h1>
                </div>
                <div class="panel-body">
                    <form action="" method="post" class="col-md-6">
                        <div class="form-group">
                            <label for="">昵称：</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">头像：</label>
                            <input type="file">
                            <img src="" width="64" height="64" alt="">
                        </div>

                        <div class="form-group">
                            <label for="">邮箱：</label>
                            <input type="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">简介：</label>
                            <textarea type="text" class="form-control"></textarea>
                        </div>
                        <button class="btn btn-success " type="submit">提交</button>
                    </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>

