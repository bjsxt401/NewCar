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
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker
    .js"></script>

    <script type="text/javascript">
        var  currentPage = 1;
        var totalPage = 0;
        var currentPageValue = $("#currentPageValue");
        var myForm = $("#myForm")
        $(function () {
            //页面加载时赋值
           currentPage = ${pageBean.currentPage};
            totalPage = ${pageBean.totalPage};
        });
        function prePage(){
            // 提交from添加currentPage参数
            if(currentPage > 1){
                currentPageValue.val(currentPage-1);
                myForm.submit();
            }
        }
        function nextPage(){
            if(currentPage < totalPage){
                currentPageValue.val(currentPage+1);
                myForm.submit();
            }
        }
        function firstPage(){
            if(currentPage > 1){
                currentPageValue.val(1);
                myForm.submit();
            }
        }
        function lastPage(){
            if(currentPage < totalPage){
                currentPageValue.val(totalPage);
                myForm.submit();
            }
        }
        function toPageNo(){ // 跳转到第几页
            var pageNo = $("#toPageNo").val();
            if(pageNo < 1 || pageNo > totalPage){
                // 输入的页码超出范围
                currentPageValue.val(1);
                myForm.submit();
            }else{
                // 输入的页面在有效范围内
                currentPageValue.val(pageNo);
                myForm.submit();
            }
        }
    </script>

</head>
<body>
<form action="/newcar/lease/selectRentByPage2.action" id="myForm" method="post">

    <table width="100%" class="table table-hover" cellpadding="0" cellspacing="0" border="0" style="text-align: center">
        <tr>
            <td>序号</td>
            <td>出租单编号</td>
            <td>应付金</td>
            <td>起租日期</td>
            <td>应归还日期</td>
            <td>归还日期</td>
            <td>客户姓名</td>
            <td>车号</td>
            <td>服务人员编号</td>
            <td>编辑</td>
        </tr>
        <c:forEach items="${rents}" varStatus="status" var="each">
            <form action="/newcar/lease/selectRentByPage2.action" method="post">
                <input type="hidden" name="carId" value="${each.tableId}">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${each.tableId}</td>
                    <td>${each.shouldPayPrice}</td>
                    <td>${each.beginDate}</td>
                    <td>${each.shouldReturnDate}</td>
                    <td>${each.returnDate}</td>
                    <td>${each.customers.custName}</td>
                    <td>${each.car.carNumber}</td>
                    <td>${each.user.userName}</td>
                    <td><input type="submit" value="编辑"></td>
                </tr>
            </form>
        </c:forEach>

    </table>
    <span>
             <div style="float: left;margin-left: 10px">
                <span>共${pageBean.total}条纪录，当前第
                 ${pageBean.currentPage}/${pageBean.totalPage}页，每页${pageBean.pageSize}条纪录</span>
             </div>
             <div style="float: right;margin-right: 10px">
             <c:if test="${pageBean.currentPage}>1">
                 <input type="button" value="首页" onclick="firstPage();">
                 <input type="button" value="上一页" onclick="prePage();">
             </c:if>
                 <span>跳转到<input id="toPageNo" type="text">/${pageBean.totalPage}页<input type="button" value="跳转" onclick="toPageNo();"></span>
             <c:if test="${pageBean.currentPage}!=${pageBean.totalPage}">
                 <input type="button" value="下一页" onclick="nextPage();">
                 <input type="button" value="尾页" onclick="lastPage();">
             </c:if>

                 </div>
         </span>
    <input type="hidden" name="currentPage" id="currentPageValue" value="">
</form>
</body>
</html>
