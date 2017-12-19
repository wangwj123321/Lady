<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/car2.css">
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
	input[type="submit"]{
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
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
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
	});
</script>
</head>
<body>
	<div id="left">
        <div><img src="images/logo.png" alt=""></div>
        <div id="side_bar">
            <ul>
                <li><a href="servlet/ProductServlet?opr=getListProduct&order=DESC">首页</a></li>
                <li><a href="servlet/OrderServlet?opr=getOrderByUser">我的订单</a></li>
                <li><a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }" target="_blank">我的购物车</a></li>
                <li id="quarter">
                	<a href="servlet/UserServlet?opr=UserInfo">个人资料</a>
                	<ul id="quar">
                		<li><a href="servlet/UserServlet?opr=UserInfo">个人信息</a></li>
                		<li><a href="servlet/AddressServlet?opr=getAllAddress">我的收货地址</a></li>
                		<li><a href="servlet/UserServlet?opr=showModifyUser">个人信息修改</a></li>
                		<!-- <li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4&order=ASC">冬季</a></li> -->
                	</ul>
                </li>
                <li><a href="servlet/CollectServlet?opr=getListCollect" target="_blank">我的收藏</a></li>
                <li>${loginUser }，<a href="servlet/UserServlet?opr=exitLogin">退出登录</a></li>
            </ul>
        </div>
    </div>
<div id="right">
  <form action="servlet/UserServlet?opr=modifyUser&id=${sessionScope.modifyOneUser.id }" id="reg" method="post">
	<div id="hint">${requestScope.hint }</div>
	<h5>用户修改</h5>userName
	<div><input type="text" name="userAccount" placeholder="登录名" value="${sessionScope.modifyOneUser.userAccount }" readonly="readonly" required /></div>
	<div><input type="text" name="userName" placeholder="用户名" required value="${sessionScope.modifyOneUser.userName }"  /></div>
	<div><input type="password" name="oldpwd" placeholder="原密码" required  /></div>
	<div><input type="password" name="pwd" placeholder="新密码" required  /></div>
	<div><input type="password" name="repwd" placeholder="确认密码" required /></div>
	<div><input type="text" name="email" placeholder="邮箱" required  value="${sessionScope.modifyOneUser.email }" /></div>
	<div><input type="submit" value="注册" /></div>
  </form>
</div>    

</body>
</html>