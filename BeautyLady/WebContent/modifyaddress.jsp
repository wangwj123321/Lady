<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/car2.css">
</head>
<body>
<div id="left">
        <div><img src="images/logo.png" alt=""></div>
        <div id="side_bar">
            <ul>
                <li><a href="servlet/ProductServlet?opr=getListProduct&order=DESC">首页</a></li>
                <li><a href="servlet/OrderServlet?opr=getOrderByUser">我的订单</a></li>
                <li><a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }" target="_blank">我的购物车</a></li>
                <li id="quarter">
                	<a href="">个人资料</a>
                	<ul id="quar">
                		<li><a href="servlet/UserServlet?opr=UserInfo">个人信息</a></li>
                		<li><a href="servlet/AddressServlet?opr=getAllAddress">我的收货地址</a></li>
                		<li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=3&order=ASC">个人信息修改</a></li>
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
	<table id="tab">
      <form action="servlet/AddressServlet?opr=modifyAddress&id=${sessionScope.modifyAddOne.id }" id="aa" method="post">
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
      </form>
	</table>
</div>    

</body>
</html>