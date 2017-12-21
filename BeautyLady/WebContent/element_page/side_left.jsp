<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <div class="side_left col-2">
        <div class="logo"><a href="index.html">Beauty <span>Lady</span></a></div>
        <div id="row_nav"  class="nav_menu">
            <div>
               <a href="servlet/ProductServlet?opr=getListProduct">所有商品</a>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#clothes" href="javascript:void(0)">服装</a>
		      <div class="collapse" id="clothes">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=E">长外套</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=A">马夹</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=D">大衣</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=T">套装</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=Y">连身裙</a></li>
		          </ul>
		      </div>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#tips" href="javascript:void(0)">配饰</a>
		      <div class="collapse" id="tips">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="#">手链</a></li>
		              <li class="nav-item"><a href="#">包包</a></li>
		              <li class="nav-item"><a href="#">腰带</a></li>
		              <li class="nav-item"><a href="#">头饰</a></li>
		          </ul>
		      </div>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#season" href="javascript:void(0)">季度</a>
		      <div class="collapse" id="season">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=1">春</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=2">夏</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=3">秋</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=QUARTER&value=4">冬</a></li>
		          </ul>
		      </div>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#other" href="javascript:void(0)">其他</a>
		      <div class="collapse" id="other">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=M">棉衣</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=A">马夹</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=categoryNo&value=R">羽绒服</a></li>
		          </ul>
		      </div>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#series" href="javascript:void(0)">系列</a>
		      <div class="collapse" id="series">
		          <ul class="navbar-nav">
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=seriesNo&value=2">知性女人</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=seriesNo&value=3">经典淑女</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=seriesNo&value=4">品味淑女</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=seriesNo&value=5">时尚淑女</a></li>
		              <li class="nav-item"><a href="servlet/ProductServlet?opr=getListProduct&key=seriesNo&value=6">柔美系列</a></li>
		          </ul>
		      </div>
		      <a data-toggle="collapse" data-parent="#row_nav" data-target="#orderBy" href="javascript:void(0)">商品价格排序</a>
		      <div class="collapse" id="orderBy">
		          <ul class="navbar-nav">
		         		<li class="nav-item"><c:if test="${empty order }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=ASC">价格排序</a></c:if></li>
		              <li class="nav-item"><c:if test="${order=='ASC' }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=DESC">价格升序</a></c:if></li>
		              <li class="nav-item"><c:if test="${order=='DESC' }"><a href="servlet/ProductServlet?opr=getListProduct&key=${key }&value=${value}&order=ASC">价格降序</a></c:if></li>
		          </ul>
		      </div>
            </div>
        </div>
    </div>