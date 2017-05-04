<%--
  Created by IntelliJ IDEA.
  User: beichunming
  Date: 2017/4/20
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="images/skin.css" rel="stylesheet" type="text/css" />
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-color: #EEF2FB;
        }
    </style>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        function subForm(){
            document.forms[0].submit();
        }
        function changeUserPwd(){
           window.location.href="user/toChangeUserPwsd.action?uid="+${requestScope.updateUser.uid};
        }

    </script>
</head>

<body>
<form action="user/doUpdateUser.action" method="post">
    <input type="hidden" name="method" value="updateUser" id="method"/>
    <input type="hidden" name="userPwd" value="${requestScope.updateUser.userPwd}"/>
    <input type="hidden" name="uid" value="${requestScope.updateUser.uid}"/>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
            <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31"><div class="titlebt">更新用户</div></td>
                </tr>
            </table></td>
            <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
        </tr>
        <tr>
            <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="2" valign="top">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td valign="top">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" valign="top"><span class="left_bt">
     	<table width="100%" border="0" cellpadding="0" cellspacing="0">
     		 <tr>
      <td width="14%"><div align="center" class="left_txt">登录名</div></td>
      <td width="23%"><input type="text" name="userName" id="userName" value="${requestScope.updateUser.userName }" readonly="readonly"></td>
      <td width="15%"><div align="center" class="left_txt">身份证</div></td>
      <td width="48%"><input type="text" name="identity" id="identity"  value="${requestScope.updateUser.identity }">*</td>
    </tr>
    <tr>
       <td><div align="center" class="left_txt">联系电话</div></td>
      <td><input type="text" name="phone" id="phone" value="${requestScope.updateUser.phone }">*</td>
         <td><div align="center" class="left_txt">姓名</div></td>
      <td><input type="text" id="fullName" name="fullName" value="${requestScope.updateUser.fullName }">*</td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">地址</div></td>
      <td><input type="text" name="address" id="address" value="${requestScope.updateUser.address }">*</td>
     <td><div align="center" class="left_txt">性别</div></td>
      <td>
     <select NAME="gender" id="sex" style="width: 105px;">
			<c:choose>
                <c:when test="${requestScope.updateUser.gender eq '男'}">
                    <option value="男" selected="selected">男</option>
                    <option value="女">女</option>
                </c:when>
                <c:otherwise>
                    <option value="男" >男</option>
                    <option value="女" selected="selected">女</option>
                </c:otherwise>
            </c:choose>
		</select>

      </td>

    </tr>
    <tr>
      <td><div align="center" class="left_txt">职位 </div></td>
      <td><input type="text" name="position" id="position" value="${requestScope.updateUser.position }">*</td>
      <td><div align="center" class="left_txt">用户类型</div></td>
      <td><label>
         <select name="roleid">
        <c:forEach items="${sessionScope.roleList}" var="r">
            <c:choose>
                <c:when test="${requestScope.updateUser.roleid == r.roleid}">
                    <option  value="${r.roleid }" selected>${r.roleName }</option>
                </c:when>
                <c:otherwise>
                    <option  value="${r.roleid }">${r.roleName }</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </select>
      </label></td>
    </tr>
    <tr>


    </tr>
     	</table>
    <table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center">
		<img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img  src="<%=basePath%>images/carimg/reset.gif" onclick="reset()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <img  src="<%=basePath%>images/carimg/changepw.gif" onclick="changeUserPwd()" style="cursor: hand;">
		</div>
	  </td>
	</tr>
	<tr>
		<td height="30" background="<%=basePath%>images/tab/bg.gif"></td>
	</tr>
</table>
</span>
                    </td>
                </tr>

                <tr>

                    <td valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
                    </table></td>
                </tr>
            </table></td>
            <td background="images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
            <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
            <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
        </tr>
    </table>
</form>
</body>
</html>