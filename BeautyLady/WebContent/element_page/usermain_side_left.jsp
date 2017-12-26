<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="side_left col-2">
        <div class="logo"><a href="index.jsp">Beauty <span>Lady</span></a></div>
        <div id="row_nav"  class="nav_menu">
            <div>
            <a href="javascript:void(0)">欢迎用户：${loginUser }</a>
           	<a href="servlet/UserServlet?opr=exitLogin">退出登录</a>
		      <a href="servlet/OrderServlet?opr=getOrderByUser">我的订单</a>
		      <a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }" target="_blank">我的购物车</a>
		      <a data-toggle="collapse" data-parent="#products" data-target="#self_info" href="javascript:void(0)">个人资料</a>
		      <div class="collapse" id="self_info">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="servlet/UserServlet?opr=UserInfo">个人信息</a></li>
		              <li class="nav-item"><a href="servlet/AddressServlet?opr=getAllAddress">我的收货地址</a></li>
		              <li class="nav-item"><a href="servlet/UserServlet?opr=showModifyUser">个人信息修改</a></li>
		          </ul>
		      </div>
		      <a href="servlet/CollectServlet?opr=getListCollect" target="_blank">我的收藏</a>
            </div>
        </div>
    </div>