<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="com.deepdream.pdms.common.Const" %>--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    课程类别管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">课程类别列表</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="callout callout-info">
                    <h4>提示！</h4>
                    <p>前端显示的课程类别不能删除</p>
                    <p>删除类别后，对应类别的课程也会被一起删除，请谨慎操作！！！</p>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">课程类别列表</h3>
                                <button type="button" class="btn btn-danger" onclick="location.href='${contextPath}/admin/courseCategory/add';"><i class="fa fa-fw fa-search"></i>添加课程类别</button>&nbsp&nbsp&nbsp
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
                                                <td>类别名</td>
                                                <td>创建时间</td>
                                                <td>更新时间</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${categoryList }" var="category">
                                                <tr align="center">
                                                    <td>${category.id }</td>
                                                    <td>${category.categoryName }</td>
                                                    <%--<td>${classroom.capacity }</td>--%>
                                                    <td><fmt:formatDate value="${category.createTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm"/></td>
                                                    <td><fmt:formatDate value="${category.updateTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm"/></td>
                                                    <td class="mailbox-date">
                                                        <c:choose>
                                                            <c:when test="${category.id == 1}">
                                                                <button type="button" class="btn btn-default"disabled>
                                                                    用于前端显示无法编辑和删除
                                                                </button>
                                                            </c:when>
                                                            <c:when test="${category.id == 2}">
                                                                <button type="button" class="btn btn-default"disabled>
                                                                    用于前端显示无法编辑和删除
                                                                </button>
                                                            </c:when>
                                                            <c:when test="${category.id == 3}">
                                                                <button type="button" class="btn btn-default"disabled>
                                                                    用于前端显示无法编辑和删除
                                                                </button>
                                                            </c:when>
                                                            <c:when test="${category.id == 4}">
                                                                <button type="button" class="btn btn-default"disabled>
                                                                    用于前端显示无法编辑和删除
                                                                </button>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="btn-group">
                                                                    <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/admin/courseCategory/edit?id=${category.id}'">
                                                                        编辑
                                                                    </button>
                                                                    <button type="button" class="btn btn-default dropdown-toggle"
                                                                            data-toggle="dropdown" aria-expanded="false">
                                                                        <span class="caret"></span>
                                                                        <span class="sr-only">Toggle Dropdown</span>
                                                                    </button>
                                                                    <ul class="dropdown-menu" role="menu">
                                                                        <li><a href="${contextPath}/admin/courseCategory/delete.do?id=${category.id}" onclick= "return confirm('删除后该类别所有课程也被删除。确认删除？');">删除</a></li>
                                                                    </ul>
                                                                </div>
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