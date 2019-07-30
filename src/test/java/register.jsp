<%--
  Created by IntelliJ IDEA.
  User: jia
  Date: 2019/7/22
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传图片测试</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/addUser" method="post" enctype="multipart/form-data">
    用户名：<input type = "text"  name = "username" /><br>
    图片： <input type="file"     name = "fil" /> ${msg}<br>
    <input type = "submit" value = "提交">
</form>

</body>
</html>

