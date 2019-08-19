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
                    报名缴费信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">报名缴费信息列表</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">报名缴费信息管理</h3>&nbsp&nbsp&nbsp&nbsp
                                <button type="button" class="btn btn-danger" onclick="location.href='${contextPath}/admin/apply/addApply';"><i class="fa fa-fw fa-search"></i>添加报名缴费信息</button>&nbsp&nbsp&nbsp
                                <h3 class="box-title">${msgSuccess}${msgError}</h3>
                                <div class="box-tools pull-right">
                                    <form action="${contextPath}/admin/apply/list" method="post" id="search">
                                        <input name="pageNum" value="1" hidden>
                                        <input name="pageSize" value="10" hidden>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" placeholder="学生ID" name="keyword"  value="${params.get('keyword')}">
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <button type="button" class="btn btn-default"
                                                onclick="location.href='${contextPath}/admin/apply/list';">
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
                                                <td>报名缴费ID</td>
                                                <td>所属学生</td>
                                                <td>课程名</td>
                                                <td>付款学生</td>
                                                <td>课程金额</td>
                                                <td>实付金额</td>
                                                <td>支付时间</td>
                                                <td>报名时间</td>
                                                <td>课程课时</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${pageResult.list}" var="apply_payVo">
                                            <tr align="center">
                                                <td>${apply_payVo.id}</td>
                                                <td>${apply_payVo.student.name}</td>
                                                <td>${apply_payVo.course.cName}</td>
                                                <td>${apply_payVo.payStudent}</td>
                                                <td>${apply_payVo.course.price}</td>
                                                <td>${apply_payVo.payAmount}</td>
                                                <td><fmt:formatDate value="${apply_payVo.payTime}"
                                                                    pattern="yyyy年MM月dd日 "/></td>
                                                <td><fmt:formatDate value="${apply_payVo.createTime}"
                                                                    pattern="yyyy年MM月dd日 "/></td>
                                                <td>${apply_payVo.course.period}</td>
                                                <td class="mailbox-date">
                                                     <div class="btn-group">
                                                         <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/admin/apply/editApply?id=${apply_payVo.id}'">
                                                             <i class="fa fa-fw fa-refresh"></i>编辑
                                                         </button>
                                                         <a role="button" href="${contextPath}/admin/apply/printApply?id=${apply_payVo.id}" class="btn btn-outline-info" target="_blank" >
                                                             <span class="btn-label"><i class="fa fa-print"></i></span>打印
                                                         </a>
                                                        <%--<button type="button" class="btn btn-default dropdown-toggle"
                                                                data-toggle="dropdown" aria-expanded="false">
                                                            <span class="caret"></span>
                                                            <span class="sr-only">Toggle Dropdown</span>
                                                        </button>
                                                        <ul class="dropdown-menu" role="menu">
                                                            <li><a>删除</a></li>
                                                        </ul>--%>
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
                                                    <a href="${contextPath}/admin/apply/list?pageNum=${pageResult.prePage}">上一页</a>
                                                </c:if>
                                                <c:if test="${!pageResult.hasPreviousPage}">
                                                    <span>上一页</span>
                                                </c:if>
                                            </li>
                                            <c:forEach items="${pageResult.navigatepageNums}" var="num">
                                                <li ${pageResult.pageNum == num ? "class='active'":""}>
                                                    <a href="${contextPath}/admin/apply/list?pageNum=${num}">${num}</a>
                                                </li>
                                            </c:forEach>
                                            <li ${pageResult.hasNextPage? "":"class='disabled'"}>
                                                <c:if test="${pageResult.hasNextPage}">
                                                    <a href="${contextPath}/admin/apply/list?pageNum=${pageResult.nextPage}">下一页</a>
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
    </script>
</body>

</html>