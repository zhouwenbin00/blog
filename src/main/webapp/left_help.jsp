<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-11
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--首页左侧--%>
<div class="col-md-3">
    <div class="panel panel-default ">
        <div class="panel-body">
            <div class="panel panel-danger">
                <div class="panel-heading"><span class="glyphicon glyphicon-bookmark"></span> 系统公告</div>
                <ul class="list-group">
                    <li class="list-group-item"><a href="#">发布博文须知</a></li>
                    <li class="list-group-item"><a href="#">系统升级提醒</a></li>
                </ul>
            </div>
            <div class="panel panel-success">
                <div class="panel-heading"><span class="glyphicon glyphicon-tags"></span> 分类标签</div>
                <div class="panel-body">
                    <button class="btn btn-primary btn-xs">测试 <span class="badge">4</span></button>
                    <button class="btn btn-danger btn-xs">骚哥 <span class="badge">2</span></button>
                    <button class="btn btn-success btn-xs">随笔 <span class="badge">4</span></button>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> 友情链接</div>
                <div class="panel-body">
                    <ul>
                        <li><a href="https://v3.bootcss.com/">BootStap中文网</a></li>
                    </ul>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> 日期筛选</div>
                <div class="panel-body">
                    <div class="input-group">
                        <input class="form-control " type="text" id="date" placeholder="时间筛选">
                        <span class="input-group-btn">
                                     <button class="btn btn-default" type="submit"><span
                                             class="glyphicon glyphicon-search"></span></button>
                                     </span>
                    </div>
                    <div class="date datetimepicker" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd"
                         data-link-field="date"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/common.js"></script>
