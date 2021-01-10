<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/top.css">
	

  </head>
  
  <body>
   			<div id="top">
   				<c:if test="${empty user}">
   					<div><a href="<%=path%>/login/ll">[登录]</a><a href="<%=path%>/login/rr">[注册]</a></div>
					</c:if>

				<div><a href="<%=path%>/cart/list">[我的购物车]</a><a href="#">[我的订单]</a><a href="${root}/user/logout">退出</a></div>
			</div>
			<div id="top-menu">
				<ul type="none">
					<li>首页</li>
					<li>最新登录</li>
					<li>PC平台</li>
					<li>PS平台</li>
					<li>Xbox平台</li>
					<li>PSP平台</li>
					<li>NDS平台</li>
					<li>任天堂游戏</li>
				</ul>
			</div>
  </body>
</html>
