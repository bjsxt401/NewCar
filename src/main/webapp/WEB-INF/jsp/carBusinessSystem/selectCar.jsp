<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>选择要租赁的汽车</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
      <table class="table table-hover" >
          <c:forEach items="${carsInf}" varStatus="status" var="each">
              <form action="/newcar/lease/selectedCar.action" method="post">
                  <input type="hidden" name="carId" value="${each.carId}">
             <tr>
                 <td><div id="carImg${each.carId}"></div></td>
                 <td>${status.index}</td>
                 <td>汽车型号${each.carType}</td>
                 <td>汽车颜色${each.color}</td>
                 <td>汽车租金${each.rentPrice}</td>
                 <td>汽车押金${each.deposit}</td>
                 <td><input type="submit" value="租车"></td>
             </tr>
              </form>
          </c:forEach>
      </table>
</body>
</html>
