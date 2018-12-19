<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<style>
body {
	overflow: hidden;
	background: url(${pageContext.request.contextPath}/img/login.jpg) no-repeat;
	background-size: cover;
}

.div1 {
	background-color: rgb(0, 0, 0);
	opacity: 0.8;
	border-radius: 20px;
	box-shadow: 0px 0px 30px;
	height: 350px;
	width: 400px;
	margin: auto;
	position: relative;
	top: 150px;
	text-align: center
}

.tit {
	color: rgb(255, 255, 255);
	position: relative;
	top: 30px;
	font-size: 50px;
}

form {
	position: relative;
	top: 40px;
}

form .inp {
	height: 40px;
	width: 250px;
	margin: 0px 0px 2px 0px;
	BACKGROUND-COLOR: transparent;	
	border-left-width:0px;
	border-top-width:0px;
	border-right-width:0px;
	BORDER-BOTTOM: #ffffff 1px solid;
	COLOR: #ffffff;
}

.ack {
	width: 254px;
	height: 50px;
	background-color: aqua;
	border: 0px;
	border-radius: 5px;
}

.ack:hover {
	background-color: rgb(252, 169, 183);
	transition: all 0.5s;
}

.div2 {
	position: absolute;
	top: 30px;
	right: 150px;
	background-color: rgb(252, 169, 183);
	
	height: 40px;
	width: 80px;
	text-align: center;
}

.div3 {
	position: absolute;
	top: 30px;
	right: 60px;
	border: 0.5px solid white;
	height: 40px;
	width: 80px;
	text-align: center;
}

.a1 {
	text-decoration: none;
	position: absolute;
	top: 7px;
	left: 15px;
	font-size: 25px;
	font-family: 宋体;
	color: white;
}

.login_info {
	position: absolute;
	color: red;
	top: 290px;
	left: 145px;
	display:none;
} 
.signin_info {
	position: absolute;
	color: red;
	display: none;
	top: 328px;	
	left: 145px;
	
} 
</style>
</head>
<body >

	<div class="div1" id="LoginDiv">
		<h1 class="tit">登陆</h1>
		<form method="post" action="login" >
			<input class="inp" id="login_username" type="text"  placeholder="用户名">

			<input class="inp" style="position: relative; left: 2px;"
				id="login_password" type="password"  placeholder="密码"> <br>
			<input class="ack" type="button" value="登陆"  id="Loginbutton" >
		</form>
		<div class="login_info" id="login_name_empty">用户名不能为空</div>       
        <div class="login_info" id="login_name_error">用户名不存在</div>
        <div class="login_info" id="login_pw_empty">密码不能为空</div>
        <div class="login_info" id="login_pw_error">密码错误</div>
	</div>
	<div class="div1" id="SignInDiv" style="display: none">
		<h1 class="tit">注册</h1>
		<form method="post" action="signIn">
			<input class="inp" type="text" id="signin_username" placeholder="用户名">
			<input class="inp" type="password" id="signin_password" placeholder="密码">
			<input class="inp" style="position: relative; left: 2px;"
				type="password" id="signin_pw_second" placeholder="再次输入密码">
			<br> <input class="ack" type="button" value="注册" id="SignInbutton">
		</form>
		<div class="signin_info" id="signin_name_empty">用户名不能为空</div>
		<div class="signin_info" id="signin_name_error">用户名已存在</div>
		<div class="signin_info" id="signin_pw_empyt">密码不能为空</div>
		<div class="signin_info" id="signin_pw_error">两次输入的密码不一致</div>
	</div>
	<button class="div2" id="LoginAck">
		登陆
	</button>
	<button class="div3" id="SignInAck">
		注册
	</button>
</body>

</html>