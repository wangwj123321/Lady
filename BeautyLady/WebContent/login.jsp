<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("[name='userAccount']").blur(function(){
			var userAccount=$(this).val();
			if(userAccount!=""){
				$.get("servlet/UserServlet","opr=getUserByUserAccount&userAccount="+userAccount,success,"html");
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
	});
	function myReload() {  
	    document.getElementById("CreateCheckCode").src = document  
	            .getElementById("CreateCheckCode").src;
	             
	}
</script>
<body>
    <div id="login">
        <img src="images/login.png" alt="">
        <div id="center">
            <form action="servlet/UserServlet?opr=login" id="ff" method="post">
                <input type="text" placeholder="邮箱地址/手机号码" name="userAccount" value="${userAccount }">
                <input type="password" placeholder="密码" name="pwd"> 
                <div id="cc">
                	<input name="checkCode" type="text" id="checkCode" title="验证码区分大小写"  
	                size="8" ,maxlength="4" placeholder="验证码"/>  
	            	<img src="PictureCheckCode" id="CreateCheckCode" align="middle">  
	            	<a href="" onclick="myReload()"> 看不清,换一个</a>
                </div>
                <input type="button" value="">
                <p><input type="checkbox" name="pass" value="true"><span style="color:grey;font-size:12px">15天免登陆</span></p>
            </form>
            <p style="color:red;font-size:12px" id="hint">${hint }</p>
        </div>
    </div>
</body>
</html>