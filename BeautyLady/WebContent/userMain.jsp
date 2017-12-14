<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String loginUser=(String)session.getAttribute("loginUser");
	if(loginUser==null){
		response.sendRedirect("login.jsp");
	}
%>
<body>
	<h1 align="center">欢迎您，${loginUser }</h1>
	<p><a href="servlet/UserServlet?opr=exitLogin">退出登陆</a></p>
</body>
</html>