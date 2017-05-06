<%--
  Created by IntelliJ IDEA.
  User: beichunming
  Date: 2017/4/20
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
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
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="asset/lib/dataTables-1.10.7/media/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="asset/lib/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" charset="utf8" src="asset/lib/dataTables-1.10.7/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        var rootPath = '${pageContext.request.contextPath}';

    </script>
</head>
<body>
<form>
    <span>编号:</span> <input type="text" placeholder="编号" id="id-search">
    <span>名称:</span> <input type="text" placeholder="名称" id="name-search">
    <span>状态:</span> <select id="status-search">
    <option value="">全部</option>
    <option value="1">可以查发</option>
    <option value="2">可以链接</option>
    <option value="3">仅供查询</option>
    <option value="4">不可用</option>
</select>
    <button type="button" id="btn_search">查询</button>
    
</form>
<table id="table" class="display">
    <thead>
    <tr>
        <th>序号</th>
        <th>登录名</th>
        <th>身份证</th>
        <th>姓名</th>
        <th>性别</th>
        <th>职位</th>
        <th>用户类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
<script type="text/javascript" src="asset/js/constant.js"></script>
<script type="text/javascript">
    $(function(){
        var $table = $("#table");
        var _table = $table.dataTable($.extend(true,{},CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
            ajax : function(data, callback, settings) {
                //封装请求参数
                var param = userManage.getQueryCondition(data);
                $.ajax({
                    type: "GET",
                    url: rootPath+"/user/displayUserList.action",
                    cache : false,  //禁用缓存
                    data: param,    //传入已封装的参数
                    dataType: "json",
                    success: function(result) {
                        //异常判断与处理
                        if (result.errorCode) {
                            alert("查询失败");
                            return;
                        }
                        //封装返回数据
                        var returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.total;//总记录数
                        returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.pageData;
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert("查询失败");
                    }
                });
            },
            //绑定数据
            columns: [
                {
                    data: "uid",//字段名
                },
                {
                    data: "userName",//字段名
                },
                {
                    data : "identity",//字段名
//                    render : function(data,type, row, meta) {
//                        return (data == 1? "可以查发":data == 2?"可以链接":data == 3?"仅供查询":"不可用");
//                    }
                },
                {
                    data : "fullName",//字段名
                },
                {
                    data : "gender",//字段名
                    orderable : false,//禁用排序
                    render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS//alt效果
                },
                {
                    data : "position",//字段名
                },
                {
                    data : "roleName",//字段名
                },

                {
                    data: null,//字段名
                    defaultContent:"",//无默认值
                    orderable : false//禁用排序
                }
            ],
            "createdRow": function ( row, data, index ) {
                //不使用render，改用jquery文档操作呈现单元格
                var $btnEdit = $('<button type="button" class="btn-edit">编辑</button>');
                var $btnDel = $('<button type="button" class="btn-del">删除</button>');
                $('td', row).eq(7).append($btnEdit).append($btnDel);
            },
            "drawCallback": function( settings ) {
                //渲染完毕后的回调
                //默认选中第一行
                //$("tbody tr",$table).eq(0).click();
            }
        })).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
        //查询
        $("#btn_search").click(function(){
            _table.draw();
        });
        //行点击事件
//        $("tbody",$table).on("click","tr",function(event) {
//            $(this).addClass("active").siblings().removeClass("active");
//            //获取该行对应的数据
//            var item = _table.row($(this).closest('tr')).data();
//            userManage.showItemDetail(item);
//        });
        //按钮点击事件
        $table.on("click",".btn-edit",function() {
            //点击编辑按钮
            var item = _table.row($(this).closest('tr')).data();
            userManage.editItemInit(item);
        }).on("click",".btn-del",function() {
            //点击删除按钮
            var item = _table.row($(this).closest('tr')).data();
            userManage.deleteItem(item);
        });
        //影藏列
        $('a').on( 'click', function (e) {
            var cut = $(this).text()
            if(cut.indexOf("显示")>-1){
                $(this).text("影藏"+cut.split("示")[1])
            }else{
                $(this).text("显示"+cut.split("藏")[1])
            }
            e.preventDefault();
            var column = _table.column( $(this).attr('data-column') );
            column.visible( ! column.visible() );
        } );

    });
    var userManage = {
        getQueryCondition : function(data) {
            var param = {};
            //组装排序参数
            if (data.order&&data.order.length&&data.order[0]) {
                switch (data.order[0].column) {
                    case 0:
                        param.orderColumn = "uid";//数据库列名称
                        break;
                    case 1:
                        param.orderColumn = "username";//数据库列名称
                        break;
                    case 2:
                        param.orderColumn = "fullname";//数据库列名称
                        break;
                    case 3:
                        param.orderColumn = "phone";//数据库列名称
                        break;
                    default:
                        param.orderColumn = "uid";//数据库列名称
                        break;
                }
                //排序方式asc或者desc
                param.orderDir = data.order[0].dir;
            }                                                                 0
            param.id = $("#id-search").val();//查询条件
            param.name = $("#name-search").val();//查询条件
            param.status = $("#status-search").val();//查询条件
            //组装分页参数
            param.startIndex = data.start;
            param.pageSize = data.length;
            param.draw = data.draw;
            
            return param;
        },
        editItemInit : function(item) {
            //编辑方法
            window.location.href="user/toUpdateUser.action?uid="+item.uid;
        },
        deleteItem : function(item) {
            //删除
            //alert("删除"+item.uid+"  "+item.userName);
            var result = confirm("是否确认删除该用户")
            //确认后删除该用户，并查询第一页数据，
            if(result){
                window.location.href="user/deleteUserItem.action?uid="+item.uid;
            }

        },
        showItemDetail: function(item){
            //点击行
            alert("点击"+item.uid+"  "+item.userName);
        }
    };
    
</script>
</body>
</html>