<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 15:46
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
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img src="images/me.jpg" class="media-object" alt="" height="64"
                                         width="64">
                                </a>
                            </div>
                            <div class="media-body">
                                <div class="media">
                                    <div class="media-body clearfix">
                                        <h4 ><a href="author_homepage.jsp" style="color: red">李浩源</a></h4>
                                        <div class="pull-left">
                                            <span>关注：0 | 粉丝：20 | 活跃时间：2019-05-05 15：15</span>
                                            <p>风一样的男人</p>
                                        </div>
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-danger">取消关注</a>
                                    </div>

                                    </div>
                                </div>
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
