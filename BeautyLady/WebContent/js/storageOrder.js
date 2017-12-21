$(function() {

	getOrderNo = function() {
		var orderNo = "SO" + new Date().getTime();
		return orderNo;
	}

	getStorageOrder = function() {
		createWindow("storageOrder", "商品入库单");
		$("#storageOrder")
		.append("<table><tr><td>开始日期</td>"
			+ "<td class='inline laydate-icon' id='start' style='width:150px; margin-right:10px;'></td>"
			+ "<td>结束日期</td><td class='inline laydate-icon' id='end' style='width:150px;'></td>"
			+ "</tr><tr>"
			+ "</tr><tr>"
			+ "<td><button><a href='javaScript:void(0)' onclick='getStorageOrderDetail()'>新增单据</a></button></td>"
			+ "<td><button>搜索</button></td>" + "</tr></table>"
			+ "<div id='content'>" + "<table><tr>"
			+ "<td>订单编号</td>" + "<td>订单数量</td>" + "<td>订单总额</td>"
			+ "<td>订单审核</td>" + "<td>订单日期</td>" + "<td>用户名</td>"
			+ "<td>订单描述</td>" + "</tr></table></div>")
	}
	
	/**
	 * 商品的明细表单
	 */
	getStorageOrderDetail = function() {
		createWindow("detail", "商品库存单详情");
		$("#detail")
		.append("<form id='storageForm' action='/BeautyLady/servlet/addStorageOrder' method='post'>"
			+ "<table id='mytable' border='1'>"
			+ "<tr>"
			+ "<td>订单编号</td><td><input type='text' id='order' name='orderNo' value='"+getOrderNo()+"'  readonly='true'></td>"
			+ "<td>订单日期</td><td class='inline laydate-icon' id='start' style='width:150px;'></td>"
			+ "</tr><tr>" + "<td>商品名称</td>" + "<td>颜色编号</td>"
			+ "<td>尺码名称</td>" + "<td>数量</td>" + "<td>金额</td>"
			+ "</tr><tr>"
			+ "<td><input type='text' name='productNo'  ></td>"
			+ "<td><input type='text' name='colorNo' onchange='getProductxx(this)' ></td>"
			+ "<td><input type='text' name='sizeNo' onchange='getProductxx(this)'></td>"
			+ "<td><input type='text' onchange='getProductxx(this)' name='number' ></td>"
			+ "<td><input type='text'  name='totalMoney' ></td>"
			+ "<td><img onclick='addProduct()' src='/BeautyLady/images/add.png'></td>"
			+ "</tr><tr>"
			+ "<td></td>"
			+ "</tr></table><textarea rows='3' cols='38' id='desc'></textarea><br><input type='button' onclick='submitOrder()' value='提交'/><input type='button' onclick=calculatePrice() value='价格刷新'></form>")
	}
	
	/**
	 * 提交表单事件
	 */
	submitOrder = function(){
		var flag = false;
		var desc = $("#desc").val();
		var order = $("#order").val();
		var productNo = $("[name=productNo]");
		var colorNo = $("[name=colorNo]");
		var sizeNo= $("[name=sizeNo]"); 
		var number=$("[name=number]"); 
		var totalMoney=$("[name=totalMoney]"); 
		var productNos = new Array();
		var colorNos = new Array();
		var sizeNos = new Array();
		var numbers = new Array();
		var totalMoneys = new Array();
		for (var i =0 ; i<productNo.length ; i++){
			productNos.push($(productNo[i]).val());
			colorNos.push($(colorNo[i]).val());
			sizeNos.push($(sizeNo[i]).val());
			numbers.push($(number[i]).val());
			totalMoneys.push($(totalMoney[i]).val());
			if(productNos.length == colorNos.length && productNos.length == sizeNos.length && productNos.length == numbers.length){
				flag = true;
			}
		}	
		if(flag == true){
			$.get("/BeautyLady/servlet/addStorageOrder","pNo="+productNos+"&cNo="+colorNos+"&sNo="+sizeNos+"&num="+numbers+"&money="+totalMoneys+"&so="+order+"&ds="+desc,calculatePrice,"JSON");
		}else {
			alert("颜色，尺码和数量必须填");
		}
		
	}
	
	
	
	
	/**
	 * 通过ajax获取商品信息
	 */
	getProductxx = function(name){
		var productNo = $("[name=productNo]");
		var productNos = new Array();
		for (var i =0 ; i<productNo.length ; i++){
			productNos.push($(productNo[i]).val());
		}
		var name = $(name).attr("name");
		console.log(name);
		if(name == 'number'){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNos="+productNos,calculatePrice);
		}else if(name == 'colorNo'){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNos="+productNos,checkoutColor);
		}else if(name == 'sizeNo'){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNos="+productNos,checkoutSize);
		}		
		
	}
	
	/**
	 * 计算价格
	 */
	function calculatePrice(data){
		falg=true;
		var nums = $("[name=number]");
		var totalMoney= $("[name=totalMoney]");
		var colorNos = $("[name=colorNo]");
		var sizeNos= $("[name=sizeNo]");
		for(var i =0 ; i<nums.length ; i++){
			var totalPrice = $(nums[i]).val()*data[i].tagPrice;
			$(totalMoney[i]).val(totalPrice);
		}
	}
	
	/**
	 * 检验是否包含给尺码
	 */
	function checkoutSize(data){
		var sizeNos= $("[name=sizeNo]");
		for(var i =0 ; i<sizeNos.length ; i++){
			if(data[i].sizeNo.indexOf($(sizeNos[i]).val())<0 && $(sizeNos[i]).val()!=""){
				alert("该款没有这个尺码");
			}
		}
	}
	
	/**
	 * 检验是否包含给颜色
	 */
	function checkoutColor(data){
		var colorNos= $("[name=colorNo]");
		for(var i =0 ; i<colorNos.length ; i++){
			if(data[i].sizeNo.indexOf($(colorNos[i]).val())<0 && $(colorNos[i]).val()!=""){
				alert("该款没有这个颜色");
			}
		}
	}
	
	
	
	/**
	 * 增加添加商品的行
	 */
	addProduct = function(){
		$("#mytable").append("<tr>"
			+ "<td><input type='text' name='productNo'  ></td>"
			+ "<td><input type='text' name='colorNo'  ></td>"
			+ "<td><input type='text' name='sizeNo' ></td>"
			+ "<td><input type='text' name='number' ></td>"
			+ "<td><input type='text' name='totalMoney' ></td>"
			+ "<td><img onclick='addProduct()' src='/BeautyLady/images/add.png'></td>"
			+ "</tr>");
	}
})