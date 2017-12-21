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
            <div class="main_text col-11 text-center">
				<div class="pagechange">
					<nav class ="text-right">
						<ul class="pagination">
							<li>${ProductPage.pageNo }/${ProductPage.pageCount }</li>
							<c:if test="${ProductPage.pageNo >1}">
								<li>
									<a class="btn btn-sm btn-outline-secondary" aria-label="Previous" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo-1}">
							              <span aria-hidden="true">&laquo;</span>
							         </a>
						   	 	</li>
							</c:if>
						     <c:choose>
						     	 <c:when test="${ProductPage.pageCount <=5}">
									<c:forEach var="index" begin="1" end="${ProductPage.pageCount}">
										<li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${index }">${index}</a></li>
									</c:forEach>
								</c:when>
								<c:when test="${ProductPage.pageCount >5 && ProductPage.pageNo<4 }">
									<c:forEach var="index" begin="1" end="${ProductPage.pageNo+2 }">
										 <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${index }">${index}</a></li>
									</c:forEach>
									 <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageCount }">${ProductPage.pageCount }</a></li>
								</c:when>
								<c:when test="${ProductPage.pageCount >5 && ProductPage.pageNo>=4 && (ProductPage.pageNo+2<ProductPage.pageCount )}">
								     <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=1">1</a></li>
										<c:forEach var="index" begin="${ProductPage.pageNo-2}" end="${ProductPage.pageNo+2 }">
											 <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${index }">${index}</a></li>
										</c:forEach>
									 <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageCount }">${ProductPage.pageCount }</a></li>
								</c:when>
								<c:when test="${ProductPage.pageCount >5 && ProductPage.pageNo>=4 && (ProductPage.pageNo+2>=ProductPage.pageCount) }">
									<li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=1">1</a></li>
									<c:forEach var="index" begin="${ProductPage.pageNo-2}" end="${ProductPage.pageCount }">
										 <li><a class="btn btn-sm btn-outline-secondary" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${index }">${index}</a></li>
									</c:forEach>
								</c:when>
						     </c:choose>
						     <c:if test="${ProductPage.pageNo<ProductPage.pageCount }">
					             <li>
						            <a class="btn btn-sm btn-outline-secondary" aria-label="Next" href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=${order}&pageNO=${ProductPage.pageNo+1}">
						                <span aria-hidden="true">&raquo;</span>
						            </a>
						        </li>
						     </c:if>
						</ul>
					</nav>
				</div>
				<div class="product_info row">
	            	 <c:forEach var="product" items="${ProductPage.list }">
						 <div class="col-12 col-md-6 col-lg-4 col-xl-3"><a href="servlet/ProductServlet?opr=productDetail&proNo=${product.productNo }&colorNo=-1">
						 	<img class="img-fluid img-thumbnail" src="images/${product.picpath }" alt=""></a>
						 	<div>${product.productName }</div>
						 	<div>${product.productNo }</div>
						 	<span class="price">￥${product.tagPrice}</span>
						 </div>
					</c:forEach>
				</div>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>