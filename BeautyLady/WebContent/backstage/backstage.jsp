<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理系统</title>
</head>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage.js"></script>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
<body class="container-fluid">
<%@include file="element_page/header.jsp" %>
<div id="main" class="row">
	<%@include file="element_page/main_left.jsp" %>
	<div class="show_info col-7 col-sm-8 col-md-9 col-lg-10 col-xl-10">
        <ul class="nav nav-tabs" role="tablist" id="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#main_menu" id="main_win">首页</a>
            </li>
        </ul>
        <div class="tab-content" id="tabcontent">
            <div id="main_menu" class="show_info tab-pane active">
               <span class='display-1'>首页</span>
            </div>
        </div>
    </div>
    <div id="pageSize">
    	<small>请选择页面显示数</small><select name="pageSize" class="custom-select-sm" onchange="btnchange(this[selectedIndex].value);">
    		<option value="20">默认20</option>
    		<option value="30">30</option>
    		<option value="40">40</option>
    	</select>
    </div>
</div>
</body>
</html>