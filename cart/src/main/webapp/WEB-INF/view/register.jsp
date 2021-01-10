<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.8.1.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>注册</h3>
<form action="<%=path%>/login/register" method="post">
    用户名 <input type="text" name="loginname" ><br>
    密码 <input type="password" name="pwd" ><br>
    手机号 <input type="number" name="phone" id="phone"><a onclick="sendMessage()">发送验证码</a><br>
    验证码 <input type="text" name="code" ><br>
    <input type="submit" value="提交"><br>
    <span>${msg}</span>
    <script>
        function sendMessage() {
           var pho= $("#phone").val()
            var url="<%=path%>/message/send?key="+pho;
            $.post(url,function (data) {
                if (data){
                    alert("发送成功")
                }
            })
        }
    </script>
</form>
</center>
</body>
</html>
