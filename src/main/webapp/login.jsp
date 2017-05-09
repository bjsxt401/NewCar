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
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        var rootPath = '${pageContext.request.contextPath}';
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
        function loginAction() {
            var  loginuser =$("#loginuser").val();
            var  loginpwd =$("#loginpwd").val();
            $.ajax({
                'type':'post',
                'url':rootPath+"/user/login.action",
                'data':{
                    "loginuser":loginuser,
                    "loginpwd":loginpwd
                },
                'success':function (data){
                    if (data.userName){
                        window.location.href="user/toMain.action";
                    }else {
                        alert("用户名或密码错误==");
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("用户名或密码错误-------");
                }
            });
        }
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">
        <form action="user/login.action" method="post">
            <ul>
                <li><input name="loginuser" id="loginuser" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
                <li><input name="loginpwd"  id="loginpwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
                <li><input name="button" type="button" class="loginbtn" value="登录" onclick="javascript:loginAction();"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>

    </div>

</div>



<div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>


</body>

</html>