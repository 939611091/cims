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
        <jsp:include page="../common/student_header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="../common/student_siderbar.jsp"/>


        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    请假信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> 我的课程信息</a></li>
                    <li class="active">请假信息管理</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="callout callout-info">
                    <h4>提示！</h4>
                    <p>每个课程最多只能请两次假，三次及三次以上请假不给予退费！</p>
                    <p>批准状态为未批准的状态下才能取消该请假申请信息，取消后该信息删除</p>
                    <p>处理状态为未处理才支持退费！</p>
                </div>
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
                                                <td>负责老师</td>
                                                <td>老师电话</td>
                                                <td>请假原因</td>
                                                <td>请假时间</td>
                                                <td>批准状态</td>
                                                <td>处理状态</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${attendanceVoList}" var="attendanceVo">
                                            <tr align="center">
                                                <td>${attendanceVo.id}</td>
                                                <td>${attendanceVo.apply_pay.payStudent}</td>
                                                <td>${attendanceVo.teacher.name}</td>
                                                <td>${attendanceVo.teacher.phone}</td>
                                                <td>${attendanceVo.attendance_status.status}</td>
                                                <td><fmt:formatDate value="${attendanceVo.attendanceTime}"
                                                                    pattern="yyyy年MM月dd日"/></td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.teacherState == 0}">
                                                                <span class="label label-info badge-info">未批准</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.teacherState == 2}">
                                                                <span class="label label-danger badge-danger">不批准</span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span class="label label-success badge-success">已批准</span>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.state == 0}">
                                                                <span class="label label-danger badge-danger">未处理</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.state == 1}">
                                                                <span class="label label-success badge-success">已退费</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td class="mailbox-date">
                                                    <c:choose>
                                                        <c:when test="${attendanceVo.teacherState == 0}">
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/student/attendance/delete.do?id=${attendanceVo.id}'">
                                                                    <i class="fa fa-fw fa-refresh"></i>取消请假
                                                                </button>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button" class="btn btn-default"disabled>
                                                                已处理
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
                            <%--<div class="box-footer no-padding">--%>
                                <%--<div class="mailbox-controls">--%>
                                    <%--<div class="box-footer clearfix">--%>
                                        <%--<ul class="pagination pagination-sm no-margin pull-right">--%>
                                            <%--<li ${pageResult.hasPreviousPage? "":"class='disabled'"}>--%>
                                                <%--<c:if test="${pageResult.hasPreviousPage}">--%>
                                                    <%--<a href="${contextPath}/teacher/attendance/list?pageNum=${pageResult.prePage}">上一页</a>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${!pageResult.hasPreviousPage}">--%>
                                                    <%--<span>上一页</span>--%>
                                                <%--</c:if>--%>
                                            <%--</li>--%>
                                            <%--<c:forEach items="${pageResult.navigatepageNums}" var="num">--%>
                                                <%--<li ${pageResult.pageNum == num ? "class='active'":""}>--%>
                                                    <%--<a href="${contextPath}/teacher/attendance/list?pageNum=${num}">${num}</a>--%>
                                                <%--</li>--%>
                                            <%--</c:forEach>--%>
                                            <%--<li ${pageResult.hasNextPage? "":"class='disabled'"}>--%>
                                                <%--<c:if test="${pageResult.hasNextPage}">--%>
                                                    <%--<a href="${contextPath}/teacher/attendance/list?pageNum=${pageResult.nextPage}">下一页</a>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${!pageResult.hasNextPage}">--%>
                                                    <%--<span>下一页</span>--%>
                                                <%--</c:if>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
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


</body>

</html>