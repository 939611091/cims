<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询管理员列表</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/adminlist.do" method="post">
<div class="tools">

	<ul class="toolbar">
		<li ><a href="${pageContext.request.contextPath }/add.do" ><span><img src="img/t01.png" /></span>添加</a></li>		
	</ul>
	<button type="button" class="btn btn-success">
		哈哈
	</button>
</div>
<table width="100%" border=1>
<tr>
	<td>管理员ID</td>
	<td>用户名</td>
	<td>密码</td>
	<td>创建时间</td>
	<td>修改时间</td>
	<td>操作</td>
</tr>
<c:forEach items="${adminList }" var="admin">
<tr>
	<td>${admin.adminId }</td>
	<td>${admin.username }</td>
	<td>${admin.password}</td>
	<td>${admin.createTime }</td>
	<td>${admin.updateTime }</td>
	<td>
		<%--<a href="${pageContext.request.contextPath }/findOrdersByid.do?id=${order.id}">修改</a>--%>
		<%--<a href="${pageContext.request.contextPath }/deleteOrdersByid.do?id=${order.id}">删除</a>--%>
	</td>

</tr>
</c:forEach>

</table>
</form>

</body>

</html>