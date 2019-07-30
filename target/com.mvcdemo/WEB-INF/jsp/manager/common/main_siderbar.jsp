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
                <p>用户名</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单</li>
            <li><a href="#"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview">
                <a href="#"><i class="fa fa-folder"></i> <span>文章管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i>发布文章</a>
                    </li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>文章列表</a>
                    </li>
                </ul>
            </li>


            <li class="treeview">
                <a href="#"><i class="fa fa-file-text-o"></i> <span>项目管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--${--%>
                    <li><a href="#"><i class="fa fa-circle-o"></i>发布申报项目</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>查看已发布项目</a>
                    </li>
                </ul>
            </li>


            <li class="treeview">
                <a href="#"><i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/manager/admin/user/list"><i class="fa fa-circle-o"></i>查看用户列表</a></li>
                    <li><a href="${contextPath}/manager/admin/user/addUser"><i class="fa fa-circle-o"></i>添加新用户</a></li>
                    <li><a href="${contextPath}/manager/admin/user/userpowerlist"><i class="fa fa-circle-o"></i>用户权限管理</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-laptop"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/manager/system/notifications/sentTips"><i class="fa fa-circle-o"></i>发布通知</a></li>
                    <li><a href="${contextPath}/manager/system/notifications/notificationsList"><i class="fa fa-circle-o"></i>通知列表</a></li>
                </ul>
            </li>


            <li class="treeview">
                <a href="#"><i class="fa fa-user"></i> <span>个人中心</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${contextPath}/manager/user/currentuser/message_list"><i class="fa fa-circle-o"></i>查看通知</a>
                    </li>
                    <li><a href="${contextPath}/manager/user/currentuser/center"><i class="fa fa-circle-o"></i>查看个人信息</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>