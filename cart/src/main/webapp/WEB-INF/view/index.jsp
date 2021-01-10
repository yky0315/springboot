<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/list-goods.css">
	<style type="text/css">
		*{
				margin: 0px auto;
				padding: 0px;
			}
			html,body{
				width: 1024px;
				height: 768px;
				background-color: #000000;
			}
			#content{
				margin: 0px auto;
				width: 100%;
			}
	</style>
	
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".goods").click(function(){
				var goodsId=$(this).attr("name")
				var url="<%=path%>/product/getPro?id="+goodsId;
				window.location.href=url;
			})
		})
	</script>
  </head>
  
  <body>
 <div id="content">
    	<jsp:include page="top.jsp"></jsp:include>
	    			<div id="list" align="center">
						<c:forEach items="${initProList}" var="g">
							<div class="goods" name="${g.id}">
									<img src="<%=path%>/resources/upload/${g.proimg}" />
									<p class="price">¥ <fmt:formatNumber pattern="#,###.00" value="${g.proprice}"></fmt:formatNumber></p>
									<a>${g.proname}</a>
									<hr>
									<a href="goods.html">${g.profullname}</a>
							</div>
						</c:forEach>
					</div>
  	</div>
  </body>
</html>
