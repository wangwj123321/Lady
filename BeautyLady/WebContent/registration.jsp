<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册</title>
 <link rel="stylesheet" href="css/registration.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("[name='userAccount']").blur(function(){
			var userAccount = $("[name='userAccount']").val();
			$.get("servlet/UserServlet","opr=getUserByUserAccount&userAccount="+userAccount,function (data){
				if(data=="true"){
					$("#hint").html("该用户以存在，请使用别的用户名！");
				}else{
					$("#hint").html("");
				}
			},"html");
		});
		$("[name='email']").blur(function(){
			var email = $("[name='email']").val();
			$.get("servlet/UserServlet","opr=getUserByEmailt&email="+email,function (data){
				if(data=="true"){
					$("#hint").html("该邮箱以存在，请使用别的邮箱！");
				}else{
					$("#hint").html("");
				}
			},"html");
		});
		$("[name='repwd']").blur(function(){
			var pwd = $("[name='pwd']").val();
			var repwd = $("[name='repwd']").val();
			if(pwd != repwd){
				$("#hint").html("两次输入的密码不一样");
			}else {
				$("#hint").html("");
			}
		});
		$("#reg").submit(function(){
			if($("#hint").html() == ""){
				return true;
			}
			return false;
		});
 		$("#img").click(function(){
 			location.href="index.jsp";
 		});
	});
</script>
</head>
<body>
<img src="images/login_ochirly.jpg" id="img" />
<div id="backgrounds">
	<form action="servlet/RegServlet" method="post" id="reg">
		<div id="hint">${requestScope.hint }</div>
		<h5>新用户注册</h5>
		<div><input type="text" name="userName" placeholder="登录名" required /></div>
		<div><input type="text" name="userAccount" placeholder="用户名" required /></div>
		<div><input type="password" name="pwd" placeholder="密码" required /></div>
		<div><input type="password" name="repwd" placeholder="确认密码" required /></div>
		<div><input type="text" name="email" placeholder="邮箱" required /></div>
		<input type="submit" value="注册" />
		<div id="last"><a href="login.jsp">返回登录</a></div>
	</form>
</div>
</body>
</html>