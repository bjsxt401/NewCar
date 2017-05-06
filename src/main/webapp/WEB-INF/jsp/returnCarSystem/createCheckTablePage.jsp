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
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" >
         function initPrice(){
             var paying = $("#paying").val()
             if(paying==""){
                 paying="0";
             }
             var payingVal = parseFloat(paying);
             var beginDate = new Date($("#beginDate").val());
             var returnDate = new Date($("#checkDate").val());
             var rentPrice = parseFloat($("#rentPrice").val());
             var date = parseInt((returnDate- beginDate)/(24*60*60*1000));
             if(date==0){
                 date=1;
             }
             $("#price").val(rentPrice*date+payingVal);
         }
         function check() {
             initPrice();
             $("#createCheckTable").submit();
         }
    </script>

</head>
<body>
<form action="/newcar/returnCar/createCheckTable.action" method="post" id="createCheckTable">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="20%">
                检查单号
            </td>
            <td width="30%">
                <input type="text" name="checkId" id="checkId" readonly="readonly" value="${checkId}">
            </td>
            <td>
                检查日期
            </td>
            <td>
                <input type="text" name="checkDate" id="checkDate" readonly="readonly" value="${checkDate}">

            </td>
        </tr>
        <tr>
            <td>
                检查员
            </td>
            <td>
                <input type="text" name="userName" id="userName"
                       readonly="readonly" value="${loginUser.userName}" >
            </td>
            <td>
                属性
            </td>
            <td>
                <input type="text" name="field" id="field">
            </td>
        </tr>
        <tr>
            <td>
                问题
            </td>
            <td>
                <input type="text" name="problem" id="problem"  >
            </td>
            <td>
                赔款
            </td>
            <td>
                <input type="text" name="paying" id="paying" onblur="initPrice()"  >
            </td>

        </tr>

        <tr>
            <td>
                <input type="hidden" name="rentId" value="${checkRentInf.tableId}">
                <input type="hidden" name="carId" value="${checkRentInf.car.carId}">
                <input type="hidden" name="tableId" value="${checkRentInf.tableId}">
                <input type="hidden" name="rentFlag" value="已入库">
                <input type="hidden" name="returnDate" value="${checkDate}">
                <input type="hidden" name="price" id="price" >
            </td>
            <td>
                <c:if test="${checkRentInf.rentFlag=='出租中'}">
                    <input type="button" value="还车" onclick="check()">
                </c:if>
            </td>
        </tr>
    </table>


    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>出租单信息</caption>

            <tr>
                <td>出租单编号：</td>
                <td>${checkRentInf.tableId}</td>
                <td>应付金：</td>
                <td>￥${checkRentInf.shouldPayPrice}</td>
                <td>实际交付金额：</td>
                <td>￥${checkRentInf.price==null?0.00:checkRentInf.price}</td>
            </tr>
            <tr>
                <td>起租日期：</td>
                <td>
                    <input type="hidden" id="beginDate" value=" ${checkRentInf.beginDate}">
                    ${checkRentInf.beginDate}</td>
                <td>应归还日期：</td>
                <td>${checkRentInf.shouldReturnDate}</td>
                <td>归还日期：</td>
                <td>${checkRentInf.returnDate}</td>

            </tr>
            <tr>
                <td>出租单状态：</td>
                <td>${checkRentInf.rentFlag}</td>
                <td>服务人员编号：</td>
                <td>${checkRentInf.user.userName}</td>
            </tr>
        </center>
    </table >

    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>客户信息</caption>

            <tr>
                <td>身份证：</td>
                <td>${checkRentInf.customers.identity}</td>
                <td>姓名：</td>
                <td>${checkRentInf.customers.custName}</td>
                <td>性别：</td>
                <td>${checkRentInf.customers.gender}</td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>${checkRentInf.customers.address}</td>
                <td>电话：</td>
                <td>${checkRentInf.customers.phone}</td>
                <td>职业：</td>
                <td>${checkRentInf.customers.career}</td>
            </tr>
        </center>
    </table >
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>汽车信息</caption>

            <tr>
                <td>车号：</td>
                <td>${checkRentInf.car.carNumber}</td>
                <td>型号：</td>
                <td>${checkRentInf.car.carType}</td>
                <td>颜色：</td>
                <td>${checkRentInf.car.color}</td>
            </tr>
            <tr>
                <td>价值：</td>
                <td>${checkRentInf.car.price}</td>
                <td>租金：</td>
                <td>
                    <input type="hidden" id="rentPrice" value="${checkRentInf.car.rentPrice}">
                    ${checkRentInf.car.rentPrice}</td>
                <td>押金：</td>
                <td>${checkRentInf.car.deposit}</td>
            </tr>
            <tr>
                <td>租用情况：</td>
                <td>${checkRentInf.car.isrenting}</td>
                <td>简介</td>
                <td colspan="3">${checkRentInf.car.description}</td>

            </tr>
        </center>
    </table>
</form>
</body>
</html>
