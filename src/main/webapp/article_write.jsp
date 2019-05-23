<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/wangEditor.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<body>
<form id="form">
    <div class="form-group">
        <label for="title">文章标题：</label>
        <input type="text" name="title" id="title"/>
    </div>
    <div id="div1" class="toolbar" style=" border: 1px solid #ccc;">
    </div>
    <div id="div2" class="text" style="height: 600px;  border: 1px solid #ccc;"> <!--可使用 min-height 实现编辑区域自动增加高度-->
        <p>请输入内容</p>
    </div>
    <textarea name="content" id="text1" style="width:100%; height:200px;" hidden></textarea>
    文章类型：
    <select name="original">
        <option name="original" value="1">原创</option>
        <option name="original" value="0">转载</option>
    </select>
    博客分类：
    <select name="type">
        <option name="type" value="1">科技</option>
        <option name="type" value="2">生活</option>
    </select>
    <br/>
    <button type="button" onclick="release()">发布</button>
    <button>存为草稿</button>
    <a href="/index.jsp">返回</a>

</form>


<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1','#div2');
    var $text1 = $('#text1');
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    };
    editor.customConfig.uploadImgShowBase64 = true;
    editor.create()
    $text1.val(editor.txt.html())

    function release() {

        var title = $("input[name='title']").val();
        var content = $("textarea[name='content']").val();
        var original = $("select[name='original']").val();
        var type = $("select[name='type']").val();
        $.post("/article/add", {title: title, content: content, original: original, type: type}, function (flag) {
            if (flag) {
                alert("成功")
            }
        });

    }


</script>
</body>
</html>
