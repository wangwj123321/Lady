<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                	<a href="servlet/UserServlet?opr=UserInfo">个人资料</a>
                	<ul id="quar">
                		<li><a href="servlet/UserServlet?opr=UserInfo">个人信息</a></li>
                		<li><a href="servlet/AddressServlet?opr=getAllAddress">我的收货地址</a></li>
                		<li><a href="servlet/UserServlet?opr=showModifyUser">个人信息修改</a></li>
                		<!-- <li><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4&order=ASC">冬季</a></li> -->
                	</ul>
                </li>
                <li><a href="servlet/CollectServlet?opr=getListCollect" target="_blank">我的收藏</a></li>
                <li>${loginUser }，<a href="servlet/UserServlet?opr=exitLogin">退出登录</a></li>
            </ul>
        </div>
    </div>
<div id="right">
	<table id="tab">
      <form action="servlet/AddressServlet?opr=addNotAjax" id="aa" method="post">
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
              <td><input type="submit" id="addBtu" value=""/></td>
          </tr>
      </form>
	</table>
</div>    

</body>
</html>