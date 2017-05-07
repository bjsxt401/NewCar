<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/29
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>分页查询客户信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script type="text/javascript" >

        var currentPage = 1; // 当前是第几页
        var totalPage = 0; // 总计有多少页
        $(function (){
            AjaxSelect(1);
        });
         function AjaxSelect(pageNum){

             currentPage = pageNum
            $.ajax({
                "method":"post",
                "url":"/newcar/customer/selectCustomer.action",
                "data":{
                    "currentPage":pageNum,
                    "pageSize":5
                } ,
                "success":function(data){
                    totalPage = data.pageBean.totalPage;
                    var tr = "";

                    if (data.pageBean.total==0){
                        tr  +='<tr><th>查询无果</th></tr>'
                    }else{


                    $.each(data.customers,function (i,n) {
                        tr += "<tr>";
                        tr += '     <td>'+n.identity+'</td>         ';
                        tr += '     <td>'+n.custName+'</td>         ';
                        tr += '     <td>'+n.gender+'</td>            ';
                        tr += '    <td>'+n.address+'</td>            ';
                        tr += '    <td>'+n.phone+'</td>             ';
                        tr += '    <td>'+n.career+'</td>             ';
                        tr += '    <td> <a href="javascript:void(0);" onclick="selectModifyCustomer('+n.id+');">编辑</a></td>              ';
                        tr += '    <td> <a href="javascript:void(0);" onclick="deleteCustomer('+n.id+');">删除</a></td>';
                        tr += '</tr>                     ';
                    });
                    }

                    var footer = "";
                    footer += '<tr>                                                                       ';
                    footer += '	<td style="text-align:right; padding-right:10px; padding:5px" colspan="2"> ';
                    footer +='<span>共'+data.pageBean.total+'条纪录，' +
                        '当前第'+data.pageBean.currentPage+'/'+data.pageBean.totalPage+'页，' +
                        '每页'+data.pageBean.pageSize+'条纪录</span></td>';
                    footer +='	<td style="text-align:right; padding-right:10px; padding:5px" colspan="2"></td>'
                    footer +='	<td style="text-align:right; padding-right:10px; padding:5px" colspan="4">'
                    if(data.pageBean.currentPage != 1){
                        footer += '		<input type="button" value="首页" onclick="firstPage();"/>&nbsp;&nbsp;';
                        footer += '		<input type="button" value="上一页" onclick="prePage();"/>&nbsp;&nbsp;';
                    }
                    if(data.pageBean.currentPage != data.pageBean.totalPage){
                        footer += '		<input type="button" value="下一页" onclick="nextPage();"/>&nbsp;&nbsp;';
                        footer += '		<input type="button" value="尾页" onclick="lastPage();"/>&nbsp;&nbsp;';
                    }
                    footer += '		<span>跳转到</span>                 ';
                    footer += '		<input type="text" name="page" size="3" id="toPageNo"/> / '+data.pageBean.totalPage;
                    footer += '		<input type="button" value="跳转" onclick="toPageNo();"/>&nbsp;&nbsp;    ';
                    footer += '	</td>                       ';
                    footer += '</tr>                  ';

                    var tBody = $("#myBody"); // id选择器.根据id属性查询标签.
                    tBody.empty(); // 清空当前标签内所有内容.
                    tBody.append(tr); // 在当前标签内部追加新的元素. tr
                    tBody.append(footer);// 在当前标签内部追加新的元素. footer
                }
            })
         }

        function prePage(){
             
            // 调用AjaxSelect()函数. 需要传递参数. pageNum
            if(currentPage > 1){
                AjaxSelect(currentPage-1);
            }
        }
        function nextPage(){
            if(currentPage < totalPage){
                AjaxSelect(currentPage+1);
            }
        }
        function firstPage(){
            if(currentPage > 1){
                AjaxSelect(1);
            }
        }
        function lastPage(){
            if(currentPage < totalPage){
                AjaxSelect(totalPage);
            }
        }
        function toPageNo(){ // 跳转到第几页
            var pageNo = $("#toPageNo").val();
            if(pageNo==""){
                pageNo = 1;
            }else{
                pageNo = parseInt(pageNo);
            }
            if(pageNo < 1 || pageNo > totalPage){
                // 输入的页码超出范围
                AjaxSelect(1);
            }else{
                // 输入的页面在有效范围内
                AjaxSelect(pageNo);
            }
        }
        function ajaxDelete (cid){
            $.ajax({
                "method":"post",
                "url":"/newcar/customer/deleteCustomer.action",
                "data":{
                    "cid":cid
                }
            });
        }
        function deleteCustomer(cid) {
            var result = confirm("是否确认删除该客户")
            //确认后删除该用户，并查询第一页数据，
            if(result){
                ajaxDelete(cid);
                AjaxSelect(1);
            }
        }
         function selectModifyCustomer(cid) {
                  $("#cid").val(cid) ;
             $("#selectModifyCustomer").submit();
         }

     </script>
</head>
<body>
<table class="table table-hover" width="80%">
     <tr>
         <th>身份证</th>
         <th>姓名</th>
         <th>性别</th>
         <th>住址</th>
         <th>电话</th>
         <th>职业</th>
         <th>编辑</th>
         <th>修改</th>
     </tr>
    <tbody id="myBody">

    </tbody>
</table>
<form action="/newcar/customer/selectModifyCustomer.action" id="selectModifyCustomer">
    <input type="hidden" id="cid" name="cid" value="">
</form>
</body>
</html>
