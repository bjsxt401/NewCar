<%--
  Created by IntelliJ IDEA.
  User: beichunming
  Date: 2017/4/20
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(function(){
            //导航切换
            $(".menuson li").click(function(){
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if($ul.is(':visible')){
                    $(this).next('ul').slideUp();
                }else{
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="images/leftico01.png" /></span>用户管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="user/addUser.action" target="rightFrame">添加用户</a><i></i></li>
            <li class="active"><cite></cite><a href="right.html" target="rightFrame">查询用户</a><i></i></li>
        </ul>
    </dd>


    <dd>
        <div class="title">
            <span><img src="images/leftico02.png" /></span>客户管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="#">添加客户信息</a><i></i></li>
            <li><cite></cite><a href="#">查询客户信息</a><i></i></li>
        </ul>
    </dd>


    <dd><div class="title"><span><img src="images/leftico03.png" /></span>编辑器</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>
            <li><cite></cite><a href="#">常用资料</a><i></i></li>
            <li><cite></cite><a href="#">信息列表</a><i></i></li>
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>
    </dd>


    <dd><div class="title"><span><img src="images/leftico04.png" /></span>日期管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>
            <li><cite></cite><a href="#">常用资料</a><i></i></li>
            <li><cite></cite><a href="#">信息列表</a><i></i></li>
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>

    </dd>

</dl>

</body>
</html>