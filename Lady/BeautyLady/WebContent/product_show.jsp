<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${ctx}/js/product_show.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<title>商品详情页</title>
</head>
<body>
<div id="container">
	<ul>
		<li>商品</li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Category')">大类</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'SubClasses')">小类</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Color')">颜色</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Size')">尺码</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Band')">波段</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Theme')">主题</a></li>
		<li><a href="javascirpt:void(0)" onclick="initProduct(1,'Series')">系列</a></li>
	</ul>
</div>
<table border="1" width="1000px"id="goodList">
</table>
<span id="changePage"></span>
</body>
</html>