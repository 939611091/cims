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
        <jsp:include page="../common/teacher_header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="../common/teacher_siderbar.jsp"/>

         <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                修改个人信息
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>个人中心</a></li>
                <li class="active">修改个人信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content ">
            <div class="callout callout-info">
                <h4>注意！</h4>
                <p>若不需要修改密码，则无需再密码输入框中填写内容。</p>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">修改个人信息</h3>
                            &nbsp&nbsp&nbsp
                            <h3 class="box-title">${msgError}${msgSuccess}</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="${contextPath}/teacher/edit.do" method="post" id="edit_user" enctype="multipart/form-data"  >
                            <div class="box-body">
                                <input type="hidden" name="teacherId" value="${teacher.teacherId }" />
                                <input type="hidden" name="tPhoto" value="${teacher.tPhoto }" />
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
                                        <input type="text" class="form-control"  placeholder="真实姓名"  name="name" value="${teacher.name }">
                                    </div>
                                </div>
                                 
                                <div class="form-group" id="phone">
                                    <label  class="col-sm-2 control-label">电话</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  name="phone" value="${teacher.phone }">
                                    </div>
                                </div>
                                 <div class="form-group" id="tDescription">
                                    <label  class="col-sm-2 control-label">老师简介</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control"  name="tDescription" placeholder="老师简介" >${teacher.tDescription }</textarea>
                                    </div>
                                </div>
                                <div class="form-group" id="tPhoto">
                                    <label  class="col-sm-2 control-label">老师照片</label>
                                    <div class="col-sm-8">
                                        <input type="file"     name = "fil" /> ${msg}<br>
                                    </div>
                                </div>
                                <div class="form-group" id="showPhoto">
                                    <label  class="col-sm-2 control-label">目前照片</label>
                                    <div class="col-sm-8">
                                        <img src="http://localhost:8080/${teacher.tPhoto}" width="200" height="350" />
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">保存</button>
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
    <!-- iCheck 1.0.1 -->
    <script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
    <!-- Select2 -->
    <script src="${contextPath}/resources/bower_components/select2/dist/js/select2.full.min.js"></script>
    <!-- editormd -->
    <script src="${contextPath}/resources/bower_components/editor.md/src/editormd.js"></script>
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