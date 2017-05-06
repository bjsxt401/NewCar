<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" >
        $(function () {
            $("#rentFlag").val('${motifyRent.rentFlag}');
        })
    </script>

</head>
<body>
<form action="/newcar/lease/updateRent.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: left">
        <tr>
            <td width="20%">
                出租单编号
            </td>
            <td width="30%">
                <span>${motifyRent.tableId}</span>
                <input type="hidden" name="tableId" value="${motifyRent.tableId}">
            </td>
            <td>
                应付金
            </td>
            <td>
                <span>${motifyRent.shouldPayPrice}</span>

            </td>
        </tr>
        <tr>
            <td>
                起租日期
            </td>
            <td>
                <input type="text" name="beginDate" id="beginDate"
                       class="Wdate" onclick="WdatePicker();" value="${motifyRent.beginDate}" >
            </td>
            <td>
                应归还日期
            </td>
            <td>
                <input type="text" name="shouldReturnDate" id="shouldReturnDate"
                       class="Wdate" onclick="WdatePicker();"value="${motifyRent.shouldReturnDate}" >
            </td>
        </tr>
        <tr>
            <td>
                归还日期
            </td>
            <td>
                <input type="text" name="returnDate" id="returnDate"
                       class="Wdate" onclick="WdatePicker();" value="${motifyRent.returnDate}" >
            </td>
            <td>
                出租单状态
            </td>
            <td>
                <select name="rentFlag" id="rentFlag"  >
                    <option value="已入库">已入库</option>

                    <option value="出租中">出租中</option>
                </select>
            </td>

        </tr>
        <tr>
            <td>
                服务人员编号
            </td>
            <td>
                <span>${motifyRent.user.userName}</span>
            </td>

        </tr>
        <tr style="text-align: center">
            <td colspan="4" style="text-align: center">
                <c:if test="${motifyRent.rentFlag=='出租中'}" >
                    <input type="submit" value="确定" >
                </c:if>
            </td>
        </tr>
    </table>
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>客户信息</caption>

            <tr>
                <td>身份证：</td>
                <td>${motifyRent.customers.identity}</td>
                <td>姓名：</td>
                <td>${motifyRent.customers.custName}</td>
                <td>性别：</td>
                <td>${motifyRent.customers.gender}</td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>${motifyRent.customers.address}</td>
                <td>电话：</td>
                <td>${motifyRent.customers.phone}</td>
                <td>职业：</td>
                <td>${motifyRent.customers.career}</td>
            </tr>
        </center>
    </table >
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>汽车信息</caption>

            <tr>
                <td>车号：</td>
                <td>${motifyRent.car.carNumber}</td>
                <td>型号：</td>
                <td>${motifyRent.car.carType}</td>
                <td>颜色：</td>
                <td>${motifyRent.car.color}</td>
            </tr>
            <tr>
                <td>价值：</td>
                <td>${motifyRent.car.price}</td>
                <td>租金：</td>
                <td>${motifyRent.car.rentPrice}</td>
                <td>押金：</td>
                <td>${motifyRent.car.deposit}</td>
            </tr>
            <tr>
                <td>租用情况：</td>
                <td>${motifyRent.car.isrenting}</td>
                <td>简介</td>
                <td colspan="3">${motifyRent.car.description}</td>

            </tr>
        </center>
    </table>
</form>
</body>
</html>