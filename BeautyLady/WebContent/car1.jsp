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
</head>
<link rel="stylesheet" href="css/car1.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/car1.js"></script>
	<body>
	    <div id="top"><a href="index.jsp"><img src="images/ochirly.png" alt=""></a>	<span>${loginUser } ,您好！&nbsp;&nbsp;<a href="servlet/UserServlet?opr=exitLogin">退出</a></span></div>
	    <div id="gwd"><img src="images/car1.png" alt=""><br>购物车</div>
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
				</span><br> <span>总计金额(不含运费)：￥ <b>0</b></span><br> <a href=""
					id="carClear"></a>
			</div>
		</div>
	</c:if>
	    
		
		<c:if test="${empty list }">
			<div id="ko">
       		 	购物车空空如也
    		</div>
		</c:if>
		
		<div id="fotter">
	        <h3>tyj有限公司</h3>
	        <p>隐私申明 联系我们</p>
	        <p>Copyright @ 2010-2017 广州赫基信息科技有限公司版权所有 增值电信业务经营许可证 粤B2-20100553 粤ICP备10229258-1号</p>
	    </div>
	</body>
</html>