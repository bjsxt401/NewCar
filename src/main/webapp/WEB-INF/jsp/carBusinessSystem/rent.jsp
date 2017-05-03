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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" >

    </script>

</head>
<body>
<form action="">

</form>
<form action="/newcar/customer/register.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="20%">
                出租单编号
            </td>
            <td width="30%">
                <input type="text" name="tableId" id="tableId" readonly="readonly" value="${tableId}">
            </td>
            <td width="20%">
                预付金
            </td>
            <td width="30%">
                <input type="text" name="imprest" id="imprest" >
            </td>
        </tr>
        <tr>
        <tr>
            <td>
                应付金
            </td>
            <td>
                <input type="text" name="shouldPayPrice" id="shouldPaypPrice" readonly="readonly">
                <spann>押金${LeaseCarInf.deposit}元</spann>
            </td>
            <td>
                实际交付金额
            </td>
            <td>
                <input type="text" name="price" id="price" >
            </td>
        </tr>
        <tr>
            <td>
                起租日期
            </td>
            <td>
                <input type="text" name="beginDate" id="beginDate"
                       class="Wdate" onclick="WdatePicker();" value="${beginDate}" >
            </td>
            <td>
                应归还日期
            </td>
            <td>
                <input type="text" name="shouldReturnDate" id="shouldReturnDate"
                       class="Wdate" onclick="WdatePicker();" onblur="initPrice();">
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
                <input type="text" name="carNumber" id="carNumber" value="${LeaseCarInf.carNumber}" >
            </td>

        </tr><tr>
            <td>
                客户编号
            </td>
            <td>
                <input type="text" name="custid" id="custid" readonly="readonly" value="${LeaseCustomerIdentity}" >
            </td>
            <td>
                服务人员编号
            </td>
            <td>
                <input type="text" name="username" id="username" readonly="readonly" value="" >
            </td>

        </tr>
        <tr>
            <td><input type="button" value="确定" onclick="checkSubmit();"></td>
            <td><input type="reset" value="重置"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
