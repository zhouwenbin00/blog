<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 21:37
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
        <li><a href="index.jsp">首页</a></li>
        <li class="active">留言板</li>
    </ol>

    <%--留言板--%>
    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img src="images/me.jpg" class="media-object" alt="" width="64px" height="64px">
                    </a>
                </div>
                <div class="media-body">
                    <div class="form-group">
                        <textarea class="form-control" rows="3" placeholder="有什么想对我李浩源说的？"></textarea>
                    </div>
                    <button class="btn btn-success">发表</button>
                    <a href="#" class="btn btn-link"><span class="iconfont icon-xiaolian"></span>表情</a>
                    <a href="#" class="btn btn-link"><span class="glyphicon glyphicon-picture"></span>图片</a>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <label> 共5条评论</label>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">置顶评论</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img src="images/test1.jpg" class="media-object" alt="">
                                </a>
                            </div>
                            <div class="media-body">
                                <div class="media-heading"><strong style="color: red">张皓伟</strong></div>
                                李浩源牛皮<br>
                                <span style="color: #999999">2019年3月11日14：55</span> <a href="#"><span
                                    class="glyphicon glyphicon-thumbs-up"></span>3336</a>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img src="images/test1.jpg" class="media-object" alt="">
                                </a>
                            </div>
                            <div class="media-body">
                                <div class="media-heading"><strong style="color: red">陈金龙</strong></div>
                                李浩源牛皮+1<br>
                                <span style="color: #999999">2019年3月11日15：31</span> <a href="#"><span
                                    class="glyphicon glyphicon-thumbs-up"></span>666</a>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img src="images/test1.jpg" class="media-object" alt="">
                                </a>
                            </div>
                            <div class="media-body">
                                <div class="media-heading"><strong style="color: red">邓港</strong></div>
                                李浩源牛皮！！！<br>
                                <span style="color: #999999">2019年3月11日16：11</span> <a href="#"><span
                                    class="glyphicon glyphicon-thumbs-up"></span>6</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img src="images/test1.jpg" class="media-object" alt="">
                            </a>
                        </div>
                        <div class="media-body">
                            <div class="media-heading"><strong style="color: red">路人甲</strong></div>
                            李浩源垃圾<br>
                            <span style="color: #999999">2019年3月11日8：00</span> <a href="#"><span
                                class="glyphicon glyphicon-thumbs-up"></span>6</a>
                        </div>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img src="images/test1.jpg" class="media-object" alt="">
                            </a>
                        </div>
                        <div class="media-body">
                            <div class="media-heading"><strong style="color: red">路人乙</strong></div>
                            李浩源垃圾<br>
                            <span style="color: #999999">2019年3月11日8：00</span> <a href="#"><span
                                class="glyphicon glyphicon-thumbs-up"></span>6</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
