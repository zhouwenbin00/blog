<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="header.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <%--路径导航--%>
    <ol class="breadcrumb">
        <li class="active"><span class="glyphicon glyphicon-map-marker"></span>当前位置：</li>
        <li><a href="<%=basePath%>index.jsp">首页</a></li>
        <li class="active">博文列表</li>
    </ol>
    <div class="row">
            <%--左侧帮助--%>
            <jsp:include page="left_help.jsp" />
        <%--首页左侧--%>
        <div class="col-md-9">
            <%--博文列表--%>
            <div class="panel panel-default">
                <%--标题--%>
                <div class="panel-heading">
                    <h1 class="panel-title">博文列表</h1>
                </div>
                <%--博文列表--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-heading">
                                <h3>z这个是骚哥 <span class="label label-success">转</span></h3>
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
                                                <a class="btn btn-primary pull-right" href="article_details.jsp">阅读全文
                                                    <span
                                                            class="glyphicon glyphicon-hand-right"></span></a>
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
                                    <div class="media-left">
                                        <a href="#">
                                            <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                 width="32">
                                        </a>
                                    </div>
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
                                                <a class="btn btn-primary pull-right" href="article_details.jsp">阅读全文
                                                    <span
                                                            class="glyphicon glyphicon-hand-right"></span></a>
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
                                    <div class="media-left">
                                        <a href="#">
                                            <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                 width="32">
                                        </a>
                                    </div>
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
                                                <button class="btn btn-primary pull-right">阅读全文 <span
                                                        class="glyphicon glyphicon-hand-right"></span></button>
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
                                    <div class="media-left">
                                        <a href="#">
                                            <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                 width="32">
                                        </a>
                                    </div>
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
                                                <button class="btn btn-primary pull-right">阅读全文 <span
                                                        class="glyphicon glyphicon-hand-right"></span></button>
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
                                    <div class="media-left">
                                        <a href="#">
                                            <img src="images/me.jpg" class="media-object" alt="" height="32"
                                                 width="32">
                                        </a>
                                    </div>
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
                                                <button class="btn btn-primary pull-right">阅读全文 <span
                                                        class="glyphicon glyphicon-hand-right"></span></button>
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

<script>
    $(function () {
        $.post("/article/list",{rows:10,page:1});
    })

</script>
</body>
</html>
