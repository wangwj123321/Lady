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
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/userMain.css">
</head>
<%
	String loginUser=(String)session.getAttribute("loginUser");
	if(loginUser==null){
		response.sendRedirect("login.jsp");
	}
%>
<body>
	<div id="left">
        <div><img src="images/logo.png" alt=""></div>
        <div id="side_bar">
            <ul>
                <li><a href="servlet/ProductServlet?opr=getListProduct&order=DESC">首页</a></li>
                <li><a href="servlet/OrderServlet?opr=getOrderByUser">我的订单</a></li>
                <li><a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }" target="_blank">我的购物车</a></li>
                <li id="quarter">
                	<a href="servlet/UserServlet?opr=UserInfo">个人资料</a>
                	<ul id="quar">
                		<li><a href="servlet/UserServlet?opr=UserInfo">个人信息</a></li>
                		<li><a href="servlet/AddressServlet?opr=getAllAddress">我的收货地址</a></li>
                		<li><a href="servlet/UserServlet?opr=showModifyUser">个人信息修改</a></li>
                		<!-- <li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4&order=ASC">冬季</a></li> -->
                	</ul>
                </li>
                <li><a href="">我的收藏</a></li>
                <li><a href="">积分商城</a></li>
                <li>${loginUser }，<a href="servlet/UserServlet?opr=exitLogin">退出登录</a></li>
            </ul>
        </div>
    </div>
    <div id="right">
    <c:if test="${not empty orderList }">
    	<c:forEach items="${orderList }" var="order">
			<table class="tag" cellspacing="0">
				<tr class="tagfirst">
					<td id="td1" colspan="2">订单号：${order.orderNo }</td>
					<td>总价：${order.costPrice }</td>
   					<td>状态：
   						<c:if test="${order.status == 0 }">未发货</c:if>
   						<c:if test="${order.status == 1 }">已发货</c:if>
   						<c:if test="${order.status == 2 }">已收货</c:if>
   						<c:if test="${order.status == 3 }">已评价</c:if>
   					</td>
					<td>操作</td>
				</tr>
   				<c:forEach items="${order.user_Orders }" var="orderDetail">
   					<tr>
   						<td><img alt="" class="imgs" src="images/${orderDetail.picpath }"></td>
   						<td>
   							<div>商品名称：${orderDetail.productName } ${orderDetail.productNo }</div>
   							<div>颜色：${orderDetail.colorName } 尺寸：${orderDetail.sizeName }</div>
   						</td>
   						<td>单价：${orderDetail.tagPrice }</td>
   						<td>数量：${orderDetail.count }</td>
   						<td><a href="servlet/OrderServlet?opr=OrderDetail&id=${orderDetail.id }" >订单详情</a></td>
   					</tr>
   				</c:forEach>
			</table>
    	</c:forEach>
    </c:if>
    	<c:if test="${not empty orderDetail }">
    		<table class="tag" cellspacing="0">
    			<tr>
    				<td>订单号：</td>
    				<td>${orderDetail.orderNo }</td>
    			</tr>
    			<tr>
    				<td>图片：</td>
    				<td><img src="images/${orderDetail.picpath }"></td>
    			</tr>
    			<tr>
    				<td>颜色：</td>
    				<td>${orderDetail.colorName }</td>
    			</tr>
    			<tr>
    				<td>尺寸：</td>
    				<td>${orderDetail.sizeName }</td>
    			</tr>
    			<tr>
    				<td>商品名称：</td>
    				<td>${orderDetail.productName }</td>
    			</tr>
    			<tr>
    				<td>单价：</td>
    				<td>${orderDetail.tagPrice }</td>
    			</tr>
    			<tr>
    				<td>数量：</td>
    				<td>${orderDetail.count }</td>
    			</tr>
    			<tr>
    				<td>总价：</td>
    				<td>${orderDetail.amount }</td>
    			</tr>
    			<tr>
    				<td>送货地址：</td>
    				<td>${orderDetail.address }</td>
    			</tr>
    			<tr>
    				<td>收货人：</td>
    				<td>${orderDetail.name }</td>
    			</tr>
    			<tr>
    				<td>收货人电话：</td>
    				<td>${orderDetail.phone }</td>
    			</tr>
    		</table>
    	</c:if>
    	<c:if test="${not empty user }">
    		<table class="tag" cellspacing="0">
    			<tr>
    				<td>登录名：</td>
    				<td>${user.userAccount }</td>
    			</tr>
    			<tr>
    				<td>真实名：</td>
    				<td>${user.userName }</td>
    			</tr>
    			<tr>
    				<td>邮箱：</td>
    				<td>${user.email }</td>
    			</tr>
    			<tr>
    				<td>状态：</td>
    				<td>
						<c:if test="${user.status == 0 }">未激活</c:if>
						<c:if test="${user.status == 1 }">激活</c:if>
						<c:if test="${user.status == 2 }">冻结</c:if>
					</td>
    			</tr>
    		</table>
    	</c:if>
    	<c:if test="${not empty allAddress }">
    		<div style="margin-bottom:10px;"><a href="addaddress.jsp">添加地址</a></div>
    		<c:forEach items="${allAddress }" var="address">
    			<table class="tag" cellspacing="0">
	    			<tr>
	    				<td>名字：</td>
	    				<td>${address.name }</td>
	    			</tr>
	    			<tr>
	    				<td>地址：</td>
	    				<td>${address.address }</td>
	    			</tr>
	    			<tr>
	    				<td>电话：</td>
	    				<td>${address.phone }</td>
	    			</tr>
	    			<tr>
	    				<td>是否默认：</td>
	    				<td>
	    					<c:if test="${address.isDefault == 1 }">默认地址</c:if>
	    					<c:if test="${address.isDefault == 0 }">不是默认</c:if>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>操作：</td>
	    				<td>
	    					<a href="servlet/AddressServlet?opr=deleteAddress&id=${address.id }">删除</a>
	    					<a href="servlet/AddressServlet?opr=modifys&id=${address.id }">修改</a>
	    				</td>
	    			</tr>
    			</table>
    			<br>
    		</c:forEach>
    	</c:if>
    </div>
</body>
</html>