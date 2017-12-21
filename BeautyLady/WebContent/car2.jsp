<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="css/car2.css">
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/car2.js"></script>
</head>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
    	<div class="title"><h3>购物车</h3></div>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:545px">
            	 <div id="gwd"><img src="images/car2.png" alt=""><br></div>
            	 <p>订单确认</p>
	 <div id="order_left">
	        <div id="ab">
	            <h3>确定收货地址</h3>
	            <div class="ch_address sure" name="${defaultAddress.id }">
	                <p>姓名：${defaultAddress.name }</p>
	                <p>电话：${defaultAddress.phone }</p>
	                <p>地址：${defaultAddress.address }</p>
	            </div>
	            <div><a id="ch_dd_btn" name="true"></a><c:if test="${ empty  defaultAddress}"><span style="font-size:12px;color:red">请选择收货地址</span></c:if> </div>
	            <table id="tab">
	                <form action="servlet/AddressServlet?opr=addAdderss" id="aa">
	                    <tr>
	                        <td>姓名：</td>
	                        <td><input type="text" name="name"/></td>
	                    </tr>
	                    <tr>
	                        <td>电话：</td>
	                        <td><input type="text" name="phone"/></td>
	                    </tr>
	                    <tr>
	                        <td>地址：</td>
	                        <td><input type="text" name="address"/></td>
	                    </tr>
	                    <tr>
	                        <td></td>
	                        <td>设置默认地址 &nbsp;<input type="checkbox" name="isDefault" value="1"/></td>
	                    </tr>
	                    <tr>
	                        <td></td>
	                        <td><input type="button" id="addBtu"/></td>
	                    </tr>
	                </form>
	            </table>
	        </div>
	
	
	        <div id="car_details">
	            <h3>购买商品明细</h3>
	            <table id="tab_details">
	            	<c:forEach var="detail" items="${detailList }">
	            		<tr>
		                    <td><img src="images/${detail.picpath }" alt=""></td>
		                    <td>
		                        <p>${detail.productName }</p>
		                        <p>货号：${detail.productNo }</p>
		                        <p>颜色/尺码</p>
		                        <p>${detail.colorName }/${detail.sizeName }</p>
		                    </td>
		                    <td>
		                        <p>售价</p>
		                        <p>￥${detail.tagPrice }</p>
		                    </td>
		                    <td>
		                        <p>数量</p>
		                        <p>${detail.count }</p>
		                    </td>
		                    <td>
		                        <p>小计</p>
		                        <p>￥<span class="one_total">${detail.tagPrice*detail.count }</span></p>
		                    </td>
	                	</tr>
	            	</c:forEach>
	            </table>
	        </div>
	    </div>
	    <div id="order_right">
	        <div id="order_summary">
	            <h4>订单汇总</h4>
	            <p>商品总额：<span>￥<b id="total"></b></span></p>
	            <p>邮费：<span>￥<b>8.0</b></span></p>
	            <p>优惠金额：<span>￥<b id="youhui">0</b></span></p>
	            <p>实付金额：<span>￥<b id="costTotal">0</b></span></p>
	            <div id="add_order_btn"><a id="add_order_pu">提交订单</a></div>
	        </div>
	    </div>
	            </div>
				<%@include file="element_page/side_right.jsp" %>
	        </div>
			<%@include file="element_page/footer.jsp" %>
	    </div>
</div>
</body>
</html>