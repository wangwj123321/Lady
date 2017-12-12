<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productDetail.css">
</head>
<body>
	<div id="left">
		<div>
			<img src="images/logo.png" alt="">
		</div>
		<div id="side_bar">
			<ul>
				<li><a
					href="servlet/ProductServlet?opr=getListProduct&order=ASC">首页</a></li>
				<li><a href="">服装</a></li>
				<li id="quarter"><a href="">季度</a>
					<ul id="quar">
						<li><a
							href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=1&order=ASC">春季</a></li>
						<li><a
							href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=2&order=ASC">夏季</a></li>
						<li><a
							href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=3&order=ASC">秋季</a></li>
						<li><a
							href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4&order=ASC">冬季</a></li>
					</ul></li>
				<li><a href="">潮流新宠</a></li>
				<li><a href="">积分商城</a></li>
			</ul>
		</div>
	</div>
	<div id="pro_img">
		
	</div>
</body>
</html>