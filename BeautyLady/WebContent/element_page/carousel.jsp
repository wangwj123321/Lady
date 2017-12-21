<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="pics" class="col-12 carousel slide" data-ride="carousel">
	<!-- 指示符 -->
	<ul class="carousel-indicators">
	    <li data-target="#pics" data-slide-to="0" class="active"></li>
	    <li data-target="#pics" data-slide-to="1"></li>
	    <li data-target="#pics" data-slide-to="2"></li>
	</ul>
	<!-- 轮播图片 -->
	<div class="carousel-inner">
	    <div class="carousel-item active">
	        <a href="#"><img class="img-fluid" src="images/20171214111834514jpg.jpg"></a>
	    </div>
	    <div class="carousel-item">
	        <a href="#"><img class="img-fluid" src="images/20171219161325493jpg.jpg"></a>
	    </div>
	    <div class="carousel-item">
	        <a href="#"><img class="img-fluid" src="images/20171219165032727jpg.jpg"></a>
	    </div>
	</div>
	<!-- 左右切换按钮 -->
	   <a class="carousel-control-prev" href="#pics" data-slide="prev">
	       <span class="fa fa-chevron-circle-left fa-lg text-dark"></span>
	   </a>
	   <a class="carousel-control-next" href="#pics" data-slide="next">
	       <span class="fa fa-chevron-circle-right fa-lg text-dark"></span>
	   </a>
</div>