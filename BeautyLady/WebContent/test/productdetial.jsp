<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://mycompany.com" prefix="myTag"%>
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
<link rel="stylesheet" href="css/productDetail/bootstrap.min.css" />
<link rel="stylesheet" href="css/productDetail/mag.css" />
<link rel="stylesheet" href="css/productDetail/default.css" />
<link rel="stylesheet" href="css/productDetail/index.css" />
</head>
<body>
	<div id="left">
		<div>
			<img src="images/logo.png" alt="">
		</div>
		<div id="side_bar">
			<ul>
				<li><a
					href="servlet/ProductServlet?opr=getListProduct&order=DESC">首页</a></li>
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
		<ul class="linetwo">
			<c:forEach var="pics" items="${pics }">
				<c:if
					test="${pics.picpath ==  pics.productNo.concat('_m_1.jpg') || pics.picpath ==  pics.productNo.concat('_m_2.jpg') || pics.picpath ==  pics.productNo.concat('_m_3.jpg') || pics.picpath ==  pics.productNo.concat('_m_4.jpg')}">
					<img
						src="${pageContext.request.contextPath }/images/${pics.productNo }/${colorName }/${pics.picpath }" />
				</c:if>
			</c:forEach>
		</ul>
		<p class="text">细节展示</p>
		<ul class="linethree">
			<c:forEach var="pics" items="${pics }">
				<c:if
					test="${pics.picpath ==  pics.productNo.concat('_m_5.jpg') || pics.picpath ==  pics.productNo.concat('_m_6.jpg') || pics.picpath ==  pics.productNo.concat('_m_7.jpg') }">
					<img
						src="${pageContext.request.contextPath }/images/${pics.productNo }/${colorName }/${pics.picpath }" />
				</c:if>
			</c:forEach>
		</ul>
		<ul class="lineone">
			<!-- <div class="col col-md-5"> -->
			<div class="out">
				<div class="mag-eg-el-wrap img-thumbnail">
					<div class="proportion">
						<div mag-thumb="inner" class="mag-eg-el">
							<c:forEach begin="1" end="7">
								<c:if
									test="${product.picpath ==  product.productNo.concat('_m_8.jpg')   }">
									<img
										src="${pageContext.request.contextPath }/images/${product.productNo }/${colorName }/${product.picpath }" />
								</c:if>
							</c:forEach>
						</div>
						<div mag-zoom="inner" class="mag-eg-el">
							<c:forEach begin="1" end="4" varStatus="s">
								<%-- <c:if
									test="${product.picpath ==  product.productNo.concat('_b_8.jpg')  }"> --%>
									<img
										src="${pageContext.request.contextPath }/images/${product.productNo }/${colorName }/${product.productNo }_m_${s.count }.jpg" />
								<%-- </c:if> --%>
							</c:forEach>
						</div>
						<div class="filler"></div>
					</div>
				</div>
			</div>
		</ul>
	</div>
	<div id="right_content">
		<h4>${product.subClassesName }</h4>
		<h5>编号 &nbsp;&nbsp;${product.productNo }</h5>
		<p style="font-weight: bold; font-size: 16px">￥${product.tagPrice }</p>
		<br /> <br />
		<form action="" method="post">
			<input type="hidden" name="tagPrice" value=${product.tagPrice }>
			<input type="hidden" name="productNo" value=${product.productNo }>
			颜色：&nbsp;&nbsp;
			<myTag:split symbol="," str="${product.colorName}" var="color">
				<a
					href="${pageContext.request.contextPath}/servlet/getProductExtByProductNo?productNo=${product.productNo }&colorName=${color }">${color }</a>
			</myTag:split>
			<br /> <br /> <br /> <br /> 尺码：&nbsp;&nbsp;
			<myTag:split var="size" symbol="," str="${product.sizeName}">
				<a href="#">${size }</a>
			</myTag:split>
		</form>
		<div id="add_car">
			<a id="add_car"></a>
		</div>
	</div>
	<div id="add_car_hint">
		<h3>加入购物车成功</h3>
		<p>
			<a id="jxBuy"></a> <a
				href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }"
				id="clearing"></a>
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
<script src="js/productDetail/jquery.min.js"></script>
<script src="js/productDetail/jquery.bridget.js"></script>
<script src="js/productDetail/jquery.mousewheel.min.js"></script>
<script src="js/productDetail/PreventGhostClick.js"></script>
<script src="js/productDetail/mag.js"></script>
<script src="js/productDetail/mag-jquery.js"></script>
<script src="js/productDetail/index.js"></script>
</html>