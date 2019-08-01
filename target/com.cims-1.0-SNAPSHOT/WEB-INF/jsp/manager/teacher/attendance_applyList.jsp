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
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
                    课程考勤
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">课程考勤</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">课程考勤</h3>
                               
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body no-padding">
                                <!-- /.modal -->
                                <!-- form start -->
                                <form class="form-horizontal" action="${contextPath}/teacher/attendance/add.do" method="post"  id="add_user" >

                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <tbody>
                                        <tr align="center">
                                            <td>学生ID</td>
                                            <td>学生姓名</td>
                                            <td>考勤状态</td>
                                        </tr>
                                        <c:forEach items="${apply_payVoList}" var="apply_payVo">
                                            <input type="hidden" name="applyPayId" value="${apply_payVo.id}" />
                                            <tr align="center">
                                                <td>${apply_payVo.student.getstudentId()}</td>
                                                <td>${apply_payVo.payStudent}</td>
                                                <td>
                                                    <div class="col-sm-3">
                                                        <select class="form-control select2" style="width: 100%;" name="attendanceStatusId">
                                                            <c:forEach items="${attendance_statusList}" var="status">
                                                                <option value="${status.id}">${status.status}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <!-- /.table -->

                                </div>
                                <!-- /.mail-box-messages -->
                                </form>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer no-padding">
                                <div class="mailbox-controls">
                                    <div class="box-footer clearfix">
                                       <button type="submit" class="btn btn-info pull-right">提交考勤记录</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /. box -->

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
</body>

</html>