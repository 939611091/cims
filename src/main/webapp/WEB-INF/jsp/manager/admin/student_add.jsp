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
        <section class="content-header">
            <h1>
                添加学生
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>学生管理</a></li>
                <li class="active">添加学生</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content ">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">添加学生</h3>&nbsp;&nbsp;&nbsp;
                            <h3 class="box-title">${msgError}</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="${contextPath}/admin/student/addStudent.do" method="post" id="add_user" >
                            <div class="box-body">
                                <div class="form-group" id="username">
                                    <label  class="col-sm-2 control-label">用户名</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="用户名" name="username">
                                    </div>
                                </div>
                                <div class="form-group" id="password">
                                    <label class="col-sm-2 control-label">密码</label>
                                    <div class="col-sm-8">
                                        <input type="password" id="pass" class="form-control" placeholder="密码" name="password">
                                    </div>
                                    <i style="margin-top: 11px;" state="off" class="fa fa-fw fa-eye" id="eye"></i>
                                </div>
                                <div class="form-group" id="name">
                                    <label  class="col-sm-2 control-label">姓名</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"  placeholder="姓名" name="name">
                                    </div>
                                </div>
                                <div class="form-group" id="pName">
                                    <label  class="col-sm-2 control-label">家长姓名</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="家长姓名" name="pName">
                                    </div>
                                </div>
                                <div class="form-group" id="pPhone">
                                    <label  class="col-sm-2 control-label">家长电话</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="家长电话" name="pPhone">
                                    </div>
                                </div>
                                <div class="form-group" id="school">
                                    <label  class="col-sm-2 control-label">所在学校</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="所在学校" name="school">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">添加学生</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                </div>
            </div>
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
    <!-- 用于ajax提交表单 -->
    <script src="${contextPath}/resources/bower_components/jquery-form/jquery.form.min.js"></script>
    <script type="text/javascript">

        //实现点击显示密码
        var password = document.getElementById("pass");
        var eye = document.getElementById("eye")
        eye.onclick = function () {
            var state = this.getAttribute("state");
            if(state === "off") {
                password.setAttribute("type", "text");
                eye.setAttribute("state", "on");
                eye.style.opacity = 0.2;
            } else {
                password.setAttribute("type", "password");
                eye.setAttribute("state", "off");
                eye.style.opacity = 1;
            }
        }
    </script>

</body>

</html>