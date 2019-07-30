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
                    教室信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">教室列表</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">教室列表</h3>&nbsp&nbsp&nbsp
                                <button type="button" class="btn btn-danger" onclick="location.href='${contextPath}/admin/classroom/add';"><i class="fa fa-fw fa-search"></i>添加教室</button>&nbsp&nbsp&nbsp
                                <h3 class="box-title">${msgSuccess}${msgError}</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body no-padding">
                                <!-- /.modal -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <tbody>
                                            <tr align="center">
                                                <td>ID</td>
                                                <td>教室名</td>
                                                <td>教室容量(单位：人)</td>
                                                <td>创建时间</td>
                                                <td>更新时间</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${classroomList }" var="classroom">
                                            <tr align="center">
                                                <td>${classroom.id }</td>
                                                <td>${classroom.classroomName }</td>
                                                <td>${classroom.capacity }</td>
                                                <td><fmt:formatDate value="${classroom.createTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm"/></td>
                                                <td><fmt:formatDate value="${classroom.updateTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm"/></td>
                                                <td class="mailbox-date">
                                                     <div class="btn-group">
                                                        <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/admin/classroom/edit?id=${classroom.id}'">
                                                          编辑
                                                        </button>
                                                         <button type="button" class="btn btn-default dropdown-toggle"
                                                                data-toggle="dropdown" aria-expanded="false">
                                                            <span class="caret"></span>
                                                            <span class="sr-only">Toggle Dropdown</span>
                                                        </button>
                                                        <ul class="dropdown-menu" role="menu">
                                                            <li><a href="${contextPath}/admin/classroom/delete.do?id=${classroom.id}" onclick= "return confirm('确认删除？');">删除</a></li>
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
        <div class="control-sidebar-bg"></div>
    </div>
    <!-- ./wrapper -->

    <%--后台必要的JavaScript库--%>
    <jsp:include page="../common/required_js.jsp"/>


</body>

</html>