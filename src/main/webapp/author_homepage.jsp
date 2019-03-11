<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 15:36
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
            <li><a href="<%=basePath%>article_list.jsp">博文列表</a></li>
            <li><a href="<%=basePath%>article_details.jsp">博文详情</a></li>
            <li class="active">作者主页</li>
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
                    <li class="list-group-item "><a href="#" class="btn btn-success btn-block">关注</a></li>
                </ul>
            </div>
        </div>
        <%--博文--%>
        <div class="col-md-9">
            <div class="panel panel-default">
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-heading">
                                <h3>z这个是骚哥 <span class="label label-success">转</span></h3>
                            </div>
                            <div class="media-body">
                                <div class="media">
                                    <div class="media-body">
                                        <p style="color: #737373">
                                            骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                            骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                        </p>
                                        <%--<span class="label label-primary"><span class="glyphicon glyphicon-eye-open"></span> 55</span>--%>
                                        <div class="row">
                                            <div class="col-xs-6">
                                                    <span class="badge"><span
                                                            class="glyphicon glyphicon-thumbs-up"></span> 42
                                                    </span>
                                                <span class="badge"><span
                                                        class="glyphicon glyphicon-eye-open"> </span> 42
                                                    </span>
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="btn-group pull-right">
                                                    <a class="btn btn-info " href="article_details.jsp">查看
                                                        <span
                                                                class="glyphicon glyphicon-hand-right"></span></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <label style="color: #9F9F9F"><span class="glyphicon glyphicon-time"></span>2018-05-06
                                    15：00
                                    作者：李浩源 类别：随笔</label>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-heading">
                                <h3>z这个是骚哥 <span class="label label-success">转</span></h3>
                            </div>
                            <div class="media-body">
                                <div class="media">
                                    <div class="media-body">
                                        <p style="color: #737373">
                                            骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                            骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                        </p>
                                        <%--<span class="label label-primary"><span class="glyphicon glyphicon-eye-open"></span> 55</span>--%>
                                        <div class="row">
                                            <div class="col-xs-6">
                                                    <span class="badge"><span
                                                            class="glyphicon glyphicon-thumbs-up"></span> 42
                                                    </span>
                                                <span class="badge"><span
                                                        class="glyphicon glyphicon-eye-open"> </span> 42
                                                    </span>
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="btn-group pull-right">
                                                    <a class="btn btn-info " href="article_details.jsp">查看
                                                        <span
                                                                class="glyphicon glyphicon-hand-right"></span></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <label style="color: #9F9F9F"><span class="glyphicon glyphicon-time"></span>2018-05-06
                                    15：00
                                    作者：李浩源 类别：随笔</label>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="#">首页</a></li>
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="#">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
