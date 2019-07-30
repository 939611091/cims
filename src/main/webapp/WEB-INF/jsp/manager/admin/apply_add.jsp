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
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/dist/css/alt/AdminLTE-select2.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${contextPath}/resources/bower_components/select2/dist/css/select2.min.css">

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
                录入报名缴费信息
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>报名缴费信息管理</a></li>
                <li class="active">录入报名缴费信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content ">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询学生ID</h3>&nbsp;&nbsp;&nbsp;
                            <h3 class="box-title">${msgError}${msg}</h3>
                            <div class="box-tools pull-right">
                                <form action="${contextPath}/admin/apply/addApply" method="post" id="search">
                                        <input name="pageNum" value="1" hidden>
                                        <input name="pageSize" value="10" hidden>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" placeholder="学生姓名" name="keyword"  value="${params.get('keyword')}">
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <button type="button" class="btn btn-success" onclick="searchArticles({})"><i class="fa fa-fw fa-search"></i>查询学生ID
                                        </button>
                                    </div>
                                </form>
                            </div>
                                <!-- /.box-tools -->
                        </div>
                        <c:if test="${params.get('keyword') != null}">
                        <div class="box-body no-padding">
                                <!-- /.modal -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <tbody>
                                            <tr align="center">
                                                <td>学生ID</td>
                                                <td>姓名</td>
                                                <td>家长电话</td>
                                                <td>家长姓名</td>
                                            </tr>
                                            <c:forEach items="${pageResult.list }" var="student">
                                            <tr align="center">
                                                <td>${student.studentId }</td>
                                                <td>${student.name}</td>
                                                <td>${student.pPhone}</td>
                                                <td>${student.pName}</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <!-- /.table -->

                                </div>
                                <!-- /.mail-box-messages -->
                        </div>
                        </c:if>
                        <!-- /.box-header -->
                        <div class="box box-info">
                            <div class="callout callout-info">
                                <h4>提示！</h4>
                                <p>学生ID，报名课程，报名课时，报名学生均不能为空</p>
                            </div>
                            <div class="box-header with-border">
                                <h3 class="box-title">录入报名缴费信息</h3>&nbsp;&nbsp;&nbsp;
                                <h3 class="box-title">${msgError}${msg}</h3>
                        <!-- form start -->
                        <form class="form-horizontal" action="${contextPath}/admin/apply/addApply.do" method="post" id="add_user" >
                            <div class="box-body">
                                <input type="hidden" name="id" value="${course.id }" />
                                 <div class="form-group" id="studentId">
                                    <label  class="col-sm-2 control-label">学生ID</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="学生ID" name="studentId">
                                    </div>
                                </div>
                                <div class="form-group" id="payStudent">
                                    <label  class="col-sm-2 control-label">缴费学生</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="缴费学生" name="payStudent">
                                    </div>
                                </div>
                                <div class="form-group" id="course">
                                    <label class="col-sm-2 control-label">报名课程名</label>
                                    <div class="col-sm-8">
                                        <select class="form-control select2" style="width: 100%;" name="courseId">
                                            <option value="-1" selected="selected" disabled>选择报名课程</option>
                                            <c:forEach items="${courseList}" var="courseList">
                                                <option value="${courseList.id}">${courseList.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                </div>
                                <div class="form-group" id="payAmount">
                                    <label  class="col-sm-2 control-label">缴费金额</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="缴费金额" name="payAmount">
                                    </div>
                                </div>
                                <div class="form-group" id="payTime">
                                    <label  class="col-sm-2 control-label">缴费时间</label>
                                    <div class="col-sm-8">
                                        <input type="date" class="form-control"  placeholder="缴费时间" name="payTime">
                                    </div>
                                </div>
                                <div class="form-group" id="hour">
                                    <label  class="col-sm-2 control-label">报名课时</label>
                                    <div class="col-sm-8">
                                        <input type="tel" class="form-control"  placeholder="购买课时" name="hour">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                            </div>
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
        <!-- /.control-sidebar -->
        <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
    </div>
    <!-- ./wrapper -->

    <!-- jQuery 3 -->
    <script src="${contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="${contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Slimscroll -->
    <script src="${contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="${contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="${contextPath}/resources/dist/js/adminlte.min.js"></script>
    <!-- iCheck -->
    <script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
    <!-- Page Script -->
    <!-- Select2 -->
    <script src="${contextPath}/resources/bower_components/select2/dist/js/select2.full.min.js"></script>

    <script src="${contextPath}/resources/dist/js/demo.js"></script>


    <script type="text/javascript">
        var testEditor;

        $(function () {
            $('.select2').select2();
            testEditor = editormd("content-editormd", {
                width: "100%",
                height: 640,
                syncScrolling: "single",
                saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
                path: "bower_components/editor.md/lib/",
                toolbarIcons : function() {
                    return [
                        "undo", "redo", "|",
                        "bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|",
                        "h1", "h2", "h3", "h4", "h5", "h6", "|",
                        "list-ul", "list-ol", "hr", "|",
                        "link", "reference-link", "image", "code", "preformatted-text", "code-block", "table", "datetime", "emoji", "html-entities", "pagebreak", "|",
                        "goto-line", "watch", "preview", "fullscreen", "clear", "search"
                    ]
                }

            });
            // 修复下滑位移
            testEditor.__proto__.setToolbarAutoFixed = function(fixed) {

                var state    = this.state;
                var editor   = this.editor;
                var toolbar  = this.toolbar;
                var settings = this.settings;

                if (typeof fixed !== "undefined")
                {
                    settings.toolbarAutoFixed = fixed;
                }

                var autoFixedHandle = function(){
                    var $window = $(window);
                    var top     = $window.scrollTop();
                    var main_sidebar = $(".main-sidebar")[0];
                    if (!settings.toolbarAutoFixed)
                    {
                        return false;
                    }

                    if (top - editor.offset().top > 10 && top < editor.height())
                    {
                        toolbar.css({
                            position : "fixed",
                            width    : editor.width() + "px",
                            left     : ($window.width() - editor.width()) / 2 + (($window.width() > 767)?(main_sidebar.clientWidth / 2): 0) + "px"
                        });
                    }
                    else
                    {
                        toolbar.css({
                            position : "absolute",
                            width    : "100%",
                            left     : 0
                        });
                    }
                };

                if (!state.fullscreen && !state.preview && settings.toolbar && settings.toolbarAutoFixed)
                {
                    $(window).bind("scroll", autoFixedHandle);
                }

                return this;
            };
            // 修复全屏功能
            testEditor.__proto__.fullscreen = function() {

                var _this            = this;
                var state            = this.state;
                var editor           = this.editor;
                var preview          = this.preview;
                var toolbar          = this.toolbar;
                var settings         = this.settings;
                var fullscreenClass  = this.classPrefix + "fullscreen";

                if (toolbar) {
                    toolbar.find(".fa[name=fullscreen]").parent().toggleClass("active");
                }

                var escHandle = function(event) {
                    if (!event.shiftKey && event.keyCode === 27)
                    {
                        if (state.fullscreen)
                        {
                            _this.fullscreenExit();
                        }
                    }
                };

                if (!editor.hasClass(fullscreenClass))
                {
                    state.fullscreen = true;

                    // $("html,body").css("overflow", "hidden");
                    $("html,body").css("visibility", "hidden");
                    editor.css({
                        width    : $(window).width(),
                        height   : $(window).height()
                    }).addClass(fullscreenClass);

                    this.resize();

                    $.proxy(settings.onfullscreen, this)();

                    $(window).bind("keyup", escHandle);
                }
                else
                {
                    $(window).unbind("keyup", escHandle);
                    this.fullscreenExit();
                }

                return this;
            };
            // 修复退出全屏功能
            testEditor.__proto__.fullscreenExit = function() {

                var editor            = this.editor;
                var settings          = this.settings;
                var toolbar           = this.toolbar;
                var fullscreenClass   = this.classPrefix + "fullscreen";

                this.state.fullscreen = false;

                if (toolbar) {
                    toolbar.find(".fa[name=fullscreen]").parent().removeClass("active");
                }

                // $("html,body").css("overflow", "");
                $("html,body").css("visibility", "visible");

                editor.css({
                    width    : editor.data("oldWidth"),
                    height   : editor.data("oldHeight")
                }).removeClass(fullscreenClass);

                this.resize();

                $.proxy(settings.onfullscreenExit, this)();

                return this;
            };

        });
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