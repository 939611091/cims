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

    <title>打印报名缴费单</title>

    <%-- 后台必须有的CSS--%>
    <jsp:include page="../common/required_css.jsp"/>

</head>
<body>
<div class="container">
    <table class="table table-condensed">
        <tbody><tr>
            <td class="text-center"><h3>课程信息管理系统报名缴费单</h3></td>
        </tr>
        <tr>
            <td>所属学生：${apply_payVo.student.name }</td>
        </tr>
        </tbody></table>

    <table class="table table-condensed">
        <colgroup>
            <col width="50%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
        </colgroup>

        <tbody>
        <tr>
            <th colspan="2">
                <b>报名缴费号：${apply_payVo.id }</b>
            </th>
            <th colspan="4" class="text-right">
                <b>报名时间：<fmt:formatDate value="${apply_payVo.createTime}"
                                        pattern="yyyy年MM月dd日 HH:mm:ss"/></b>
            </th>
        </tr>

        <tr>
            <th>课程名称</th>
            <th>课程ID</th>
            <th>课程课时</th>
            <th>课程价格</th>
        </tr>
        <tr>
            <td>
                <p>${apply_payVo.course.cName}</p>
            </td>
            <td>${apply_payVo.course.id}</td>
            <td>${apply_payVo.course.period}小时</td>
            <td>${apply_payVo.course.price}元</td>

        </tr>

        </tbody>
    </table>

    <table class="table table-condensed text-right">
        <tbody>
        <tr>
            <td>付款学生：${apply_payVo.payStudent }</td>
        </tr>
        <tr>
            <td>实付：${apply_payVo.payAmount}元</td>
        </tr>
        <tr>
            <td>支付时间:<fmt:formatDate value="${apply_payVo.payTime}"
                                     pattern="yyyy年MM月dd日 "/></td>
        </tr>
        </tbody></table>

    <table class="table table-condensed">
        <colgroup>
            <col>
            <col width="350px">
        </colgroup>

        <tbody><tr>
            <td>服务商：青少年兴趣培训机构</td>
            <td>报名热线：0771-5985666</td>
        </tr>
        <tr>
            <td>地址：南宁市西乡塘区青少年兴趣培训机构</td>
            <td>网站：http://www.cims.com</td>
        </tr>
        <tr>
            <td>学生用户名：${apply_payVo.student.username }</td>
            <td>初始密码：123456</td>
        </tr>
        <tr>
            <td>提示：可以登录我们的课程管理系统(localhost:8080/student/login)进行查看课程剩余学时，请假，查看课程详情等操作</td>
        </tr>
        </tbody></table>

    <input type="submit" class="btn btn-success btn-lg btn-block hidden-print" onclick="window.print();" value="打印">
</div>

</body>

<%--后台必要的JavaScript库--%>
<jsp:include page="../common/required_js.jsp"/>
<!-- END Import -->
</html>



