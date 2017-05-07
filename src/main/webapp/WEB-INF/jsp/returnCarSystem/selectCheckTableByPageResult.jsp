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
    <title>出租单信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>


    <script type="text/javascript">
        var  currentPage = 0;
        var totalPage = 0;

        function SubMit(pageNum){
            $("#currentPageValue").val(pageNum);
            $("#myForm").submit();
        }
        $(function () {
            //页面加载时赋值
           currentPage = ${pageBean.currentPage};
            totalPage = ${pageBean.totalPage};
        });
        function prePage(){
            // 提交from添加currentPage参数
            if(currentPage > 1){
                SubMit(currentPage-1);
            }
        }
        function nextPage(){
            if(currentPage < totalPage){
               
                SubMit(currentPage+1);
            }
        }
        function firstPage(){
            if(currentPage > 1){
                SubMit(1);
            }
        }
        function lastPage(){
            if(currentPage < totalPage){
                SubMit(totalPage);
            }
        }
        function goToPage(){ // 跳转到第几页
            var pageNo = $("#toPageNo").val();
            if(pageNo==""){
                pageNo = 1;
            }else{
                pageNo = parseInt(pageNo);
            }
            if(pageNo < 1 || pageNo > totalPage){
                // 输入的页码超出范围
                SubMit(1);
            }else{
                // 输入的页面在有效范围内
                SubMit(pageNo);
            }
        }
        function relDelete(checkId) {
            var result = confirm("是否确认删除该检查单");
            if(result){
                    $.ajax({
                        "method":"post",
                        "url":"returnCar/deleteCheckTable.action",
                        "data":{
                            "checkId":checkId
                        },
                        "success":function (data) {
                            if(data.result){
                                alert("修改成功");

                            }
                        }
                    });
                SubMit(1);
                }
        }
    </script>

</head>
<body>
<form action="returnCar/selectCheckTableByPage2.action" id="myForm" method="post">

    <table width="100%" class="table table-hover" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td>序号</td>
            <td>检查单号</td>
            <td>检查日期</td>
            <td>属性</td>
            <td>问题</td>
            <td>赔款</td>
            <td>检查者姓名</td>
            <td>出租单编号</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${CheckTables}" varStatus="status" var="each">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${each.checkId}</td>
                    <td>${each.checkDate}</td>
                    <td>${each.field}</td>
                    <td>${each.problem}</td>
                    <td>${each.paying}</td>
                    <td>${each.user.userName}</td>
                    <td>${each.rentId}</td>
                    <td>
                        <a href="returnCar/modifyCheckTable.action?checkId=${each.checkId}">编辑</a>
                    </td>
                    <td>
                        <form action="returnCar/deleteCheckTable.action?checkId=${each.checkId}"
                                    id="${each.checkId}">
                            <a href="javascript:void(0);" onclick="relDelete(${each.checkId});">删除</a>
                        </form>

                    </td>
                </tr>
        </c:forEach>

    </table>
    <span>
             <div style="float: left;margin-left: 10px">
                <span>共${pageBean.total}条纪录，当前第
                 ${pageBean.currentPage}/${pageBean.totalPage}页，每页${pageBean.pageSize}条纪录</span>
             </div>
             <div style="float: right;margin-right: 10px">
             <c:if test="${pageBean.currentPage!=1}">
                 <input type="button" value="首页" onclick="firstPage();">
                 <input type="button" value="上一页" onclick="prePage();">
             </c:if>
                跳转到
                 <input id="toPageNo" type="text">/${pageBean.totalPage}页<input type="button" value="跳转" onclick="goToPage();">
             <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                 <input type="button" value="下一页" onclick="nextPage();">
                 <input type="button" value="尾页" onclick="lastPage();">
             </c:if>

                 </div>
         </span>
    <input type="hidden" name="currentPage" id="currentPageValue" >
    <input type="hidden" name="pageSize" value="5" >
</form>
</body>
</html>
