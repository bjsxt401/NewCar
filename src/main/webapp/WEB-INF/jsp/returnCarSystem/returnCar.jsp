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
    <title>汽车归还</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <style>
        .red{
            color: red;
        }
    </style>

    <script type="text/javascript">
         function checkTableId() {
             var tableId = $("#tableId").val();
             var span = $("#tableIdSpan")
              $.ajax({
                  "method":"post",
                  "url":"/newcar/returnCar/selectTableId.action",
                  "data":{
                      "tableId":tableId
                  },
                  "success":function (data) {
                      if(data.hasTableId){
                          //验证通过后 发请求查询车辆信息跳转至租车页面，并把该用户identity存到作用域
                          span[0].innerHTML='<a href=' +
                              '"/newcar/returnCar/createCheckTablePage.action?tableId='+tableId+'">继续</a>';
                      }else{
                          span.attr("class","red");
                          span[0].innerHTML="出租单号错误";

                      }
                  }
              });
         }
    </script>
</head>
<body>
    出租单号:<input type="text" name="tableId" id="tableId" onblur="checkTableId()">
      <span id="tableIdSpan" style="margin-left: 30px"></span>

</body>
</html>
