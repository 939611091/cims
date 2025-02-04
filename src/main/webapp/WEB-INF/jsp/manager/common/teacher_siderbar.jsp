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
                <p>${sessionScope.teacher.name}老师,我的ID：${sessionScope.teacher.teacherId}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单</li>
            <li><a href="${contextPath}/teacher/index"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>课程信息管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/teacher/course/list"><i class="fa fa-circle-o"></i>课程信息列表</a>
                    </li>
                    <li><a href="${contextPath}/teacher/course/addCourse"><i class="fa fa-circle-o"></i>录入课程信息</a>
                    </li>
                    <li><a href="${contextPath}/teacher/course/myList"><i class="fa fa-circle-o"></i>我的课程-考勤</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>请假管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/teacher/attendance/list"><i class="fa fa-circle-o"></i>请假信息管理</a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>个人中心</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/teacher/edit"><i class="fa fa-circle-o"></i>修改个人信息</a>
                    </li>
                </ul>
            </li>


        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>