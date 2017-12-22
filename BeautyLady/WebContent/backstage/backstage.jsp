<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理系统</title>

<style type="text/css">
	.left {
		float:left;
	}
	.clean{
		clear: both;
	}
</style>

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
	/* 后台登陆的用户名 */
	var userName = "${sessionScope.backUser.userName}";
</script>
<!-- 引入日历的JavaScript代码 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/laydate.js"></script>
<!-- 入库单的js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/storageOrder.js"></script>
<!-- 属性修改的js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/propertyModify.js"></script>
<!-- 商品入库单的js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/storage.js"></script>
<!-- 订单列表单的js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/orderList.js"></script>
<!-- 添加商品 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/product.js"></script>
<!--用户管理的js文件  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userManager.js"></script>
<body>
<%@include file="element_page/header.jsp" %>
<div id="main">
	<%@include file="element_page/main_left.jsp" %>
	    <div id="main_info">
        <div class="show_info">
            <ul class="nav nav-tabs small" id="tablist">
	             <li class="nav-item">
	                <a class="nav-link active" data-toggle="tab" href="#main_menu" id="main_win">首页</a>
	            </li>
            </ul>
            <div class="tab-content" id="tabcontent">
	            <div id="main_menu" class="show_info tab-pane active">
		            <form>
		                <table class="table">
		                    <thead><tr><th class="text-center">商品信息修改</th></tr></thead>
		                    <tbody>
		                    <tr>
		                        <td class="text-right"><label for="product_no">商品编号:</label></td>
		                        <td><select class="custom-select small" id="product_no">
		                            <option selected>请选择商品编号</option>
		                            <option value="1">1</option>
		                            <option value="2">2</option>
		                            <option value="3">3</option>
		                            <option value="4">4</option>
		                        </select></td>
		                    </tr>
		                    <tr>
		                        <td class="text-right"><label for="email">Email:</label></td>
		                        <td>
		                            <input type="email" id="email" placeholder="@">
		                        </td>
		                    </tr>
		                    <tr>
		                        <td class="text-right"><label for="pwd">密码:</label></td>
		                        <td><input type="password" id="pwd"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-right"><input type="submit" name="sbt" value="提交"></td>
		                        <td><input type="reset" name="rst" value="重置"></td>
		                    </tr>
		                    </tbody>
		                </table>
		            </form>
	            </div>
            </div>
        </div>
    </div>
</div>
<div id="bottom" class="text-center">
    <div id="pageSize">
    	<small>请选择页面显示数</small><select name="pageSize" class="custom-select-sm" onchange="btnchange(this[selectedIndex].value);">
    		<option value="20">默认20</option>
    		<option value="30">30</option>
    		<option value="40">40</option>
    	</select>
    	    &copy;tyj有限公司2017-2027年版权所有
    </div>
</div>
</body>

<script type="text/javascript">
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo'});//绑定元素
}();

//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: '1992-12-02', //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);

//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});

//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});
</script>
</html>