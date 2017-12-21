<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-3.2.1.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="js/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>

<!--导入font-awesome 图标字体库-->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- 本页面css文件 -->
<link rel="stylesheet" href="css/collect.css">
<link rel="stylesheet" href="css/common.css">
<!-- 本页面js文件 -->
<style rel="stylesheet" >
	#reg{
		position:absolute;
		left:0;
		right:0;
	}
	#reg input{
		width:400px;
		margin:0.4rem 0;
	}
</style>
<script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/collect.js"></script>
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
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
    	<div class="title"><h3>用户信息修改</h3></div>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:545px">
			  <form action="servlet/UserServlet?opr=modifyUser&id=${sessionScope.modifyOneUser.id }" id="reg" method="post">
				<div><input type="text" name="userAccount" placeholder="登录名" value="${sessionScope.modifyOneUser.userAccount }" readonly="readonly" required /></div>
				<div><input type="text" name="userName" placeholder="用户名" required value="${sessionScope.modifyOneUser.userName }"  /></div>
				<div><input type="password" name="oldpwd" placeholder="原密码" required  /></div>
				<div><input type="password" name="pwd" placeholder="新密码" required  /></div>
				<div><input type="password" name="repwd" placeholder="确认密码" required /></div>
				<div><input type="text" name="email" placeholder="邮箱" required  value="${sessionScope.modifyOneUser.email }" /></div>
				<div><input type="submit" value="注册" /></div>
				<div id="hint">${requestScope.hint }</div>
			  </form>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>