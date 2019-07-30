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
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/alt/AdminLTE-select2.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/select2/dist/css/select2.min.css">

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
        <section class="content-header">
            <h1>
                添加学生荣誉
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>学生荣誉管理</a></li>
                <li class="active">添加学生荣誉</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content ">
            <div class="callout callout-info">
                <h4>提示！</h4>
                <p>指导老师，获奖时间，获奖内容均不能为空</p>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">添加学生荣誉</h3>&nbsp;&nbsp;&nbsp;
                            <h3 class="box-title">${msgError}${msg}</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="${contextPath}/admin/honor/addHonor.do" method="post" enctype="multipart/form-data" id="add_user" >
                            <div class="box-body">
                                <input type="hidden" name="studentId" value="${student.studentId }" />
                                <div class="form-group" id="studentName">
                                    <label class="col-sm-2 control-label">获奖学生姓名</label>
                                    <div class="col-sm-8">
                                        <input type="text"  class="form-control" placeholder="学生姓名" name="sname" value="${student.name}" readonly="readonly">
                                    </div>

                                </div>
                                <div class="form-group" id="password">
                                    <label class="col-sm-2 control-label">学生ID</label>
                                    <div class="col-sm-8">
                                        <input type="text"  class="form-control" placeholder="学生ID" name="studentId" value="${student.studentId}" readonly="readonly">
                                    </div>

                                </div>
                                <div class="form-group" id="name">
                                    <label  class="col-sm-2 control-label">指导老师</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="指导老师" name="name">
                                    </div>
                                </div>
                                <div class="form-group" id="beginTime">
                                    <label  class="col-sm-2 control-label">获奖时间</label>
                                    <div class="col-sm-8">
                                        <input type="date" class="form-control"  placeholder="获奖时间" name="time">
                                    </div>
                                </div>
                                <div class="form-group" id="info">
                                    <label  class="col-sm-2 control-label">获奖内容</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="获奖内容" name="info">
                                    </div>
                                </div>
                                <div class="form-group" id="hPhoto">
                                    <label  class="col-sm-2 control-label">获奖照片</label>
                                    <div class="col-sm-8">
                                        <input type="file"     name = "fil" /><br>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">添加荣誉</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <jsp:include page="../common/main_footer.jsp"/>
        <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
    </div>
    <!-- ./wrapper -->

    <!-- jQuery 3 -->
    <script src="${contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="${contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Slimscroll -->
    <script src="${contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="${contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="${contextPath}/resources/dist/js/adminlte.min.js"></script>
    <!-- iCheck -->
    <script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
    <!-- Page Script -->
    <!-- Select2 -->
    <script src="${contextPath}/resources/bower_components/select2/dist/js/select2.full.min.js"></script>

    <script src="${contextPath}/resources/dist/js/demo.js"></script>

</body>

</html>