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
<title>个人信息管理</title>
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
<link rel="stylesheet" href="css/userMain.css">
<link rel="stylesheet" href="css/common.css">
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
</head>
<%
	String loginUser=(String)session.getAttribute("loginUser");
	if(loginUser==null){
		response.sendRedirect("login.jsp");
	}
%>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:540px">
            <c:if test="${not empty orderList }">
    	<c:forEach items="${orderList }" var="order">
    	<table class="table table-bordered">
		    <thead>
		        <tr>
		            <th>订单号</th>
		            <th>总价</th>
		            <th>状态</th>
		            <th>操作</th>
		        </tr>
		    </thead>
		    <tbody>
		        <tr>
		            <td>${order.orderNo }</td>
		            <td>${order.costPrice }</td>
		            <td>
		            	<c:if test="${order.status == 0 }">未支付</c:if>
   						<c:if test="${order.status == 1 }">已支付</c:if>
   						<c:if test="${order.status == 2 }">未发货</c:if>
   						<c:if test="${order.status == 3 }">已发货</c:if>
   						<c:if test="${order.status == 4 }">已收货</c:if>
		            </td>
		            <td>
		            	<table class="table table-bordered">
		            		<thead>
		            			<tr><th>图片</th><th>商品名称</th><th>颜色</th><th>尺寸</th><th>单价</th><th>数量</th><th>订单详情</th></tr>
		            		</thead>
		            		<tbody>
            				<c:forEach items="${order.user_Orders }" var="orderDetail">
            					<tr>
            						<td><img alt="" class="imgs" src="images/${orderDetail.picpath }"></td>
            						<td>${orderDetail.productName }${orderDetail.productNo }</td>
            						<td>${orderDetail.colorName }</td>
            						<td>${orderDetail.sizeName }</td>
            						<td>${orderDetail.tagPrice }</td>
            						<td>${orderDetail.count }</td>
            						<td><a href="servlet/OrderServlet?opr=OrderDetail&id=${orderDetail.id }" >查看详情</a></td>
            					</tr>
            				</c:forEach>
		            		</tbody>
		            	</table>
		            </td>
		        </tr>
		    </tbody>
		</table>
		</c:forEach>
    </c:if>
    	<c:if test="${not empty orderDetail }">
        <table class="table table-bordered">
      		<thead>
      			<tr><th>订单号</th><th>图片</th><th>商品名称</th><th>颜色</th><th>尺寸</th><th>单价</th><th>数量</th><th>总价</th><th>送货地址</th><th>收货人</th><th>收货电话</th></tr>
      		</thead>
      		<tbody>
				<tr>
					<td>${orderDetail.orderNo }</td>
					<td><img class="imgs" src="images/${orderDetail.picpath }"></td>
					<td>${orderDetail.productName }</td>
					<td>${orderDetail.colorName }</td>
					<td>${orderDetail.sizeName }</td>
					<td>${orderDetail.tagPrice }</td>
					<td>${orderDetail.count }</td>
					<td>${orderDetail.amount }</td>
					<td>${orderDetail.address }</td>
					<td>${orderDetail.name }</td>
					<td>${orderDetail.phone }</td>
				</tr>
      		</tbody>
      	</table>
    	</c:if>
    	<c:if test="${not empty user }">
    	    <table class="table table-bordered">
	      		<thead>
	      			<tr><th>登录名</th><th>真实名</th><th>邮箱</th><th>状态</th></tr>
	      		</thead>
	      		<tbody>
					<tr>
						<td>${user.userAccount }</td>
						<td>${user.userName }</td>
						<td>${user.email }</td>
						<td>
							<c:if test="${user.status == 0 }">未激活</c:if>
							<c:if test="${user.status == 1 }">激活</c:if>
							<c:if test="${user.status == 2 }">冻结</c:if>
						</td>
					</tr>
	      		</tbody>
	      	</table>
    	</c:if>
    	<c:if test="${not empty allAddress }">
    		<table class="table table-bordered">
	      		<thead>
	      			<tr><th>名字</th><th>地址</th><th>电话</th><th>是否默认</th><th>操作</th></tr>
	      		</thead>
	      		<tbody>
    			<c:forEach items="${allAddress }" var="address">
					<tr>
						<td>${address.name }</td>
						<td>${address.address }</td>
						<td>${address.phone }</td>
						<td>
	    					<c:if test="${address.isDefault == 1 }">默认地址</c:if>
	    					<c:if test="${address.isDefault == 0 }">不是默认</c:if>
						</td>
						<td>
							<a href="servlet/AddressServlet?opr=deleteAddress&id=${address.id }">删除</a>
	    					<a href="servlet/AddressServlet?opr=modifys&id=${address.id }">修改</a>
						</td>
					</tr>
					</c:forEach>
	      		</tbody>
			</table>
			<div><a href="addaddress.jsp"><strong>添加地址</strong></a></div>
    	</c:if>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>