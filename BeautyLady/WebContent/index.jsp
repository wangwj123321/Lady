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
    	Cookie[] cookies=request.getCookies();
    	for(Cookie cookie:cookies){
    		if(cookie.getName().equals("loginUser")){
    			session.setAttribute("loginUser", cookie.getValue());
    		}
    		if(cookie.getName().equals("userAccount")){
    			session.setAttribute("userAccount", cookie.getValue());
    		}
    	}
    %>
<body>
<%@include file="element_page/header.jsp" %>
<%@include file="element_page/side_left.jsp" %>
<div class="product-info row text-center">
 <c:forEach var="product" items="${ProductPage.list }">
	 <div class="col-6 col-md-4 col-lg-3 col-xl-3"><a href="servlet/ProductServlet?opr=productDetail&proId=${product.id }">
	 	<img class="img-fluid img-thumbnail" src="images/${product.picpath }" alt=""></a>
	 	<div>${product.productName }</div>
	 	<span class="price">￥${product.tagPrice}</span>
	 </div>
</c:forEach>
</div>
<%@include file="element_page/side_right.jsp" %>
<nav class="pagechange">
	<span>当前页：${ProductPage.pageNo }/${ProductPage.pageCount }</span>
	<c:if test="${ProductPage.pageNo>1 }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=1">首页</a><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo-1}">上一页</a></c:if>
    <c:if test="${ProductPage.pageNo<ProductPage.pageCount }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo+1}">下一页</a><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageCount}">尾页</a></c:if>
<!--     <ul class="pagination">
        <li>
            <button type="button"aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </button>
        </li>
        <li><button type="button">1</button></li>
        <li><button type="button">2</button></li>
        <li><button type="button">3</button></li>
        <li><button type="button">4</button></li>
        <li><button type="button">5</button></li>
        <li>
            <button type="button" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </button>
        </li>
    </ul> -->
</nav>
</body>
</html>