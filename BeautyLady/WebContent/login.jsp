<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- <link rel="stylesheet" href="css/login.css"> -->
</head>
<style type="text/css">
	body{
		margin: 0;
		padding: 0;
	}
	#img{
		cursor: pointer;
	}
	#backgrounds{
		position: absolute;;
		top: 30%;
		left:37.5%;
		width: 450px;
		padding: 10px 30px;
		background-color: white;
	}
	h5,div{
		margin: 10px 0;
	}
	input[type="text"],input[type="password"]{
		border: 0;
		background-color: #ebebe0;
		width: 420px;
		height: 25px;
		outline: none;
		text-indent: 5px;
	}
	input[type="button"]{
		width: 420px;
		height: 25px;
		background-color: black;
		border: 0;
		color: white;
	}
	a{
		text-decoration: none;
		color: black;
	}
	#last{
		text-align: right;
		margin: 0 35px 25px 0;
		font-size: 12px;
	}
	#hint{
		color: red;
	}
	#checkCode{
		width: 200px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("[name='userAccount']").blur(function(){
			var userAccount=$(this).val();
			var reg = new RegExp("@");
			if(userAccount!=""){
				if(reg.test(userAccount)){
					$.post("servlet/UserServlet","opr=getUserByEmailt&email="+userAccount,success,"html");
				}else{
					$.post("servlet/UserServlet","opr=getUserByUserAccount&userAccount="+userAccount,success,"html");
				}
			}
			function success(data){
				if(data=="false"){
					$("#hint").html("该用户不存在");
				}else{
					$("#hint").html("");
				}
			}
		});
 		$("[type='button']").click(function(){
			var userAccount=$("[name='userAccount']").val();
			var pwd=$("[name='pwd']").val();
			var checkCode=$("[name='checkCode']").val();
			if(userAccount=="" || pwd==""){
				$("#hint").html("用户名或者密码不能为空！");
			}else{
				$("#hint").html("");
			} 
			if($("#hint").html()==""){
				$("#ff").submit();	
			}
		}); 
 		$("#img").click(function(){
 			location.href="index.jsp";
 		});
	});
	function myReload() {  
	    document.getElementById("CreateCheckCode").src = document  
	            .getElementById("CreateCheckCode").src;
	             
	}
</script>
<body>
<img src="images/login_ochirly.jpg" id="img" />
<div id="backgrounds">
	<form action="servlet/UserServlet?opr=login" method="post" id="ff">
		<div id="hint"></div>
		<h5>新用户注册</h5>
				<div><input type="text" placeholder="邮箱地址/手机号码" name="userAccount" value="${userAccount }"></div>
                <div><input type="password" placeholder="密码" name="pwd"></div>
                <div id="cc">
                	<input name="checkCode" type="text" id="checkCode" title="验证码区分大小写"  
	                size="8" ,maxlength="4" placeholder="验证码"/>  
	            	<img src="PictureCheckCode" id="CreateCheckCode" align="middle">  
	            	<a href="" onclick="myReload()"> 看不清,换一个</a>
                </div>
			<input type="button" value="登陆">
		 <p><input type="checkbox" name="pass" value="true"><span style="color:grey;font-size:12px">15天免登陆</span></p>
		<div id="last"><a href="registration.jsp">我要注册</a></div>
	</form>
</div>
</body>
</html>