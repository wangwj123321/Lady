<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <%
    	Cookie[] cookies=request.getCookies();
    	for(Cookie cookie:cookies){
    		if(cookie.getName().equals("loginUser")){
    			session.setAttribute("loginUser", cookie.getValue());
    		}
    	}
    %>
<body>
    <div id="left">
        <div><img src="images/logo.png" alt=""></div>
        <div id="side_bar">
            <ul>
                <li><a href="servlet/ProductServlet?opr=getListProduct&order=ASC">首页</a></li>
                <li><a href="">服装</a></li>
                <li id="quarter">
                	<a href="">季度</a>
                	<ul id="quar">
                		<li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=1&order=ASC">春季</a></li>
                		<li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=2&order=ASC">夏季</a></li>
                		<li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=3&order=ASC">秋季</a></li>
                		<li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4&order=ASC">冬季</a></li>
                	</ul>
                </li>
                <li><a href="">潮流新宠</a></li>
                <li><a href="">积分商城</a></li>
            </ul>
        </div>
    </div>
    <div id="right">
        <div id="right_top">
        	<c:if test="${order=='ASC' }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=DESC">价格排序</a></c:if>
            <c:if test="${order=='DESC' }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=ASC">价格排序</a></c:if>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <form action="servlet/ProductServlet?opr=getListProduct&key=productName&order=ASC" id="search" method="post"><input type="text" placeholder="搜索您感兴趣的内容" name="value"><input type="submit" value="查找" style="display:inline-block;width:40px;text-align:center;height:24px"></form>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="servlet/ProductServlet?opr=getListProduct&order=ASC">全部 </a>|&nbsp;&nbsp;&nbsp;<a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=E&order=ASC">长外套 &nbsp;&nbsp;&nbsp;</a>| &nbsp;&nbsp;&nbsp;<a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=A&order=ASC">马夹</a> &nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;<a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=D&order=ASC">大衣</a>
        </div>
        <div id="list">
            <ul>
                <c:forEach var="product" items="${ProductPage.list }">
	                <li>
	                    <a href="servlet/ProductServlet?opr=productDetail&proId=${product.id }"><img src="images/${product.picpath }" alt=""></a>
	                    <p><a href="">${product.productName }</a></p>
	                    <p>￥${product.tagPrice}</p>
	                </li>
                </c:forEach>
            </ul>
            <div id="right_bottom">
            	<span>当前页：${ProductPage.pageNo }/${ProductPage.pageCount }</span>
            	<c:if test="${ProductPage.pageNo>1 }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=1">首页</a><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo-1}">上一页</a></c:if>
            	<c:if test="${ProductPage.pageNo<ProductPage.pageCount }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo+1}">下一页</a><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageCount}">尾页</a></c:if>
            </div>
        </div>
    </div>
    <div id="right_bar">
        <ul>
            <li><a href="servlet/UserServlet?opr=isLogin"><img src="images/user.png" alt=""></a></li>
            <li><a href=""><img src="images/cart.png" alt=""></a></li>
            <li><a href=""><img src="images/sign.png" alt=""></a></li>
            <li><a href=""><img src="images/favorite.png" alt=""></a></li>
            <li><a href=""><img src="images/search.png" alt=""></a></li>
        </ul>
    </div>
</body>
</html>