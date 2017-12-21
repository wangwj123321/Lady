<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- 本页面js文件 -->
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/addaddress.css">
</head>
<body class="container-fulid">
<div class="contain row text-center">
	<%@include file="element_page/usermain_side_left.jsp" %>
    <div class="main col-10">
    <%@include file="element_page/header.jsp" %>
        <div class="main_info row">
            <div class="main_text row col-11 text-center" style="min-height:390px">
			   <form action="servlet/AddressServlet?opr=modifyAddress&id=${sessionScope.modifyAddOne.id }" id="form" method="post">
           		<table id="tab" class="table">
					<tr>
		              <td>姓名：</td>
		              <td><input type="text" name="name" value="${sessionScope.modifyAddOne.name }"/></td>
		          </tr>
		          <tr>
		              <td>电话：</td>
		              <td><input type="text" name="phone" value="${sessionScope.modifyAddOne.phone }"/></td>
		          </tr>
		          <tr>
		              <td>地址：</td>
		              <td><input type="text" name="address" value="${sessionScope.modifyAddOne.address }"/></td>
		          </tr>
		          <tr>
		              <td></td>
		              <td>设置默认地址 &nbsp;<input type="checkbox" name="isDefault" value="1" <c:if test="${sessionScope.modifyAddOne.isDefault == 1 }">checked</c:if> /></td>
		          </tr>
		          <tr>
		              <td></td>
		              <td><input type="submit" id="addBtu" value=""/></td>
		          </tr>
				</table>
		      </form>
            </div>
			<%@include file="element_page/side_right.jsp" %>
        </div>
		<%@include file="element_page/footer.jsp" %>
    </div>
</div>
</body>
</html>