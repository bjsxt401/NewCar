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
    <title>查询出租单信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="returnCar/selectCheckTableByPage.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="20%">
                检查单号
            </td>
            <td width="30%">
                <input type="text" name="checkId" id="checkId"  >
            </td>
            <td>
                检查日期
            </td>
            <td>
                <input type="text" name="checkDate" id="checkDate"
                       class="Wdate" onclick="WdatePicker();"  >
            </td>
        </tr>           
        
        <tr>
            <td>
                出租单编号
            </td>
            <td>
                <input type="text" name="rentId" id="rentId"  >
            </td>
            <td>
                检查人员姓名
            </td>
            <td>
                <input type="text" name="userName" id="userName"  >
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="currentPage" value="1">
                <input type="hidden" name="pageSize" value="5">
                <input type="submit" value="查询" >
            </td>
        </tr>
    </table>
</form>
</body>
</html>
