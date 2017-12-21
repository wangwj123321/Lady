<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>car1</title>
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
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/car1.css">
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/car1.js"></script>
</head>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
    	<div class="title"><h3>购物车</h3></div>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:545px">
            	 <div id="gwd"><img class="img-fulid" src="images/car1.png" alt=""><br>购物车</div>
            	 <p>优惠：单笔消费，满699元免邮</p>
            	<c:if test="${! empty list }">
				<div id="gw_details">
					<div>
						<table cellspacing="0" id="tab" border="1">
							<tr>
								<td width="250">商品名称</td>
								<td>颜色/尺码</td>
								<td>单价</td>
								<td>数量</td>
								<td>小计</td>
							</tr>
							<c:forEach var="detail" items="${list }" varStatus="status">
								<tr>
									<td width=""><input type="checkbox"
										style="margin-right: 10px" name="ch" class="${detail.id }"> <img
										src="images/${detail.picpath }" alt="">
										<p>${detail.productName }</p>
										<p>${detail.productNo }</p></td>
									<td>${detail.colorName }/${detail.sizeName }</td>
									<td>￥<span>${detail.tagPrice }</span></td>
									<td><input type="number" min="1" max="10"
										value="${detail.count }" class="${detail.id }"></td>
									<td>￥<span class="p_t">${detail.count*detail.tagPrice }</span></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<p id="choose" style="margin-top: 20px">
						<input type="checkbox" style="margin-right: 10px" id="allch">全选
						<span style="margin-left: 20px"><a id="del_ch">删除已选</a></span>
					</p>
					<div id="clearing">
						<span>已选：<span id="count">0</span>件
						</span><br> <span>总计金额(不含运费)：￥ <b>0</b></span><br> <a
							id="carClear"></a>
					</div>
				</div>
			</c:if>
				<c:if test="${empty list }">
					<div id="ko">
		       		 	购物车空空如也
		    		</div>
				</c:if>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>