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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/customers.js">
    </script>
    <style type="text/css">
        .red{
            color: red;
        }
        .green{
            color: green;
        }
    </style>
    <script type="text/javascript" >
            function checkOldPwd() {
                var oldPwd = $("#oldPassword").val();
                var span =  $("#oldPasswordSpan");
                var result = oldPwd != "${modifyCustomer.password}";
               if( result){
                   span.attr("class","red");
                   span[0].innerHTML="原密码错误";
               }else{
                   span.attr("class","green");
                   span[0].innerHTML="匹配成功";
               }
                  return result;
            }

            function checkPasswordAndRelPassword(){
                var result1 =checkOldPwd();
                var result = checkPassword();

                var relPwd = $("#relPassword").val();
                var pwd = $("#password").val();

                var relSpan =  $("#relPasswordSpan");
               if(result && !result1 ){
                   if(relPwd == pwd){
                       relSpan.attr("class","green");
                       relSpan[0].innerHTML="正确";
                       $("#myForm").submit();
                   }   else{
                       relSpan.attr("class","red");
                       relSpan[0].innerHTML="确认密码必须和新密码一致";
                   }
               }
            }
    </script>
</head>
<body>

        <table>
            <form action="/newcar/customer/modifyCustomerPwd.action" method="post" id="myForm">
                <input type="hidden" name="id" value="${modifyCustomer.id}">
            <tr>
                <th>旧密码</th>
                <td><input type="text" id="oldPassword" onblur="checkOldPwd()"></td>
                <td><span id="oldPasswordSpan"></span></td>
            </tr>
            <tr>
                <th>新密码</th>
                <td><input type="text" id="password" name="password" ></td>
                <td><span id="passwordSpan"></span></td>
            </tr>
            <tr>
                <th>确认密码</th>
                <td><input type="text" id="relPassword" ></td>
                <td><span id="relPasswordSpan"></span></td>
            </tr>
            <tr>
                <th><input type="button" value="修改" onclick="checkPasswordAndRelPassword();"></th>
                <td><input type="reset" value="重置"></td>
            </tr>
            </form>
        </table>
</body>
</html>
