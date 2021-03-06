<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
<script type="text/javascript">
	$(document).ready(function(){
		$("#pay_btn").click(function(){
			var id=$("[name='id']").val();
			var total=Number($("#total").text());
			var str=prompt("请输入金额:");
			var money=Number(str);
			if(!money){
				alert("请正确输入金额");
			}else{
				if(money>=total){
					alert("支付成功！谢谢惠顾");
					location.href="servlet/OrderServlet?opr=updateOrderStatus&id="+id+"&status=1";
				}else{
					alert("金额不足");
				}
			}
		});
	});
</script>
</head>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
    	<div class="title"><h3>完成支付</h3></div>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:545px">
            	 <div class="col-12" id="complete">
	       			 <div id="comp_img"><img class="img-fluid" src="images/comp.png" alt=""></div>
	       			 <div id="order_no">
	           			 <h2>订单已生成，请继续完成支付！</h2>
	           			 <p>订单编号：<span>${sessionScope.newOrder.orderNo } </span>支付金额：<b>￥<span>${sessionScope.newOrder.costPrice }</span></b></p>
	        		</div>
	    		</div>
			    <div class="col-12" id="ch_pay">
			        <p>你需要支付：<b>￥${sessionScope.newOrder.costPrice }</b>元，请选择：</p>
			        <div id="pay">
			            <img src="images/zfb.png" alt="">
			            <img src="images/wx.png" alt="">
			            <img src="images/xyyh.png" alt="">
			        </div>
			        <p>支付￥ <b id="total">${sessionScope.newOrder.costPrice }</b></p>
			        <p><a href="javascript:void(0)" id="pay_btn">支付</a></p>
			        <input type="hidden" name="id" value="${sessionScope.newOrder.id }">
			    </div>
        	</div>
		<%@include file="element_page/side_right.jsp" %>
       </div>
	<%@include file="element_page/footer.jsp" %>
   </div>
</div>
</body>
</html>