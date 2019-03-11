<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 20:57
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
        <li><a href="index.jsp">首页</a></li>
        <li class="active">关于本站</li>
    </ol>
    <%--关于--%>
    <div class="col-md-9">
        <div class="panel panel-primary  ">
            <div class="panel-heading">
                <h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span> 自我介绍</h3>
            </div>
            <div class="panel-body">
                <div class="page-header">
                    <h2>以下为测试范文</h2>
                </div>
                <h2>Just about me</h2>
                <p> 李浩源，一个90后草根男！</p>
                <p> “最初的梦想，握紧在手上，最想要去的地方，怎么能在半路就返航，最初的梦想绝对会到达，实现了真的渴望，
                    才能够算过了天堂。”虽然是夜晚但心情依然如晨曦中的太阳，带着疲倦、懒惰、希望、梦想。听着范玮琪的歌，
                    仿佛述说在一段追梦的旅程。我不语，只是默默的感受。</p>
                <p> “如果骄傲没有被实现大海冷冷拍下，有怎么懂的要多少努力才能够走到远方?如果梦想不曾坠落悬崖千钧一发，
                    怎么会晓得执着的人拥有隐形的翅膀?”一个微不足道的理由让一切都失去过。谁不曾迷茫?谁又不曾坠落呢?安逸
                    的日子谁不想有呢?把悲伤收起来。</p>
                <p> “最初的梦想，握紧在手上，最想要去的地方，怎么呢半路就返航，最初的梦想绝对会到达，实现了真的渴望，
                    才能算过了天堂。”还有多少人记得自己最初的梦想?因为路遥远艰辛而选择放弃，因为害怕失去而放弃，我们
                    总是为自己找一些看起来很真实的借口而放弃我们的梦想。最初的梦想其实紧握在我们手上，只是，随着时间
                    的流逝，最初的梦想离我们越来越远，但是，我不会放弃的，既然认定了，那就不要回头，勇往直前。</p>
                <p> 因为我还有梦，依然所以心存希望和感激。</p>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">个人资料</h3>
            </div>
            <div class="panel-body">
                <img src="images/me.jpg" class="img-circle img-responsive" alt="" style="border: 1px black solid">
                <p>网名：new</p>
                <p>姓名：李浩源
                <p>生日：1996.7.8
                <p>籍贯：四川省―遂宁市
                <p>现居：成都市―成都区
                <p>爱好：写代码、看电影、撸管
                <p>职业：程序员、学生
                <p>我爱动漫：海贼王、一人之下、秦时明月</p>
            </div>
        </div>
    </div>
</div>
<%--底部--%>
<div class="container">
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
