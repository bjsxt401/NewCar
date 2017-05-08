<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/29
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>查询用户</title>
</head>
<body>

    <form action="customer/setCondition.action" method="post">
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
                    <select name="gender" id="gender" style="width: 100%">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
                <td><span id="genderSpan">&nbsp;</span></td>
            </tr>
             <tr>
                 <td>
                     <input type="hidden" name="currentPage" value="1">
                     <input type="hidden" name="pageSize" value="4">
                     <input type="submit" value="查询">

                 </td>
                 <td>
                     <input type="reset" value="重置">
                 </td>
             </tr>
        </table>
    </form>
</body>
</html>
