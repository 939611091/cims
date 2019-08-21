<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>打印课程学生名单</title>

    <%-- 后台必须有的CSS--%>
    <jsp:include page="../common/required_css.jsp"/>

</head>
<body>
<div class="container">
    <table class="table table-condensed">
        <tbody>
        <tr>
            <td class="text-center"><h3>${course.cName}学生名单</h3></td>
        </tr>
        </tbody>
    </table>
    <table class="table table-condensed">
        <colgroup>
            <col>
            <col width="350px">
        </colgroup>

        <tbody>
        <tr>
            <td>课程开始时间:<fmt:formatDate value="${course.beginTime}"
                                       pattern="yyyy年MM月dd日 "/></td>
            <td>课程结束时间:<fmt:formatDate value="${course.overTime}"
                                       pattern="yyyy年MM月dd日 "/></td>
        </tr>
        <tr>
            <td>总学时:${course.period}小时</td>
            <td>每次上课学时:${course.cPeriod}小时</td>
        </tr>
        <tr>
            <td>上课老师:${teacher.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;老师签名：</td>
            <td>上课时间:${course.schoolTime}</td>
        </tr>
        </tbody>
    </table>

    <table id="example1" class="table table-bordered">
        <tbody>
        <tr align="center">
            <td>学生姓名</td>
            <td>家长电话</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
            <td>10</td>
        </tr>
        <c:forEach items="${apply_payVoList }" var="applyVo">
            <tr align="center">
                <td>${applyVo.student.name }</td>
                <td>${applyVo.student.pPhone }</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- /.table -->

    <input type="submit" class="btn btn-success btn-lg btn-block hidden-print" onclick="window.print();" value="打印">
</div>

</body>

<%--后台必要的JavaScript库--%>
<jsp:include page="../common/required_js.jsp"/>
<!-- END Import -->
</html>



