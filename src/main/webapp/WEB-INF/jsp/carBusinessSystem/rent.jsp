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
         function initPrice(){

             var shouldReturnDate = new Date($("#shouldReturnDate").val());
             var beginDate = new Date($("#beginDate").val());
             var date = (shouldReturnDate- beginDate)/(24*60*60*1000);
             if(date==0){
                 date = 1;
             }

            var shouldPayPrice = $("#shouldPayPrice");
            shouldPayPrice.val(parseFloat(${LeaseCarInf.deposit})+parseFloat(${LeaseCarInf.rentPrice})*date);
         }
    </script>

</head>
<body>
<form action="/newcar/lease/createRent.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="20%">
                出租单编号
            </td>
            <td width="30%">
                <input type="text" name="tableId" id="tableId" readonly="readonly" value="${tableId}">
                <input type="hidden" name="carId" value="${LeaseCarInf.carId}">
                <input type="hidden" name="cId" value="${LeaseCustomerId}">
            </td>
            <td>
                应付金
            </td>
            <td>
                <input type="text" name="shouldPayPrice" id="shouldPayPrice" readonly="readonly">

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
                       class="Wdate" onclick="WdatePicker();" onchange="initPrice();" >
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

        </tr>
        <tr>
            <td>
                客户编号
            </td>
            <td>
                <input type="text"  readonly="readonly" value="${LeaseCustomerIdentity}" >
            </td>
            <td>
                服务人员编号
            </td>
            <td>
                <input type="text" name="username" id="username" readonly="readonly" value="${loginUser.userName}" >
                <input type="hidden" name="uId"  value="${loginUser.uid}" >
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
