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
    <!-- Select2 -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/select2/dist/css/select2.min.css">
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
        <section class="content-header">
            <h1>
                编辑学生荣誉
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>学生荣誉管理</a></li>
                <li class="active">编辑学生荣誉</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content ">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">编辑学生荣誉</h3>&nbsp&nbsp&nbsp
                            <h3 class="box-title">${msgError}</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="${contextPath}/admin/honor/editHonor.do" method="post" enctype="multipart/form-data" id="add_user" >
                            <div class="box-body">
                                <input type="hidden" name="id" value="${honor.id }" />
                                <div class="form-group" id="name">
                                    <label  class="col-sm-2 control-label">指导老师</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="指导老师" name="name" value="${honor.name }">
                                    </div>
                                </div>
                                <div class="form-group" id="beginTime">
                                    <label  class="col-sm-2 control-label">获奖时间</label>
                                    <div class="col-sm-8">
                                        <input type="date" class="form-control"  placeholder="获奖时间" name="time" value="${h_time}">
                                    </div>
                                </div>
                                <div class="form-group" id="info">
                                    <label  class="col-sm-2 control-label">获奖内容</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="获奖内容" name="info" value="${honor.info }">
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
                                <button type="submit" class="btn btn-info pull-right">保存</button>
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

    <%--后台必要的JavaScript库--%>
    <jsp:include page="../common/required_js.jsp"/>
</body>

</html>