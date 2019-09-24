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
        <jsp:include page="../common/teacher_header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="../common/teacher_siderbar.jsp"/>


        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    请假信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">请假信息管理</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">请假申请信息列表</h3>&nbsp&nbsp&nbsp&nbsp
                                <h3 class="box-title">${msgSuccess}${msgError}</h3>

                            </div>
                            <!-- /.box-header -->
                            <div class="box-body no-padding">
                                <!-- /.modal -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <tbody>
                                            <tr align="center">
                                                <td>请假ID</td>
                                                <td>学生名</td>
                                                <td>请假课程名</td>
                                                <td>请假原因</td>
                                                <td>批准状态</td>
                                                <td>到课状态</td>
                                                <td>请假时间</td>
                                                <td>申请时间</td>
                                                <td>批准操作</td>
                                                <td>确认到课操作</td>
                                            </tr>
                                            <c:forEach items="${attendanceDetailsVoList}" var="attendanceVo">
                                            <tr align="center">
                                                <td>${attendanceVo.id}</td>
                                                <td>${attendanceVo.apply_pay.payStudent}</td>
                                                <td>${attendanceVo.courseName}</td>
                                                <td>${attendanceVo.attendance_status.status}</td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.teacherState == 0}">
                                                                <span class="label label-info badge-info">未批准</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.teacherState == 1}">
                                                                <span class="label label-success badge-success">批准</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.teacherState == 2}">
                                                                <span class="label label-danger badge-danger">不批准</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.studentState == 0}">
                                                                <span class="label label-info badge-info">未确认</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.studentState == 1}">
                                                                <span class="label label-success badge-success">未到课</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.studentState == 2}">
                                                                <span class="label label-danger badge-danger">到课</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td><fmt:formatDate value="${attendanceVo.attendanceTime}"
                                                                    pattern="yyyy年MM月dd日"/></td>
                                                <td><fmt:formatDate value="${attendanceVo.createTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                                <td class="mailbox-date">
                                                    <c:choose>
                                                        <c:when test="${attendanceVo.teacherState == 0}">
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/teacher/attendance/updateState1.do?id=${attendanceVo.id}'">
                                                                    <i class="fa fa-fw fa-refresh"></i>批准
                                                                </button>
                                                            </div>
                                                            <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/teacher/attendance/updateState2.do?id=${attendanceVo.id}'">
                                                                <i class="fa fa-fw fa-refresh"></i>不批准
                                                            </button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button" class="btn btn-default"disabled>
                                                                已操作
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </td>
                                                <td class="mailbox-date">
                                                    <c:choose>
                                                        <c:when test="${attendanceVo.studentState == 0 && attendanceVo.teacherState == 1}">
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/teacher/attendance/updateStudentState1.do?id=${attendanceVo.id}'">
                                                                    <i class="fa fa-fw fa-refresh"></i>未到课
                                                                </button>
                                                            </div>
                                                            <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/teacher/attendance/updateStudentState2.do?id=${attendanceVo.id}'">
                                                                <i class="fa fa-fw fa-refresh"></i>到课
                                                            </button>
                                                        </c:when>
                                                        <c:when test="${attendanceVo.teacherState == 2}">
                                                            <button type="button" class="btn btn-default"disabled>
                                                                未批准无需确认
                                                            </button>
                                                        </c:when>
                                                        <c:when test="${attendanceVo.teacherState == 0}">
                                                            <button type="button" class="btn btn-default"disabled>
                                                                未批准无需确认
                                                            </button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button" class="btn btn-default"disabled>
                                                                已操作
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>

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

                        </div>
                        <!-- /. box -->
                        <%--<!-- 模态框 -->--%>
                        <%--<div class="modal fade" id="myModal">--%>
                            <%--<div class="modal-dialog">--%>
                                <%--<div class="modal-content">--%>

                                    <%--<!-- 模态框头部 -->--%>
                                    <%--<div class="modal-header">--%>
                                        <%--<h4 class="modal-title">课程详情</h4>--%>
                                        <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                                    <%--</div>--%>

                                    <%--<!-- 模态框主体 -->--%>
                                    <%--<div class="modal-body">--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程名</label>--%>
                                            <%--<input type="text" class="form-control" id="cName" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cDescription">课程简介信息</label>--%>
                                            <%--<textarea class="form-control" id="cDescription" readonly></textarea>--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程类别</label>--%>
                                            <%--<input type="text" class="form-control" id="categoryName"  readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">上课老师</label>--%>
                                            <%--<input type="text" class="form-control" id="teacherName"  readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程人数</label>--%>
                                            <%--<input type="text" class="form-control" id="number" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程价格</label>--%>
                                            <%--<input type="text" class="form-control" id="price" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程课时</label>--%>
                                            <%--<input type="text" class="form-control" id="period" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程开始时间</label>--%>
                                            <%--<input type="text" class="form-control" id="beginTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程结束时间</label>--%>
                                            <%--<input type="text" class="form-control" id="overTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程上课时间</label>--%>
                                            <%--<input type="text" class="form-control" id="schoolTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">项目创建时间</label>--%>
                                            <%--<input type="text" class="form-control" id="createTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程后一次修改时间</label>--%>
                                            <%--<input type="text" class="form-control" id="updateTime" readonly value="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<!-- 模态框底部 -->--%>
                                    <%--<div class="modal-footer">--%>
                                        <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>--%>
                                    <%--</div>--%>

                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- /.col -->--%>
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
                url: "${contextPath}/teacher/course/modeDate",
                async: true,
                data: {"id": id},
                type: "POST",
                success: function (data) {
                    $("#cName").val(data.cName);
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