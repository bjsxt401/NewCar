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
</head>
<body>

        <table>
            <form action="/newcar/customer/modifyCustomerPwd.action" method="post">
                <input type="hidden" name="id" value="${modifyCustomer.id}">
            <tr>
                <th>旧密码</th>
                <td><input type="text" id="oldPassword"></td>
                <td><span id="oldPasswordSpan"></span></td>
            </tr>
            <tr>
                <th>新密码</th>
                <td><input type="text" id="password" name="password" ></td>
                <td><span id="passwordSpan"></span></td>
            </tr>
            <tr>
                <th>确认密码</th>
                <td><input type="text" id="relPassword" ></td>
                <td><span id="relPasswordSpan"></span></td>
            </tr>
            <tr>
                <th><input type="submit" value="修改"></th>
                <td><input type="reset" value="重置"></td>
            </tr>
            </form>
        </table>
</body>
</html>
