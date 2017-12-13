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
		<img src="images/${product.picpath }"/>
	</div>
	<div id="right_content">
		<h4>${product.subClassesName }</h4>
		<h5>编号 &nbsp;&nbsp;${product.productNo }</h5>
		<p style="font-weight:bold;font-size:16px">￥${product.tagPrice }</p>
		<br/>
		<br/>
		<form action="" method="post">
			<input type="hidden" name="tagPrice" value=${product.tagPrice }>
			<input type="hidden" name="productNo" value=${product.productNo }>
			颜色：&nbsp;&nbsp;
			<c:forEach var="color" items="${colors }" varStatus="status">
				${color.colorName }<input type="radio" name="colorNo" value="${color.colorNo }" <c:if test="${status.index==0 }">checked</c:if>>
			</c:forEach>
			<br/>
			<br/>
			<br/>
			<br/>
			尺码：&nbsp;&nbsp;
			<c:forEach var="size" items="${sizes }" varStatus="status">
				${size.sizeName }<input type="radio" name="sizeNo" value="${size.sizeNo }" <c:if test="${status.index==0 }">checked</c:if>>
			</c:forEach>
		</form>
		<div id="add_car">
			<a id="add_car"></a>
		</div>
	</div>
	<div id="add_car_hint">
		<h3>加入购物车成功</h3>
		<p>
			<a id="jxBuy"></a>
			<a href="" id="clearing"></a>
		</p>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$("#add_car").click(function(){
		var colorNo=$("[name='colorNo']:checked").val();
		var sizeNo=$("[name='sizeNo']:checked").val();
		var tagPrice=$("[name='tagPrice']").val();
		var productNo=$("[name='productNo']").val();
/* 		alert(colorNo);
		alert(sizeNo); */
		$.get("servlet/BuyCarServlet","opr=addBuyCar&colorNo="+colorNo+"&sizeNo="+sizeNo+"&tagPrice="+tagPrice+"&productNo="+productNo,succ,"text");
		function succ(data){
			if(data=="true"){
				$("#add_car_hint").css("display","block");
			}else if(data=="noLogin"){
				location.href='login.jsp';
			}
		}
	});
	$("#jxBuy").click(function(){
		$(this).parent().parent().css("display","none");
	});
</script>
</html>