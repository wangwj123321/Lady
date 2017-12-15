<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src='${pageContext.request.contextPath }/js/jquery-3.2.1.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/laydate.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath }/js/storage.js'></script>
<style>
	#choose{
		position:fixed;
		top:100px;
		right:700px;
		width:200px;
		height:200px;
		border:1px solid red;
	}
</style>
<title>显示入库单</title>
</head>
<body>
	<form action='#' method='post'>
	<table border="1">
		<tr>
			<td>订单编号</td><td><input type='text' name='orderNo' value='${requestScope.orderNo }'  readonly='true'></td>
			<td>订单日期</td><td class="inline laydate-icon" id='start' style="width:150px;"></td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td>颜色编号</td>
			<td>尺码名称</td>
			<td>数量</td>
			<td>金额</td>
		</tr>
		<c:forEach begin="1" end="15" varStatus="in">
		<tr>
			<td><input type='text' name='productNo' id="productNo${in.index}" ></td>
			<td><input type='text' name='colorNo' id='colorNo${in.index }' ondblclick='getColor("${in.index }")'></td>
			<td><input type='text' name='sizeNo' id='sizeNo${in.index }'></td>
			<td><input type='text' name='number' id='number${in.index }'></td>
			<td><input type='text' name='totalMoney' id='totalMoney${in.index }'></td>
		</tr>
		</c:forEach>
		<tr>
			<td><input type='submit' value='提交'/></td>
		</tr>
	</table>
	</form>
	<div id='choose'>
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