<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 15:12
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
        <li class="active">消息管理</li>
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
        <%--博文--%>
        <div class="col-md-9">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">评论</a></li>
                <li><a href="#svn" data-toggle="tab">回复</a></li>
                <li><a href="#ios" data-toggle="tab">私信</a></li>
                <li><a href="#java" data-toggle="tab">粉丝</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-body">
                                    <div class="media">
                                        <div class="media-left">
                                            <a href="#">
                                                <img src="images/me.jpg" class="media-object" alt="" height="64"
                                                     width="64">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                            <a href="#">李浩源</a>在文章<a href="#"># 这就是李浩源</a>中评论了您：
                                            <p style="color: #737373">
                                                骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                            </p>
                                            <a href="#" class="btn btn-link">进入文章</a>
                                            <a href="#" class="btn btn-link">回复</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="tab-pane fade" id="svn">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-body">
                                    <div class="media">
                                        <div class="media-left">
                                            <a href="#">
                                                <img src="images/me.jpg" class="media-object" alt="" height="64"
                                                     width="64">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                            <a href="#">李浩源</a>在文章<a href="#"># 这就是李浩源</a>中回复了您的评论：<span
                                                style="color: #737373">#骚哥牛皮</span>
                                            <p style="color: #737373">
                                                骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                            </p>
                                            <a href="#" class="btn btn-link">进入文章</a>
                                            <a href="#" class="btn btn-link">回复</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="tab-pane fade" id="ios">3</div>
                <div class="tab-pane fade" id="java">4</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
