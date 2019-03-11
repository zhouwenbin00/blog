<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 20:46
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
    <%--路径导航--%>
    <ol class="breadcrumb">
        <li class="active"><span class="glyphicon glyphicon-map-marker"></span>当前位置：</li>
        <li class="active">首页</li>
    </ol>
    <div class="row">
        <%--左侧帮助--%>
        <jsp:include page="left_help.jsp"></jsp:include>
        <%--右侧--%>
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="alert alert-warning alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <strong>注意!</strong> 严禁未经允许抄袭他人作品，一经发现，封号并向网警举报！
                    </div>
                    <%--热门博文--%>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <%--标题--%>
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-9">
                                        <h1 class="panel-title">热门博文</h1>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="<%=basePath%>article_list.jsp">更多>>></a>
                                    </div>
                                </div>
                            </div>
                            <%--博文列表--%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="media">
                                        <div class="media-heading">
                                            <h3>z这个是骚哥 <span class="label label-danger">原</span></h3>
                                        </div>
                                        <div class="media-body">
                                            <div class="media">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                             width="32">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <p style="color: #737373">
                                                        骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-thumbs-up"></span> 42
                                                    </span>
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-eye-open"> </span> 42
                                                    </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="media">
                                        <div class="media-heading">
                                            <h3>z这个是骚哥 <span class="label label-danger">原</span></h3>
                                        </div>
                                        <div class="media-body">
                                            <div class="media">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                             width="32">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <p style="color: #737373">
                                                        骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-thumbs-up"></span> 42
                                                    </span>
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-eye-open"> </span> 42
                                                    </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="media">
                                        <div class="media-heading">
                                            <h3>z这个是骚哥 <span class="label label-danger">原</span></h3>
                                        </div>
                                        <div class="media-body">
                                            <div class="media">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                             width="32">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <p style="color: #737373">
                                                        骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-thumbs-up"></span> 42
                                                    </span>
                                                        <span class="badge"><span
                                                                class="glyphicon glyphicon-eye-open"> </span> 42
                                                    </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <%--最新博文--%>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <%--标题--%>
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-9">
                                        <h1 class="panel-title">最新博文</h1>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="<%=basePath%>article_list.jsp">更多>>></a>
                                    </div>
                                </div>
                            </div>
                            <%--博文列表--%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a href="#">JDK将收费？程序员将何去何从？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">IT大厂裁员，程序员行业饱和？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">JDK将收费？程序员将何去何从？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">IT大厂裁员，程序员行业饱和？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">JDK将收费？程序员将何去何从？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">IT大厂裁员，程序员行业饱和？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">JDK将收费？程序员将何去何从？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">IT大厂裁员，程序员行业饱和？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">JDK将收费？程序员将何去何从？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                                <li class="list-group-item">
                                    <a href="#">IT大厂裁员，程序员行业饱和？</a>
                                    <span style="color: #9F9F9F">2018-02-02 12:12</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
