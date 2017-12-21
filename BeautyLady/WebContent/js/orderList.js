function orderDetail(orderNo){
	createWindow("orderDetail","订单详情");
	$("#orderDetail").empty();
	$("#orderDetail").append("<table class='table table-hover table-bordered table-sm'><thead id='orderDetailgoodList'></thead><tbody id='orderDetailclassList'></tbody></table><span id='orderDetailpageChange'><span>");
	$("#orderDetailgoodList").append("<tr><th>图片</th><th>商品编号</th><th>商品名字</th><th>颜色</th><th>尺码</th><th>吊牌价格</th><th>数量</th><th>总价 </th></tr>")
	$.getJSON("../servlet/OrderServlet","opr=getUser_ordersByOrderNo&orderNo="+orderNo,succ);
	function succ(data){
		$(data).each(function(i,t){
			$("#orderDetailclassList").append("<tr><td><img style='width:150;height:190px' src='../images/"+t.picpath+"'/></td><td>"+t.productNo+"</td><td>"+t.productName+"</td><td>"+t.colorName+"</td><td>"+t.sizeName+"</td><td>"+t.tagPrice+"</td><td>"+t.count+"</td><td>"+t.amount+"</td></tr>");
		});
	}
}
function getOrderList(pageNo){
	createWindow("orderList","订单列表");
	$("#orderList").append("<table class='table table-hover table-bordered table-sm'><thead id='orderListgoodList'></thead><tbody id='orderListclassList'></tbody></table><span id='orderListpageChange'><span>");
	emptyWindow("orderList");
	$("#orderListgoodList").append("<tr><th>订单编号</th><th>登录名</th><th>创建时间</th><th>总价</th><th>状态</th><th>收件人</th><th>地址</th><th>电话</th><th>操作 </th></tr>")
	$.getJSON("../servlet/OrderServlet","opr=getListOrder&pageNo="+pageNo+"&pageSize=20",succ);
	function succ(data){
		
		var arr=data.list;
		$(arr).each(function(i,t){
			var status="";
			if(t.status==0){
				status="未支付";
			}
			if(t.status==1){
				status="已支付";
			}
			if(t.status==2){
				status="未发货";
			}
			if(t.status==3){
				status="已发货";
			}
			if(t.status==4){
				status="已收货";
			}
			$("#orderListclassList").append("<tr><td>"+t.orderNo+"</td><td>"+t.userName+"</td><td>"+t.createDate+"</td><td>"+t.costPrice+"</td><td>"+status+"</td><td>"+t.address+"</td><td>"+t.name+"</td><td>"+t.phone+"</td><td><a href='javascript:void(0)' onclick='orderDetail(\""+t.orderNo+"\")'>查看详情</a></td></tr>");
		});
		pageChange2(data.pageNo,data.pageCount,"orderList");
	}
}
getbtn2 = function(index,type,method){
	return "<button type='button' class='btn btn-link btn-outline-dark' onclick='"+method+"("+index+")'>"+index+"</button>";
}
//获取btn-group拼接字段
getgroup2 = function(btnlist){
	return "<div class='btn-group' role='group'>"+btnlist + "</div>"
}
//分页显示方法
pageChange2 = function(pageNo,pageCount,type){
	$("#"+type+"pageChange").append("当前页码["+pageNo+"/"+pageCount+"]<div class='btn-toolbar' role='toolbar'><div>");//添加分页显示及按钮组父容器
	var btnstr = "";//btn-group字符串
	var btnlist = ""//btn-group子标签
	if(pageCount <=5){
		for(var i = 1;i<=pageCount;i++){
			btnstr += getgroup2(getbtn2(i,type,"getOrderList"));//第一个btn-group里面的字符串
		}
	}else if(pageCount >5 && pageNo <4){
		for (var i = 1; i <= pageNo +2; i++) {
			btnlist += getbtn2(i,type,"getOrderList");
		}
		btnstr += getgroup2(btnlist);//第一个btn-group里面的字符串
		btnstr += getgroup2(getbtn2(pageCount,type,"getOrderList"));//第二个btn-group里面的字符串
	}else if(pageCount>5 && pageNo>=4 && pageNo+2<pageCount){
		btnstr += getgroup2(getbtn2(1,type,"getOrderList"));//第一个btn-group里面的字符串
		for (var j = pageNo-2; j <= pageNo+2; j++) {
			btnlist += getbtn2(j,type,"getOrderList");
		}
		btnstr += getgroup2(btnlist);//第二个btn-group里面的字符串
		btnstr += getgroup2(getbtn2(pageCount,type,"getOrderList"));//第三个btn-group里面的字符串
	}else if(pageCount>5 && pageNo >=4 && pageNo+2>=pageCount){
		btnstr += getgroup2(getbtn2(1,type,"getOrderList"));
		for (var k = pageNo-3; k <= pageCount; k++) {
			btnlist += getbtn2(k,type,"getOrderList");
		}
		btnstr += getgroup(btnlist);
	}
	$("#"+type+"pageChange").children().append(btnstr);
}
