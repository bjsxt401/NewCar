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
    <script type="text/javascript">
        function subForm(){
            document.forms[0].submit();
        }
    </script>
</head>

<body>
<form action="car/addCar.action" method="post" enctype="multipart/form-data">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
            <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31"><div class="titlebt">添加汽车</div></td>
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
     	<table class="maintable" width="97%" border="0" cellspacing="0">
    <tr>
      <td width="14%"><div align="center" class="left_txt">车号</div></td>
      <td width="23%"><input type="text" name="carNumber" id="carNumber" >*</td>
      <td width="15%"><div align="center" class="left_txt">型号</div></td>
      <td width="48%"><input type="text" name="carType" id="carType"></td>
    </tr>
    <tr>
      <td><div align="center"  class="left_txt">颜色</div></td>
      <td><input type="text" name="color" id="color" >*</td>
       <td><div align="center" class="left_txt">价值</div></td>
      <td><input type="text" name="price" id="price">*</td>

    </tr>
    <tr>
      <td><div align="center" class="left_txt">租金</div></td>
      <td><input type="text" name="rentPrice" id="rentPrice">*</td>
     <td><div align="center" class="left_txt">押金</div></td>
      <td><input type="text" name="deposit" id="deposit">*</td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">租用情况 </div></td>
      <td>
     <select name="isrenting" id="isRenting" style="width: 80px;">
			<option value="0" selected >未出租</option>
			<option value="1" >已出租</option>
	</select>
      </td>
       <td><div align="center" class="left_txt">上传汽车图片</div></td>
      <td>
      <input type="file" name="uploadFile" id="uploadFile"/>*
      </td>
    </tr>
    <tr>
		<td colspan="6">
		<hr color="#99CCFF"></td>
	</tr>
     <tr align="center" bgcolor="#99CCFF">
      <td height="26" colspan="4" class="titleLine"><div align="left" class="left_txt"> 简介：<span class="style2"></span></div></td>
    </tr>
    <tr>
      <td height="121" colspan="4" align="center"><textarea name="description" id="texts" cols="140" rows="5"></textarea></td>
    </tr>
  </table>
    <table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center">
		<img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img  src="<%=basePath%>images/carimg/reset.gif" onclick="reset()" style="cursor: hand;">
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