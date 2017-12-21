<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="side_right col-1">
    <ul>
        <li><i>我的账户</i><a href="servlet/UserServlet?opr=isLogin"><span class="fa fa-user-circle-o"></span></a></li>
        <li><form action="servlet/ProductServlet?opr=getListProduct&key=productName&order=ASC" method="post"><input type="text" class="small" placeholder="输入您喜欢的商品" name="value"><button type="submit" class="fa fa-search"></button></form><a><span class="fa fa-search-plus fa-lg"></span></a></li>
        <li><i>购物车</i><a href="servlet/BuyCarServlet?opr=getUserCar&userAccount=${userAccount }"><span class="fa fa-cart-plus"></span></a></li>
        <li><i>收藏</i><a href="servlet/CollectServlet?opr=getListCollect"><span class="fa fa-heart-o"></span></a></li>
        <li><i>签到送积分</i><a href=""><span class="fa fa-pencil-square-o"></span></a></li>
        <li><i>在线客服</i><a href=""><span class="fa fa-envelope-o"></span></a></li>
        <li><i>浏览历史</i><a href="servlet/ProductServlet?opr=history"><span class="fa fa-history"></span></a></li>
    </ul>
</div>