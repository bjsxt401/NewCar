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
    <title>编辑客户信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <style type="text/css">
        .red{
            color: red;
        }
        .green{
            color: green;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/customers.js">
    </script>
    <script type="text/javascript" >
             function modifyPwd(cid){
                 $("#cid").val(cid) ;
                 $("#modifyPwd").submit();
             }
             $(function () {
                   $("#gender").val(${modifyCustomer.gender})
             });
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
<form action="/newcar/customer/modifyCustomer.action" id="compileCustomer">
<table width="100%" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
    <input type="hidden" name="id" value="${modifyCustomer.id}">
    <tr>
        <td width="10%">
            身份证&nbsp;
        </td>
        <td width="15%">
            <input type="text" name="identity" id="identity" value="${modifyCustomer.identity}" onblur="checkIdentity()">
        </td>
        <td width="25%"><span id="identitySpan">&nbsp;</span></td>
        <td width="10%">
            姓名&nbsp;
        </td>
        <td width="15%">

            <input type="text" name="custName" id="custName" value="${modifyCustomer.custName}" onblur="checkCustName()">
        </td>
        <td><span id="custNameSpan">&nbsp;</span></td>
    </tr>
    <tr>
    <tr>
        <td>
            住址&nbsp;
        </td>
        <td>
            <input type="text" name="address" id="address" value="${modifyCustomer.address}" >
        </td>
        <td><span id="addressSpan">&nbsp;</span></td>
        <td>
            电话&nbsp;
        </td>
        <td>
            <input type="text" name="phone" id="phone" value="${modifyCustomer.phone}" onblur="checkPhone()">
        </td>
        <td><span id="phoneSpan">&nbsp;</span></td>
    </tr>
    <tr>
        <td>
            职业&nbsp;
        </td>
        <td>
            <input type="text" name="career" id="career" value="${modifyCustomer.career}">
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
        <td><input type="button" value="确定" onclick="checkSubmit();"></td>
        <td><input type="reset" value="重置"></td>
        <td><a href="customerSystem/modifyPwdPage.action"><input type="button" value="修改密码"></a></td>
    </tr>


</table>
</form>
<form action="/newcar/customer/modifyPwd.action" id="modifyPwd">
    <input type="hidden" id="cid" name="id" value="">
</form>
</body>
</html>
