<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://mycompany.com"  prefix="myTag"%>
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
<link rel="stylesheet" href="css/productDetail.css">
<link rel="stylesheet" href="css/common.css">
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/productDetail/mag.css" />
<link rel="stylesheet" href="css/productDetail/default.css" />
<link rel="stylesheet" href="css/productDetail/index.css" />
</head>
<body>
<%@include file="element_page/header.jsp" %>
<%@include file="element_page/side_left.jsp" %>
<%@include file="element_page/side_right.jsp" %>
<div class="product_show row" style="margin:0 2rem 0 20%">
	<div class="col-8">
		<div class="img_top row">
			<c:forEach var="pics" items="${pics }">
				<%-- <c:if test="${pics.picpath ==  pics.productNo.concat('_m_1.jpg') || pics.picpath ==  pics.productNo.concat('_m_2.jpg') || pics.picpath ==  pics.productNo.concat('_m_3.jpg') || pics.picpath ==  pics.productNo.concat('_m_4.jpg')}">
					<div class="col-6"><img class="img-fluid img-thumbnail" src="images/${pics.productNo }/${pics.colorNo }/${pics.picpath }" /></div>
				</c:if> --%>
				<c:if test="${pics.picpath.indexOf('_m_1.jpg')>0 || pics.picpath.indexOf('_m_2.jpg')>0 || pics.picpath.indexOf('_m_3.jpg')>0 || pics.picpath.indexOf('_m_4.jpg')>0}">
					<div class="col-6"><img class="img-fluid img-thumbnail" src="images/${pics.productNo }/${pics.colorNo }/${pics.picpath }" /></div>
				</c:if>
			</c:forEach>
		</div>
		<p style="font-size:1.5rem">细节展示</p>
		<div class="img_section row">
					<c:forEach var="pics" items="${pics }">
				<c:if test="${pics.picpath.indexOf('_m_5.jpg')>0 || pics.picpath.indexOf('_m_6.jpg')>0 || pics.picpath.indexOf('_m_7.jpg')>0}">
					<div class="col-4"><img class="img-fluid" src="images/${pics.productNo }/${pics.colorNo }/${pics.picpath }" /></div>
				</c:if>
			</c:forEach>
		</div>
		<div class="img_bottom">
			<div class="out">
		        <div class="mag-eg-el-wrap img-fluid img-thumbnail">
		            <div class="proportion">
		                <div mag-thumb="inner" class="mag-eg-el">
		                    <c:forEach var="pics" items="${pics }">
						<c:if test="${pics.picpath.indexOf('_m_8.jpg')>0   }">
							<img class="img-fluid" src="images/${pics.productNo }/${pics.colorNo }/${pics.picpath }" />
						</c:if>
					</c:forEach>
		                </div>
		                <div mag-zoom="inner" class="mag-eg-el">
		                    <c:forEach var="pics" items="${pics }">
						<c:if test="${pics.picpath ==  pics.productNo.concat('_b_8.jpg')  }">
							<img class="img-fluid" src="images/${pics.productNo }/${pics.colorNo }/${pics.picpath }" />
						</c:if>
					</c:forEach>
		                </div>
		                <div class="filler"></div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
	<div class="col-4">
		<h4>${ext.subClassesName }</h4>
		<h5>编号 &nbsp;&nbsp;${ext.productNo }</h5>
		<p style="font-weight:bold;font-size:16px">￥${ext.tagPrice }</p>
		<br/>
		<br/>
		<form action="" method="post">
			<input type="hidden" name="tagPrice" value=${ext.tagPrice }>
			<input type="hidden" name="productNo" value=${ext.productNo }>
			颜色：&nbsp;&nbsp;
			<%-- <c:forEach var="color" items="${colors }" varStatus="status">
				${color.colorName }<input type="radio" name="colorNo" value="${color.colorNo }" <c:if test="${status.index==0 }">checked</c:if>>
			</c:forEach> --%>
			<myTag:getSplitName varNo="colorNo" strName="${ext.colorName }" symbol="," strNo="${ext.colorNo }" varName="colorName">
				${colorName }<input type="radio" name="colorNo" value="${colorNo }">
					<a href="servlet/ProductServlet?opr=productDetail&proNo=${ext.productNo }&colorNo=${colorNo }">
					<img class="img-fluid" src="images/${ext.productNo }/${colorNo }/${ext.productNo }_list_${colorNo}.jpg" />
					</a>>
			</myTag:getSplitName>
			<br/>
			<br/>
			<br/>
			<br/>
			尺码：&nbsp;&nbsp;
			<%-- <c:forEach var="size" items="${sizes }" varStatus="status">
				${size.sizeName }<input type="radio" name="sizeNo" value="${size.sizeNo }" <c:if test="${status.index==0 }">checked</c:if>>
			</c:forEach> --%>
			<myTag:getSplitName varNo="sizeNo" strName="${ext.sizeName }" symbol="," strNo="${ext.sizeNo }" varName="sizeName">
				${sizeName }<input type="radio" name="sizeNo" value="${colorNo }" <c:if test="${status.index==0 }">checked</c:if>>
			</myTag:getSplitName>
		</form>
		<div id="add_car">
			<a id="add_car"></a>
		</div>
	</div>
</div>
	<div id="add_car_hint">
		<h3>加入购物车成功</h3>
		<p>
			<a id="jxBuy"></a>
			<a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }" id="clearing"></a>
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
<script src="js/productDetail/jquery.bridget.js"></script>
<script src="js/productDetail/jquery.mousewheel.min.js"></script>
<script src="js/productDetail/PreventGhostClick.js"></script>
<script src="js/productDetail/mag.js"></script>
<script src="js/productDetail/mag-jquery.js"></script>
<script src="js/productDetail/index.js"></script>
</html>