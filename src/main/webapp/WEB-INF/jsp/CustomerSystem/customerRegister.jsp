<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/28
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息验证</title>
    <script type="text/javascript" src="">


    </script>
</head>
<body>
<form action="/newcar/customer/register.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="10%">
                身份证&nbsp;
            </td>
            <td width="15%">
                <input type="text" name="identity" id="identity">
            </td>
            <td width="25%"><span id="identitySpan">&nbsp;</span></td>
            <td width="10%">
                姓名&nbsp;
            </td>
            <td width="15%">
                <input type="text" name="custName" id="custName">
            </td>
            <td><span id="custNameSpan">&nbsp;</span></td>
        </tr>
        <tr>
        <tr>
            <td>
                住址&nbsp;
            </td>
            <td>
                <input type="text" name="address" id="address">
            </td>
            <td><span id="addressSpan">&nbsp;</span></td>
            <td>
                电话&nbsp;
            </td>
            <td>
                <input type="text" name="phone" id="phone">
            </td>
            <td><span id="phoneSpan">&nbsp;</span></td>
        </tr>
        <tr>
            <td>
                职业&nbsp;
            </td>
            <td>
                <input type="text" name="career" id="career">
            </td>
            <td><span id="careerSpan">&nbsp;</span></td>
            <td>
                性别
            </td>
            <td>
                <input type="text" name="gender" id="gender">
            </td>
            <td><span id="genderSpan">&nbsp;</span></td>
        </tr>
        <tr>
            <td>
                密码&nbsp;
            </td>
            <td>
                <input type="password" name="password" id="password">
            </td>
            <td><span id="passwordSpan">&nbsp;</span></td>
            <td colspan="2">&nbsp;</td>

        </tr>
        <tr>
            <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
