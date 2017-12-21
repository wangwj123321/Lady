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
	$("#orderList").empty();
	$("#orderList").append("<table class='table table-hover table-bordered table-sm'><thead id='orderListgoodList'></thead><tbody id='orderListclassList'></tbody></table><span id='orderListpageChange'><span>");
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
		pageChange(data.pageNo,data.pageCount,"orderList");
	}
	
}
