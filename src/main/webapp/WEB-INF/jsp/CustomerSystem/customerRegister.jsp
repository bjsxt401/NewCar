<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/28
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>信息验证</title>
    <style type="text/css">
        .red{
            color: red;
        }
        .green{
            color: green;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/customers.js">
    </script>
    <script type="text/javascript" >
        function checkIdentityAndGender(){
            var result = checkIdentity();
            var span = $("#identitySpan");
            if(result){

                $.ajax({
                    "method":"post",
                    "url":"/newcar/customer/selectIdentity.action" ,
                    "data":{
                        "identity":$("#identity").val()
                    } ,
                    "success":function (data) {
                        if(data.result){
                            span.attr("class","red");
                            span[0].innerHTML="该证件号已被注册";

                        }else{
                            span.attr("class","green");
                            span[0].innerHTML="该证件号尚未被注册";

                        }
                    }
                });
            }
        }
        function checkSubmit() {
            var result1 = checkPassword();
            var result2 = checkIdentity();
            var result3 = checkCustName();
            var result4 = checkPhone();
            if(((result1&&result2)&&result3)&&result4){
                $("#compileCustomer").submit();
            }
        }
    </script>
</head>
<body>
<form action="/newcar/customer/register.action" method="post">

    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td width="10%">
                身份证&nbsp;
            </td>
            <td width="15%">
                <input type="text" name="identity" id="identity" onblur="checkIdentityAndGender();">
            </td>
            <td width="25%"><span id="identitySpan">&nbsp;</span></td>
            <td width="10%">
                姓名&nbsp;
            </td>
            <td width="15%">
                <input type="text" name="custName" id="custName" onblur="checkCustName();">
            </td>
            <td><span id="custNameSpan">&nbsp;</span></td>
        </tr>
        <tr>
        <tr>
            <td>
                住址&nbsp;
            </td>
            <td>
                <input type="text" name="address" id="address">
            </td>
            <td><span id="addressSpan">&nbsp;</span></td>
            <td>
                电话&nbsp;
            </td>
            <td>
                <input type="text" name="phone" id="phone" onblur="checkPhone();">
            </td>
            <td><span id="phoneSpan">&nbsp;</span></td>
        </tr>
        <tr>
            <td>
                职业&nbsp;
            </td>
            <td>
                <input type="text" name="career" id="career">
            </td>
            <td><span id="careerSpan">&nbsp;</span></td>
            <td>
                性别
            </td>
            <td>
                <select name="gender" id="gender" style="width: 100%">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
            <td><span id="genderSpan">&nbsp;</span></td>
        </tr>
        <tr>
            <td>
                密码&nbsp;
            </td>
            <td>
                <input type="password" name="password" id="password" onblur="checkPassword();">
            </td>
            <td><span id="passwordSpan">密码为6-11位，且必须有英文</span></td>
            <td colspan="2">&nbsp;</td>

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
