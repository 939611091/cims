<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程信息管理系统</title>
    <%-- 后台必须有的CSS--%>
    <jsp:include page="../common/required_css.jsp"/>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <!-- Main Header -->
        <jsp:include page="../common/main_header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="../common/main_siderbar.jsp"/>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    课程信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">课程信息管理</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">课程信息列表</h3>&nbsp&nbsp&nbsp&nbsp
                                <button type="button" class="btn btn-danger" onclick="location.href='${contextPath}/admin/course/addCourse';"><i class="fa fa-fw fa-search"></i>录入课程信息</button>&nbsp&nbsp&nbsp
                                <h3 class="box-title">${msgSuccess}${msgError}</h3>
                                <div class="box-tools pull-right">
                                    <form action="${contextPath}/admin/course/list" method="post" id="search">
                                        <input name="pageNum" value="1" hidden>
                                        <input name="pageSize" value="10" hidden>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" placeholder="课程名" name="keyword" value="${params.get('keyword')}" >
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <button type="button" class="btn btn-default"
                                                onclick="location.href='${contextPath}/admin/course/list';">
                                            <i class="fa fa-fw fa-refresh"></i>查询全部
                                        </button>
                                        <button type="button" class="btn btn-success" onclick="searchArticles({})"><i class="fa fa-fw fa-search"></i>查询
                                        </button>
                                    </div>
                                    </form>
                                </div>
                                <!-- /.box-tools -->
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body no-padding">
                                <!-- /.modal -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <tbody>
                                            <tr align="center">
                                                <td>课程id</td>
                                                <td>课程名</td>
                                                <td>课程类别</td>
                                                <td>上课老师</td>
                                                <td>上课时间</td>
                                                <td>开课时间</td>
                                                <td>结课时间</td>
                                                <td>课程人数</td>
                                                <td>课程剩余人数(人)</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${pageResult.list}" var="courseVo">
                                            <tr align="center">
                                                <td>${courseVo.id}</td>
                                                <td>${courseVo.cName}</td>
                                                <td>${courseVo.course_category.categoryName}</td>
                                                <td>${courseVo.teacher.name}</td>
                                                <td>${courseVo.schoolTime}</td>
                                                <td><fmt:formatDate value="${courseVo.beginTime}"
                                                                    pattern="yyyy年MM月dd日 "/></td>
                                                <td><fmt:formatDate value="${courseVo.overTime}"
                                                                    pattern="yyyy年MM月dd日 "/></td>
                                                <td>${courseVo.number}</td>
                                                <td>${courseVo.surplusNumber}</td>
                                                <td class="mailbox-date">
                                                     <div class="btn-group">
                                                         <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/admin/course/editCourse?id=${courseVo.id}'">
                                                             <i class="fa fa-fw fa-refresh"></i>编辑
                                                         </button>
                                                        <button type="button" class="btn btn-default dropdown-toggle"
                                                                data-toggle="dropdown" aria-expanded="false">
                                                            <span class="caret"></span>
                                                            <span class="sr-only">Toggle Dropdown</span>
                                                        </button>
                                                       
                                                        <ul class="dropdown-menu" role="menu">
                                                             <li><a data-toggle="modal" data-target="#myModal" href="#"
                                                                    onclick="query(${courseVo.id})">查看课程详细</a></li>
                                                            <li><a href="${contextPath}/admin/plan/addPlan?id=${courseVo.id}">安排教室</a></li>
                                                            <li><a href="${contextPath}/admin/course/studentList?id=${courseVo.id}">查看课程学生名单</a></li>
                                                            <li><a href="${contextPath}/admin/course/printStudentList?id=${courseVo.id}">打印课程考勤表</a></li>
                                                            <li><a href="${contextPath}/admin/course/delete.do?id=${courseVo.id}" onclick= "return confirm('课程删除后，对应教室安排会被一起删除，确认删除？');">删除</a></li>
                                                        </ul>
                                                         
                                                    </div>
                                                </td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <!-- /.table -->

                                </div>
                                <!-- /.mail-box-messages -->
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer no-padding">
                                <div class="mailbox-controls">
                                    <div class="box-footer clearfix">
                                        <ul class="pagination pagination-sm no-margin pull-right">
                                            <li ${pageResult.hasPreviousPage? "":"class='disabled'"}>
                                                <c:if test="${pageResult.hasPreviousPage}">
                                                    <a href="${contextPath}/admin/course/list?pageNum=${pageResult.prePage}">上一页</a>
                                                </c:if>
                                                <c:if test="${!pageResult.hasPreviousPage}">
                                                    <span>上一页</span>
                                                </c:if>
                                            </li>
                                            <c:forEach items="${pageResult.navigatepageNums}" var="num">
                                                <li ${pageResult.pageNum == num ? "class='active'":""}>
                                                    <a href="${contextPath}/admin/course/list?pageNum=${num}">${num}</a>
                                                </li>
                                            </c:forEach>
                                            <li ${pageResult.hasNextPage? "":"class='disabled'"}>
                                                <c:if test="${pageResult.hasNextPage}">
                                                    <a href="${contextPath}/admin/course/list?pageNum=${pageResult.nextPage}">下一页</a>
                                                </c:if>
                                                <c:if test="${!pageResult.hasNextPage}">
                                                    <span>下一页</span>
                                                </c:if>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /. box -->
                        <!-- 模态框 -->
                        <div class="modal fade" id="myModal">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- 模态框头部 -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">课程详情</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- 模态框主体 -->
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="cName">课程名</label>
                                            <input type="text" class="form-control" id="cName" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">上课教室</label>
                                            <input type="text" class="form-control" id="classroom" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cDescription">课程简介信息</label>
                                            <textarea class="form-control" id="cDescription" readonly></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程类别</label>
                                            <input type="text" class="form-control" id="categoryName"  readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">上课老师</label>
                                            <input type="text" class="form-control" id="teacherName"  readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程人数</label>
                                            <input type="text" class="form-control" id="number" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程价格</label>
                                            <input type="text" class="form-control" id="price" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程课时</label>
                                            <input type="text" class="form-control" id="period" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程开始时间</label>
                                            <input type="text" class="form-control" id="beginTime" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程结束时间</label>
                                            <input type="text" class="form-control" id="overTime" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程上课时间</label>
                                            <input type="text" class="form-control" id="schoolTime" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程创建时间</label>
                                            <input type="text" class="form-control" id="createTime" readonly value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="cName">课程后一次修改时间</label>
                                            <input type="text" class="form-control" id="updateTime" readonly value="">
                                        </div>
                                    </div>

                                    <!-- 模态框底部 -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                </div>
                <!-- /.row -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
        <jsp:include page="../common/main_footer.jsp"/>

        <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
    </div>
    <!-- ./wrapper -->

    <%--后台必要的JavaScript库--%>
    <jsp:include page="../common/required_js.jsp"/>

    <script>

        //分页
        function searchArticles(condition){
            // console.log(condition.beginTime);
            // console.log($("#search input[name='pageNum']").val());
            if(condition.pageNum !== null && condition.pageNum !== undefined){
                $("#search input[name='pageNum']").val(condition.pageNum);
            }
            if(condition.keyword !== null && condition.keyword !== undefined){
                $("#search input[name='keyword']").val(condition.keyword);
            }
            $("#search").submit();
        }

        //时间戳转时间
        function timeTool (value) {  //13位时间戳
            var date = new Date(value);
            var Y = date.getFullYear() + '-';
            var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
            // var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
            // var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
            // var s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());+h+m+s
            return (Y+M+D);
        }
        //模态框详情
        function query(id) {
            $.ajax({
                url: "${contextPath}/admin/course/modeDate",
                async: true,
                data: {"id": id},
                type: "POST",
                success: function (data) {
                    $("#cName").val(data.cName);
                    $("#classroom").val(data.classroom);
                    $("#cDescription").val(data.cDescription);
                    $("#categoryName").val(data.categoryName);
                    $("#teacherName").val(data.teacherName);
                    $("#number").val(data.number);
                    $("#price").val(data.price);
                    $("#period").val(data.period);
                    $("#beginTime").val(timeTool(data.beginTime));
                    $("#overTime").val(timeTool(data.overTime));
                    $("#schoolTime").val(data.schoolTime);
                    $("#createTime").val(timeTool(data.createTime));
                    $("#updateTime").val(timeTool(data.updateTime))
                }
            })
        }

    </script>
</body>

</html>