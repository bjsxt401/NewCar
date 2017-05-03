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
    <title>汽车租赁</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
         function checkidentity() {
             var identity = $("#identity").val();
             var span = $("#identitySpan")
              $.ajax({
                  "method":"post",
                  "url":"/newcar/customer/selectIdentity.action",
                  "data":{
                      "identity":identity
                  },
                  "success":function (data) {
                      if(data.result){
                          //验证通过后 发请求查询车辆信息跳转至租车页面，并把该用户identity存到作用域
                          span[0].innerHTML='<a href="/newcar/lease/selectCar.action?identity='+identity+'">继续</a>';
                      }else{
                          span.attr("class","green");
                          span[0].innerHTML="查无此人";

                      }
                  }
              });
         }
    </script>
</head>
<body>
<form action="">
    身份证号码:<input type="text" name="identity" id="identity" onblur="checkidentity()">
      <span id="identitySpan" style="margin-left: 30px"></span>
</form>


</body>
</html>
