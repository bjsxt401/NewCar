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

        function updatePrice(){
            //重新计算实际交付金额
            //现在的赔款
            var paying = $("#paying").val()
            if(paying==""){
                paying="0";
            }
            var payingVal = parseFloat(paying);
            //原本的实际金额
            var oldprice = $("#price").val();

            if(oldprice==""){
                oldprice = "0";
            }
            var oldpriceVal = parseFloat(oldprice);
             //原本的赔款
            var oldpaying = $("#oldpaying").val();
            if(oldpaying==""){
                oldpaying = "0";
            }
             var oldpayingVal = parseFloat(oldpaying);

            $("#price").val(oldpriceVal-oldpayingVal+payingVal);

        }
        function submitUpdate(){
            updatePrice();
            $("#myform").submit()
        }
    </script>

</head>
<body>
<form action="returnCar/updateCheckTable.action" method="post" id="myform">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: left">
        <tr>
            <td width="20%">
                检查单号
            </td>
            <td width="30%">
                <span>${motifyCheckTable.checkId}</span>
                <input type="hidden" name="checkId" value="${motifyCheckTable.checkId}">
                <input type="hidden" name="tableId" value="${motifyCheckTable.rent.tableId}">
            </td>
            <td>
                检查日期
            </td>
            <td>
                <input type="text" class="Wdate" onclick="WdatePicker();"
                     name="checkDate"  value="${motifyCheckTable.checkDate}">
            </td>
        </tr>
        <tr>
            <td>
                属性
            </td>
            <td>
                <input type="text" name="field" id="field"value="${motifyCheckTable.field}" >
            </td>
            <td>
                问题
            </td>
            <td>
                <input type="text" name="problem"
                       id="problem"value="${motifyCheckTable.problem}" >
            </td>
        </tr>
        <tr>
            <td>
                赔款
            </td>
            <td>
                <input type="text" name="paying" id="paying" value="${motifyCheckTable.paying}"
                       onblur="updatePrice();" >
                <input type="hidden"  id="oldpaying" value="${motifyCheckTable.paying}" >
            </td>
            <td>
                检查人姓名
            </td>
            <td>
                <span>${motifyCheckTable.user.userName}</span>
            </td>

        </tr>

        <tr style="text-align: center">
            <td colspan="4" style="text-align: center">
                    <input type="button" value="确定" onclick="submitUpdate();" >
            </td>
        </tr>
    </table>
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>出租单信息</caption>

            <tr>
                <td>出租单编号：</td>
                <input type="hidden" id="price" name="price" value="${motifyCheckTable.rent.price}">
                <td>${motifyCheckTable.rent.tableId}</td>
                <td>应付金：</td>
                <td>${motifyCheckTable.rent.shouldPayPrice}</td>
                <td>起租日期：</td>
                <td>${motifyCheckTable.rent.beginDate}
                    <input type="hidden" id="beginDate" value="${motifyCheckTable.rent.beginDate}">
                </td>
            </tr>
            <tr>
                <td>应归还日期：</td>
                <td>${motifyCheckTable.rent.shouldReturnDate}</td>
                <td>归还日期：</td>
                <td>${motifyCheckTable.rent.returnDate}</td>
                <td>客户姓名：</td>
                <td>${motifyCheckTable.rent.customers.custName}</td>
            </tr>
            <tr>
                <td>车号：</td>
                <td>${motifyCheckTable.rent.car.carNumber}</td>
                <td>服务人员编号：</td>
                <td>${motifyCheckTable.rent.user.userName}</td>
            </tr>
        </center>
    </table >
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>客户信息</caption>

            <tr>
                <td>身份证：</td>
                <td>${motifyCheckTable.rent.customers.identity}</td>
                <td>姓名：</td>
                <td>${motifyCheckTable.rent.customers.custName}</td>
                <td>性别：</td>
                <td>${motifyCheckTable.rent.customers.gender}</td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>${motifyCheckTable.rent.customers.address}</td>
                <td>电话：</td>
                <td>${motifyCheckTable.rent.customers.phone}</td>
                <td>职业：</td>
                <td>${motifyCheckTable.rent.customers.career}</td>
            </tr>
        </center>
    </table >
    <table style="margin-top: 20px" class="table table-hover">
        <center>
            <caption>汽车信息</caption>

            <tr>
                <td>车号：</td>
                <td>${motifyCheckTable.rent.car.carNumber}</td>
                <td>型号：</td>
                <td>${motifyCheckTable.rent.car.carType}</td>
                <td>颜色：</td>
                <td>${motifyCheckTable.rent.car.color}</td>
            </tr>
            <tr>
                <td>价值：</td>
                <td>${motifyCheckTable.rent.car.price}</td>
                <td>租金：</td>
                <td>${motifyCheckTable.rent.car.rentPrice}</td>
                <td>押金：</td>
                <td>${motifyCheckTable.rent.car.deposit}</td>
            </tr>
            <tr>
                <td>租用情况：</td>
                <td>${motifyCheckTable.rent.car.isrenting}</td>
                <td>简介</td>
                <td colspan="3">${motifyCheckTable.rent.car.description}</td>

            </tr>
        </center>
    </table>
</form>
</body>
</html>
