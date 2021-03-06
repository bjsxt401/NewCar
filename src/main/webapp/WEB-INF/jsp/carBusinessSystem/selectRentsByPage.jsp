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
<form action="lease/selectRentByPage.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="20%">
                出租单编号
            </td>
            <td width="30%">
                <input type="text" name="tableId" id="tableId" readonly="readonly" >
            </td>
            <td>
                归还日期
            </td>
            <td>
                <input type="text" name="returnDate" id="returnDate"
                       class="Wdate" onclick="WdatePicker();"  >
            </td>
        </tr>           
        <tr>
            <td>
                起租日期
            </td>
            <td>
                <input type="text" name="beginDate" id="beginDate"
                       class="Wdate" onclick="WdatePicker();" >
            </td>
            <td>
                应归还日期
            </td>
            <td>
                <input type="text" name="shouldReturnDate" id="shouldReturnDate"
                       class="Wdate" onclick="WdatePicker();" >
            </td>
        </tr>
        <tr>
            <td>
                出租单状态
            </td>
            <td>
                <select name="rentFlag" id="rentFlag" >
                    <option value="出租中">出租中</option>
                    <option value="已入库">已入库</option>
                </select>
            </td>
            <td>
                车号
            </td>
            <td>
                <input type="text" name="carNumber" id="carNumber"  >
            </td>

        </tr>
        <tr>
            <td>
                客户编号
            </td>
            <td>
                <input type="text" name="identity"   >
            </td>
            <td>
                服务人员编号
            </td>
            <td>
                <input type="text" name="userName" id="userName">
            </td>

        </tr>
        <tr>
            <td>
                <input type="submit" value="确定" >
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
