<%--
  Created by IntelliJ IDEA.
  User: wangk
  Date: 2019/6/3
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="authentication"/>
<header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>C</b>MS</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Course</b>IMS22231</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Notifications Menu -->
<%--                <li class="dropdown notifications-menu">--%>
<%--                    <!-- Menu toggle button -->--%>
<%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
<%--                        <i class="fa fa-bell-o"></i>--%>
<%--                        <span class="label label-warning">10</span>--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li class="header">You have ${count} notifications</li>--%>
<%--                        <li>--%>
<%--                            <!-- Inner Menu: contains the notifications -->--%>
<%--                            <ul class="menu">--%>
<%--                                <li><!-- start notification -->--%>
<%--                                    <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a>--%>
<%--                                    <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a> <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a> <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a> <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a> <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a> <a href="#">--%>
<%--                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
<%--                                    </a>--%>


<%--                                </li>--%>
<%--                                <!-- end notification -->--%>
<%--                            </ul>--%>
<%--                        </li>--%>
<%--                        <li class="footer"><a href="#">查看全部通知</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
                <!-- User Account Menu -->
               

            </ul>
        </div>
    </nav>
</header>
