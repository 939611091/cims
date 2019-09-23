<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程信息管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../common/required_css.jsp"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<style>

    .block-flowchart .panel-body {padding: 0 30px 0 20px;}
    .flow-item {float: left; width: 16.66667%; max-width: 180px; text-align: center; margin-bottom: 9px; padding-right: 15px;}
    .flow-item > div {position: relative; padding: 5px 0 5px 8px; line-height: 20px; background: #E8EBEF; white-space:nowrap; overflow: visible; color: #3c4353}
    .flow-item > div:before, .flow-item > div:after {content: ' '; display: block; width: 0; height: 0; border-style: solid; border-width: 15px 0 15px 10px; border-color: transparent transparent transparent #E8EBEF; position: absolute; left: 0; top: 0;}
    .ie-8 .flow-item > div:before {display: none}
    .flow-item > div:before {border-left-color: #fff; z-index: 1}
    .flow-item > div:after {left: auto; right: -10px; z-index: 2}
    .ie-8 .flow-item > div {margin-right: 10px}
    .flow-item-0 > div {color: #838A9D; font-weight: bold; padding-left: 0;}
    .flow-item-0 > div:before {display: none}
    .flow-item-1 > div {background: #E3F2FD}
    .flow-item-1 > div:after {border-left-color: #E3F2FD}
    .flow-item-2 > div {background: #E8F5E9}
    .flow-item-2 > div:after {border-left-color: #E8F5E9}
    .flow-item-3 > div {background: #FFF3E0}
    .flow-item-3 > div:after {border-left-color: #FFF3E0}
    .flow-item-4 > div {background: #FFEBEE}
    .flow-item-4 > div:after {border-left-color: #FFEBEE}
    .flow-item-5 > div {background: #F3E5F5}
    .flow-item-5 > div:after {border-left-color: #F3E5F5}
    .flow-item-1 > div:hover {background: #1565C0; color: #fff;}
    .flow-item-1 > div:hover:after {border-left-color: #1565C0}
    .flow-item-2 > div:hover {background: #43A047; color: #fff;}
    .flow-item-2 > div:hover:after {border-left-color: #43A047}
    .flow-item-3 > div:hover {background: #EF6C00; color: #fff;}
    .flow-item-3 > div:hover:after {border-left-color: #EF6C00}
    .flow-item-4 > div:hover {background: #E53935; color: #fff;}
    .flow-item-4 > div:hover:after {border-left-color: #E53935}
    .flow-item-5 > div:hover {background: #9C27B0; color: #fff;}
    .flow-item-5 > div:hover:after {border-left-color: #9C27B0}

    .block-sm .flow-item {padding-right: 5px}
    .block-sm .flow-item > div:before, .block-sm .flow-item > div:after {border-width: 15px 0 15px 6px;}
    .block-sm .row-3 .flow-item-1, .block-sm .row-3 .flow-item-3 {width: 25%}
    .block-sm .flow-item > div:after {right: -6px;}

</style>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <jsp:include page="../common/main_header.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../common/main_siderbar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="box box-default">

                <!-- /.box-header -->
                <div class="box-body" >
                    <h1>欢迎使用课程信息管理系统 </h1>
                    <%--<c:choose>--%>
                        <%--<c:when test="${notificationCount > 0}">--%>
                            <%--<p>您有 ${notificationCount} 条<a href="${contextPath}/manager/user/currentuser/message_list">未读通知</a>哦 (๑＞ڡ＜)☆</p>--%>
                        <%--</c:when>--%>
                            <h3>你好，${sessionScope.admin.name}管理员 (๑＞ڡ＜)☆</h3>
                    <%--</c:choose>--%>

                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">管理员使用导航图</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body" id="dashboard">
                    <div class="panel-body scrollbar-hover">
                        <div class="row row-0">
                            <div class="flow-item flow-item-0"><div title="教室管理">教室管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看教室列表">查看教室列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑教室">编辑教室</div></div>
                            <div class="flow-item flow-item-3"><div title="删除教室">删除教室</div></div>
                            <div class="flow-item flow-item-4"><div title="添加教室">添加教室</div></div>
                        </div>
                        <div class="row row-1">
                            <div class="flow-item flow-item-0"><div title="课程类别管理">课程类别管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看课程类别列表">查看课程类别列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑课程类别">编辑课程类别</div></div>
                            <div class="flow-item flow-item-3"><div title="删除课程类别">删除课程类别</div></div>
                            <div class="flow-item flow-item-4"><div title="添加课程类别">添加课程类别</div></div>
                        </div>
                        <div class="row row-2">
                            <div class="flow-item flow-item-0"><div title="课程信息管理">课程信息管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看课程列表">查看课程列表</div></div>
                            <div class="flow-item flow-item-2"><div title="发布课程">发布课程</div></div>
                            <div class="flow-item flow-item-3"><div title="查看课程详细">查看课程详细</div></div>
                            <div class="flow-item flow-item-4"><div title="安排教室">安排教室</div></div>
                            <div class="flow-item flow-item-5"><div title="打印课程考勤表">打印课程考勤表</div></div>
                        </div>
                        <div class="row row-3">
                            <div class="flow-item flow-item-0"><div title="课程安排上课教室">课程安排上课教室</div></div>
                            <div class="flow-item flow-item-1"><div title="课程教室安排情况">课程教室安排情况</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑安排">编辑安排</div></div>
                            <div class="flow-item flow-item-3"><div title="删除安排">删除安排</div></div>
                            <div class="flow-item flow-item-4"><div title="安排教室">安排教室</div></div>
                        </div>
                        <div class="row row-4">
                            <div class="flow-item flow-item-0"><div title="报名缴费管理">报名缴费管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看报名缴费信息">查看报名缴费信息</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑报名缴费信息">编辑报名缴费信息</div></div>
                            <div class="flow-item flow-item-3"><div title="打印报名缴费信息">打印报名缴费信息</div></div>
                            <div class="flow-item flow-item-4"><div title="填写报名缴费信息">填写报名缴费信息</div></div>
                        </div>
                        <div class="row row-5">
                            <div class="flow-item flow-item-0"><div title="处理请假售后">处理请假售后</div></div>
                            <div class="flow-item flow-item-1"><div title="查看请假信息列表">查看请假信息列表</div></div>
                            <div class="flow-item flow-item-2"><div title="退费处理">退费处理</div></div>
                        </div>
                        <div class="row row-6">
                            <div class="flow-item flow-item-0"><div title="请假状态管理">请假状态管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看请假状态列表">查看请假状态列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑请假状态">编辑请假状态</div></div>
                            <div class="flow-item flow-item-3"><div title="删除请假状态">删除请假状态</div></div>
                            <div class="flow-item flow-item-4"><div title="添加请假状态">添加请假状态</div></div>
                        </div>
                        <div class="row row-7">
                            <div class="flow-item flow-item-0"><div title="请假状态管理">请假状态管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看请假状态列表">查看请假状态列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑请假状态">编辑请假状态</div></div>
                            <div class="flow-item flow-item-3"><div title="删除请假状态">删除请假状态</div></div>
                            <div class="flow-item flow-item-4"><div title="添加请假状态">添加请假状态</div></div>
                        </div>
                        <div class="row row-8">
                            <div class="flow-item flow-item-0"><div title="学生荣誉管理">学生荣誉管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看学生荣誉列表">查看学生荣誉列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑学生荣誉">编辑学生荣誉</div></div>
                            <div class="flow-item flow-item-3"><div title="添加学生荣誉">添加学生荣誉</div></div>
                        </div>
                        <div class="row row-9">
                            <div class="flow-item flow-item-0"><div title="学生管理">学生管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看学生列表">查看学生列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑学生信息">编辑学生信息</div></div>
                            <div class="flow-item flow-item-3"><div title="删除学生信息">删除学生信息</div></div>
                            <div class="flow-item flow-item-4"><div title="录入学生信息">录入学生信息</div></div>
                        </div>
                        <div class="row row-10">
                            <div class="flow-item flow-item-0"><div title="学生管理">老师管理</div></div>
                            <div class="flow-item flow-item-1"><div title="查看老师列表">查看老师列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑老师信息">编辑老师信息</div></div>
                            <div class="flow-item flow-item-3"><div title="删除老师信息">删除老师信息</div></div>
                            <div class="flow-item flow-item-4"><div title="录入老师信息">录入老师信息</div></div>
                        </div>
                        <div class="row row-11">
                            <div class="flow-item flow-item-0"><div title="管理员管理">管理员管理</div></div>
                            <div class="flow-item flow-item-1"><div title="编辑管理员信息">查看管理员列表</div></div>
                            <div class="flow-item flow-item-2"><div title="编辑管理员信息">编辑管理员信息</div></div>
                            <div class="flow-item flow-item-3"><div title="录入管理员信息">录入管理员信息</div></div>
                        </div>
                    </div>
                </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="../common/main_footer.jsp"/>
</div>
<!-- ./wrapper -->

<%--后台必要的JavaScript库--%>
<jsp:include page="../common/required_js.jsp"/>

</body>
</html>