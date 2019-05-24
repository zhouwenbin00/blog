<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-03-10
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="header.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="page-header">
        <h1>用户注册</h1>
    </div>
    <div class="row col-md-4">
        <form action="user/register" method="post">
            <div class="form-group">
                <div class="form-group">
                    <label for="nickname">昵称：</label>
                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="昵称">
                </div>
                <div class="form-group">
                    <label for="username">账号：</label>
                    <input type="text" class="form-control"  id="username" name="username" placeholder="账号">
                </div>
                <div class="form-group">
                        <label for="password" >密码：</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="长度为6到18个字符，不能包括空格">
                </div>
                <div class="form-group">
                    <label for="password2">确认密码：</label>
                    <input type="text" class="form-control" id="password2" name="password2" placeholder="长度为6到18个字符，不能包括空格">
                </div>
                <button class="btn btn-success btn-block" type="submit">注册</button>
                <a href="<%=basePath%>login.jsp" class="btn btn-link">已有账号？立即登陆>>></a>
            </div>
        </form>
    </div>
</div>
<%--底部--%>
<div class="container" >
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
<script>
    $(function () {
        $('form').bootstrapValidator({
            disableSubmitButtons: false,
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nickname: {
                    message: '昵称验证失败',
                    validators: {
                        notEmpty: {
                            message: '昵称不能为空'
                        },
                        regexp: {
                            regexp: /^[^ ]+$/,
                            message: '昵称不能有空格'
                        }
                    }
                },
                username:{
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        regexp: {
                            regexp: /^[^ ]+$/,
                            message: '用户名不能有空格'
                        },
                        // threshold: 1,//只有1个字符以上才发送ajax请求
                        remote: {
                            url: "${basePath}user/checkUnique",
                            data: function (validator) {
                                return {
                                    username: $("#username").val(),
                                };
                            },
                            message: '该用户名已被使用，请使用其他用户名',
                            delay:2000
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度应大于6小于18'
                        },
                        regexp: {
                            regexp: /^[^ ]+$/,
                            message: '密码不能有空格'
                        }
                    }
                },
                password2: {
                    validators: {
                        notEmpty: {
                            message: '确认密码不能为空'
                        },
                        identical: {
                            field: 'password',
                            message: '密码不一致！'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度应大于6小于18'
                        },
                        regexp: {
                            regexp: /^[^ ]+$/,
                            message: '密码不能有空格'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>