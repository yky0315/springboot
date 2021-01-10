<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=path%>/login/go" method="post">
用户名<input type="text" name="loginname" placeholder="请输入登录名"><br>
密码<input type="text" name="pwd" placeholder="请输入登录名"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
