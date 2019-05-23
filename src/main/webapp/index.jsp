<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <%--路径导航--%>
    <ol class="breadcrumb">
        <li class="active"><span class="glyphicon glyphicon-map-marker"></span>当前位置：</li>
        <li class="active">首页</li>
    </ol>
    <div class="row">
        <%--左侧帮助--%>
        <jsp:include page="left_help.jsp" />
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
                                <c:forEach var="article" items="${sessionScope.hotList}">
                                    <li class="list-group-item">
                                        <div class="media">
                                            <div class="media-heading">
                                                <h3><a href="/article/details?id=${article.id}">${article.title}</a> <span
                                                        class="label label-danger"><c:choose>
                                                    <c:when test="${article.original==1}">
                                                        原
                                                    </c:when>
                                                    <c:otherwise>
                                                        转
                                                    </c:otherwise>
                                                </c:choose></span></h3>
                                            </div>
                                            <div class="media-body">
                                                <div class="media">
                                                    <div class="media-left">
                                                        <a href="#">
                                                            <img src="images/me.jpg" class="media-object" alt=""
                                                                 height="32"
                                                                 width="32">
                                                        </a>
                                                    </div>
                                                    <div class="media-body">
                                                        <p style="color: #737373">
                                                            骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮 骚哥牛皮
                                                            <span class="badge"><span
                                                                    class="glyphicon glyphicon-thumbs-up"></span> ${article.like}
                                                    </span>
                                                            <span class="badge"><span
                                                                    class="glyphicon glyphicon-eye-open"> </span> ${article.look}
                                                    </span>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
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
                                <c:forEach var="article2" items="${sessionScope.newList}">
                                    <li class="list-group-item">
                                        <a href="/article/details?id=${article2.id}">${article2.title}</a>
                                        <span style="color: #9F9F9F">${article2.createDate}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $.post("/article/index");
    })

</script>
</body>
</html>
