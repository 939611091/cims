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
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    课程信息管理
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">课程信息管理</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="callout callout-info">
                    <h4>提示！</h4>
                    <p>每个课程最多只能请两次假，三次及三次以上请假不给予退费！</p>
                    <p>只有批准状态为已批准和学生状态为未到课和处理状态为未处理的情况下才能退费</p>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">查询学生ID</h3>
                                <div class="form-group" id="realname">
                                    <div>
                                        <select class="form-control select2" style="width: 100%;" name="teacherId">
                                            <option value="-1" selected="selected" disabled>根据姓名查询</option>
                                            <c:forEach items="${studentList}" var="student">
                                                <option value="${student.studentId}">学生ID:${student.studentId},学生姓名:${student.name},家长姓名:${student.pName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">请假申请信息列表</h3>&nbsp&nbsp&nbsp&nbsp
                                <h3 class="box-title">${msgSuccess}${msgError}</h3>
                                <div class="box-tools pull-right">
                                    <form action="${contextPath}/admin/attendance/list" method="post" id="search">
                                        <input name="pageNum" value="1" hidden>
                                        <input name="pageSize" value="10" hidden>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" placeholder="根据学生Id" name="keyword" value="${params.get('keyword')}" >
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <button type="button" class="btn btn-default"
                                                onclick="location.href='${contextPath}/admin/attendance/list';">
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
                                                <td>学生名</td>
                                                <td>请假课程名</td>
                                                <td>负责老师</td>
                                                <td>老师电话</td>
                                                <td>请假原因</td>
                                                <td>请假时间</td>
                                                <td>老师批准状态</td>
                                                <td>学生到课状态</td>
                                                <td>处理状态</td>
                                                <td>操作</td>
                                            </tr>
                                            <c:forEach items="${pageResult.list}" var="attendanceVo">
                                            <tr align="center">
                                                <td>${attendanceVo.apply_pay.payStudent}</td>
                                                <td>${attendanceVo.courseName}</td>
                                                <td>${attendanceVo.teacher.name}</td>
                                                <td>${attendanceVo.teacher.phone}</td>
                                                <td>${attendanceVo.attendance_status.status}</td>
                                                <td><fmt:formatDate value="${attendanceVo.attendanceTime}"
                                                                    pattern="yyyy年MM月dd日"/></td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.teacherState == 0}">
                                                                <span class="label label-info badge-info">未批准</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.teacherState == 1}">
                                                                <span class="label label-success badge-success">批准</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.teacherState == 2}">
                                                                <span class="label label-danger badge-danger">不批准</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.studentState == 0}">
                                                                <span class="label label-info badge-info">未确认</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.studentState == 1}">
                                                                <span class="label label-success badge-success">未到课</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.studentState == 2}">
                                                                <span class="label label-danger badge-danger">到课</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="caption">
                                                        <c:choose>
                                                            <c:when test="${attendanceVo.state == 0}">
                                                                <span class="label label-success badge-success">未处理</span>
                                                            </c:when>
                                                            <c:when test="${attendanceVo.state == 1}">
                                                                <span class="label label-danger badge-danger">已退费</span>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                </td>

                                                <td class="mailbox-date">
                                                    <c:choose>
                                                        <c:when test="${attendanceVo.state == 0 && attendanceVo.teacherState == 1 && attendanceVo.studentState == 1}">
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-default" onclick="window.location='${contextPath}/admin/attendance/updateState.do?id=${attendanceVo.id}'">
                                                                    <i class="fa fa-fw fa-refresh"></i>退费
                                                                </button>
                                                            </div>
                                                        </c:when>
                                                        <c:when test="${attendanceVo.state == 1}">
                                                            <button type="button" class="btn btn-default"disabled>
                                                                已退费
                                                            </button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button" class="btn btn-default"disabled>
                                                                不满足退费条件
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>

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
                                                    <a href="${contextPath}/admin/attendance/list?pageNum=${pageResult.prePage}">上一页</a>
                                                </c:if>
                                                <c:if test="${!pageResult.hasPreviousPage}">
                                                    <span>上一页</span>
                                                </c:if>
                                            </li>
                                            <c:forEach items="${pageResult.navigatepageNums}" var="num">
                                                <li ${pageResult.pageNum == num ? "class='active'":""}>
                                                    <a href="${contextPath}/admin/attendance/list?pageNum=${num}">${num}</a>
                                                </li>
                                            </c:forEach>
                                            <li ${pageResult.hasNextPage? "":"class='disabled'"}>
                                                <c:if test="${pageResult.hasNextPage}">
                                                    <a href="${contextPath}/admin/attendance/list?pageNum=${pageResult.nextPage}">下一页</a>
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
                        <%--<!-- 模态框 -->--%>
                        <%--<div class="modal fade" id="myModal">--%>
                            <%--<div class="modal-dialog">--%>
                                <%--<div class="modal-content">--%>

                                    <%--<!-- 模态框头部 -->--%>
                                    <%--<div class="modal-header">--%>
                                        <%--<h4 class="modal-title">课程详情</h4>--%>
                                        <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                                    <%--</div>--%>

                                    <%--<!-- 模态框主体 -->--%>
                                    <%--<div class="modal-body">--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程名</label>--%>
                                            <%--<input type="text" class="form-control" id="cName" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cDescription">课程简介信息</label>--%>
                                            <%--<textarea class="form-control" id="cDescription" readonly></textarea>--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程类别</label>--%>
                                            <%--<input type="text" class="form-control" id="categoryName"  readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">上课老师</label>--%>
                                            <%--<input type="text" class="form-control" id="teacherName"  readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程人数</label>--%>
                                            <%--<input type="text" class="form-control" id="number" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程价格</label>--%>
                                            <%--<input type="text" class="form-control" id="price" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程课时</label>--%>
                                            <%--<input type="text" class="form-control" id="period" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程开始时间</label>--%>
                                            <%--<input type="text" class="form-control" id="beginTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程结束时间</label>--%>
                                            <%--<input type="text" class="form-control" id="overTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程上课时间</label>--%>
                                            <%--<input type="text" class="form-control" id="schoolTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">项目创建时间</label>--%>
                                            <%--<input type="text" class="form-control" id="createTime" readonly value="">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label for="cName">课程后一次修改时间</label>--%>
                                            <%--<input type="text" class="form-control" id="updateTime" readonly value="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<!-- 模态框底部 -->--%>
                                    <%--<div class="modal-footer">--%>
                                        <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>--%>
                                    <%--</div>--%>

                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- /.col -->--%>
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