<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史记录</title>
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
<script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/collect.js"></script>
</head>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
    	<div class="title"><h3>您最近浏览的历史</h3></div>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:545px">
            	<c:forEach var="history" items="${sessionScope.histroys }">
			        <div id="collect_list" class="col-12 col-md-6 col-lg-4 col-xl-3">
		                <a href="servlet/ProductServlet?opr=productDetail&productNo=${history.productNo }"><img class="img-fluid img-thumbnail" src="images/${history.picpath }" alt=""></a>
		                <p>${history.productName } ${history.productNo }</p>
		                <p>￥<span>${history.tagPrice }</span></p>
			        </div>
		        </c:forEach>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>