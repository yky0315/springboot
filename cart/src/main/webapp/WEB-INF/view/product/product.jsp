<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
			*{
				margin: 0px auto;
				padding: 0px;
			}
			html,body{
				width: 1024px;
				height: 768px;
			}
			#context{
				margin: 0px auto;
				width: 100%;
				height: 100%;
			}
			#goods{
				width: 100%;
				
			}
			#main_img{
				width: 300px;
				height: 300px;
			}
			#goods_name{
				font-size: 20px;
				
			}
			#goods>div{
				float: left;
				margin-left: 50px;
			}
			#price{
				font-size: 20px;
				font-style: normal;
				color: red;
				margin-left: 10px;
			}
			#goods_info{
				width: 500px;
			}
			p{
				margin-top: 10px;
			}
			#div_price{
				margin-top: 50px;
				width: 500px;
				background-color: aliceblue;
				font-size: 10px;
				
			}
			#other{
				margin-top: 50px;
			}
			#cart{
				width: 170px;
				height: 60px;
				margin-top: 20px;
				background-color: orangered;
				color: #ccc;
			}
			.img{
				width:65px;
				height:60px;
				margin-left: 3px;
			}
		</style>
		<script type="text/javascript" src="<%=path%>/resources/js/jquery.min.js"></script>
		<script type="text/javascript">
			function changeImg(obj){
				var coverImgObj=document.getElementById("main_img");//封面图 img对象
				coverImgObj.src=obj.src;
			}
			
			$(function (){	
				$("#cart").click(function(){
					var productId=$("#proId").val();
					alert(productId)
					var url="<%=path%>/cart/add";
					$.post(url,
					{"id":productId},
					function(res){
						if(res.code==200){
							alert("添加成功!")
							return;
						}
					},
					'json')
				})	
				
			})
		</script>
  </head>
  
  <body>
    		<div id="context">
   ${product.profullname}
   	<a href="home.jsp">回到首页</a>|<a href="<%=path%>/resources/user/cart/list">浏览购物车</a>
			<div id="goods">
				<div id="goods_img">
					<img src="<%=path%>/resources/upload/${product.proimg}" id="main_img" /><br>
				</div>
				<div id="goods_info">
					<p id="goods_name">${product.desc}</p>
					<div id="div_price">
						售价:<span id="price">${product.proprice}</span> <a href="#">降价通知</a>
						单位:<span>个</span>
					</div>
					<div id="edit">
						<!-- 商品主键  隐藏域 -->
						<input type="hidden" value="${product.id}" id="proId"/>
						<input type="button" id="cart" value="加入购物车" />
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
