<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.admin.name}，我的ID：${sessionScope.admin.adminId}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单</li>
            <li><a href="${contextPath}/admin/index"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>教室管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/admin/classroom/list"><i class="fa fa-circle-o"></i>查看教室列表</a>
                    </li>
                    <li><a href="${contextPath}/admin/classroom/add"><i class="fa fa-circle-o"></i>添加教室</a>
                    </li>
                </ul>
            </li>


            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>课程类别管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/courseCategory/list"><i class="fa fa-circle-o"></i>查看课程类别列表</a></li>
                    <li><a href="${contextPath}/admin/courseCategory/add"><i class="fa fa-circle-o"></i>添加课程类别</a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>课程信息管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/course/list"><i class="fa fa-circle-o"></i>查看课程列表</a></li>
                    <li><a href="${contextPath}/admin/course/addCourse"><i class="fa fa-circle-o"></i>发布课程</a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>课程安排上课教室</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/plan/list"><i class="fa fa-circle-o"></i>课程教室安排情况</a></li>
                        <li><a href="${contextPath}/admin/plan/addHint"><i class="fa fa-circle-o"></i>安排教室</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>报名缴费管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/apply/list"><i class="fa fa-circle-o"></i>查看报名缴费信息</a></li>
                    <li><a href="${contextPath}/admin/apply/addApply"><i class="fa fa-circle-o"></i>填写报名缴费信息</a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>处理请假售后</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/attendance/list"><i class="fa fa-circle-o"></i>查看请假信息列表</a></li>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>管理请假状态</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/attendanceStatus/list"><i class="fa fa-circle-o"></i>查看请假状态列表</a></li>
                        <li><a href="${contextPath}/admin/attendanceStatus/add"><i class="fa fa-circle-o"></i>添加考勤状态</a></li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>学生荣誉</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="${contextPath}/admin/honor/list"><i class="fa fa-circle-o"></i>查看所有学生荣誉</a></li>
                    <li><a href="${contextPath}/admin/honor/hint"><i class="fa fa-circle-o"></i>添加学生荣誉</a></li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-users"></i> <span>学生管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/admin/student/list"><i class="fa fa-circle-o"></i>查看用户列表</a></li>
                    <li><a href="${contextPath}/admin/student/addStudent"><i class="fa fa-circle-o"></i>添加学生</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-users"></i> <span>老师管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/admin/teacher/list"><i class="fa fa-circle-o"></i>查看老师列表</a></li>
                    <li><a href="${contextPath}/admin/teacher/addTeacher"><i class="fa fa-circle-o"></i>添加老师</a></li>
                </ul>
            </li>


            <li class="treeview">
                <a href="#"><i class="fa fa-user"></i> <span>管理员管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/admin/admin/list"><i class="fa fa-circle-o"></i>查看管理员列表</a>
                    </li>
                    <li><a href="${contextPath}/admin/admin/addAdmin"><i class="fa fa-circle-o"></i>添加管理员</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>