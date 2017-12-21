<%@page import="cn.beautylady.dao.impl.UserDaoImpl"%>
<%@page import="cn.beautylady.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beauty Lady</title>
</head>
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
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/common.css">
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
    <%
    	if(session.getAttribute("userAccount")==null){
        	Cookie[] cookies=request.getCookies();
       		String loginUser="";
       		String userAccount="";
       		String pwd="";
       		if(cookies!=null){
            	for(Cookie cookie:cookies){
            		if(cookie.getName().equals("loginUser")){
            			loginUser=cookie.getValue();
            		}
            		if(cookie.getName().equals("userAccount")){
            			userAccount=cookie.getValue();
            		}
            		if(cookie.getName().equals("pwd")){
            			pwd=cookie.getValue();
            		}
            		User user=new UserDaoImpl().getUserByUserAccount(userAccount);
            		if(user!=null && user.getPassword().equals(pwd)){
            			session.setAttribute("loginUser", loginUser);
            			session.setAttribute("userAccount", userAccount);
            		}
            	}
       		}
    	}
    %>
<body class="container-fluid">
<div class="contain row text-center">
	<%@include file="element_page/side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
        <div class="main_info row">
            <div class="main_text row col-11 text-center">
				<%@include file="element_page/carousel.jsp" %>
				<%@include file="element_page/carousel.jsp" %>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>