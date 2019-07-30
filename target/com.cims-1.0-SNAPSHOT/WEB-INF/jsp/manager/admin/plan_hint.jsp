<%--
  Created by IntelliJ IDEA.
  User: vanh
  Date: 2019/6/20
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
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
                安排教室
                <small>当前状态</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 安排教室管理</a></li>
                <li class="active">安排教室</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="callout callout-info">
                <h4>安排教室需要前往课程列表，对选择课程进行安排操作</h4>
                点击前往
                <a href="${contextPath}/admin/course/list">课程列表</a>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="../common/main_footer.jsp"/>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%--后台必要的JavaScript库--%>
<jsp:include page="../common/required_js.jsp"/>
</body>
</html>

