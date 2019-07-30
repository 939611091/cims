<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<%--%
    User user = (User)session.getAttribute(Const.CURRENT_USER);
    if(user != null){
        if(user.getRole() >= Const.Role.ROLE_CUSTOMER){
            response.sendRedirect("/xianji");
        }
    }
%>--%>

<html>
<head>
    <meta charset="utf-8">
    <title>管理员登录 - 欢迎登陆</title>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/login/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/login/css/my-login.css">
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="${contextPath}/resources/dist/img/logo_login.jpg">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">管理员登录</h4>
                        <c:if test="${msg != null}">
                            <div class="alert alert-danger" role="alert">
                                    ${msg}
                            </div>
                        </c:if>
                        <form method="POST" action="${contextPath}/admin/login.do">

                            <div class="form-group">
                                <label for="username">用户名</label>

                                <input id="username" type="text" class="form-control" name="username" >
                            </div>

                            <div class="form-group">
                                <label for="password">密码
                                    <a href="#" class="float-right">
                                        若忘记密码，请和管理员联系
                                    </a>
                                </label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> 记住密码
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    登&nbsp;&nbsp;&nbsp;&nbsp;录
                                </button>
                            </div>
                            <%--<div class="margin-top20 text-center ">--%>
                                <%--还没有账号?&nbsp;&nbsp;<a href="${contextPath}/home/user/register">立即注册</a>--%>
                            <%--</div>--%>
                        </form>
                    </div>
                </div>
                <div class="footer">
                    Copyright &copy; CIMS
                </div>
            </div>
        </div>
    </div>
</section>

<!-- jQuery 3 -->
<script src="${contextPath}/resources/bower_components/login/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${contextPath}/resources/bower_components/login/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/bower_components/login/js/popper.js"></script>
<script src="${contextPath}/resources/bower_components/login/js/my-login.js"></script>
</body>
</html>
