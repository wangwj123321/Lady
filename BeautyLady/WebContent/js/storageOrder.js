$(function() {
	
	/**
	 * 生成订单编号
	 */
	getOrderNo = function() {
		var orderNo = "SO" + new Date().getTime();
		return orderNo;
	}

	getStorageOrder = function(type,opr) {
		$("#storageOrder").empty();
		$.post("/BeautyLady/servlet/storageOrder","type="+type+"&opr="+opr,callStorageOrder,"JSON");
	}
	
	/**
	 * 显示添加订单明细的界面
	 */
	callStorageOrder = function(data){
		createWindow("storageOrder", "商品入库单");
		$("#storageOrder").append("<table id='soId' class='table table-hover table-condensed content'><tr><td>开始日期</td>" +
			"<td>显示日期</td>" +
			"<td>结束日期</td><td>显示日期</td>" +
			"<td>搜索</td><td><a href='javaScript:void(0)' onclick='orderDetail()'>新增</a></td></tr>" +
			"<tr>"+
			"<td>订单编号</td><td>订单数量</td><td>订单总额</td>"+ 
			"<td>订单审核</td><td>订单日期</td><td>用户名</td>"+ 
			"<td>订单描述</td><td>操作</td></tr>"+
			"</table>");
		var $table = $("#soId");
		console.log(data);
		console.log(typeof(data));
		$.each(data,function(i,d){
			$table.append("<tr><td><a href='javaScript:void(0)' onclick='showDetail(\""+d.orderNo+"\")'>"+d.orderNo+"</a></td><td>"+d.number+"</td><td>"+d.totalMoney+"</td>" +
					"<td>"+d.status+"</td><td>"+isNull(d.storageDate)+"</td><td>"+isNull(d.userName)+"</td><td>"+isNull(d.desc)+"</td>" +
							"<td><a href='JavaScript:void(0)' onclick='accept(\""+d.orderNo+"\")'>验收</a>&nbsp;&nbsp;<a href='#'>修改</a>&nbsp;&nbsp;<a href='javaScript:void(0)' onclick='del(\""+d.orderNo+"\")'>删除</a><td></tr>")
		});
	}
	
	
	
	
	showDetail = function(orderNo){		
		$("#showDetail").empty();
		var opr = "showDetail";
		$.post("/BeautyLady/servlet/storageOrder","opr="+opr+"&orderNo="+orderNo,function(data){
			console.log(data);
			console.log(typeof(data));
			createWindow("showDetail", "商品库存");
			$("#showDetail").append("<table id='sd' class='table table-hover table-condensed content'>" +
			"<tr>"+
			"<td>订单编号</td><td>商品编号</td><td>颜色编号</td>"+ 
			"<td>尺码编号</td><td>数量</td></tr>"+
			"</table>");
			var $table = $("#sd");
			for (var i = 0; i < data.length; i++) {
				$table.append("<tr><td>"+data[i].orderNo+"</td><td>"+data[i].productNo+"</td><td>"+data[i].colorNo+"</td><td>"+data[i].sizeNo+"</td>" +
					"<td>"+data[i].number+"</td></tr>")
			}
		},"JSON");
		
	}
	
	/**
	 * 验收入库
	 */
	accept = function(orderNo){
		$.post("/BeautyLady/servlet/storageOrder","opr=accept&orderNo="+orderNo,function(data){
			if(date == "true"){
				$("#storageOrder").empty();
				createWindow("storageOrder", "商品入库单");
				$("#storageOrder").append("<p>验收成功</p>");
			}else {
				$("#storageOrder").empty();
				createWindow("storageOrder", "商品入库单");
				$("#storageOrder").append("<p>验收失败</p>");
			}
		});
	}
	
	/**
	 * 提交订单
	 */
	addStorageOrder = function (){
		var params = $("#storageOr ").find(":input").serialize();
		console.log(params);
		$.post("/BeautyLady/servlet/storageOrder","params="+params+"&opr=addStorage&userName="+userName,callStorageOrder,"JSON");
	}
	
	
	/**
	 * 显示入库单新增界面
	 */
	orderDetail = function(){
		$("#orDetail").empty();
		createWindow("orDetail", "新增入库单");
		$("#orDetail").append("<form id='storageOr'><table class='table'>" +
			"<tr><td class='col-ms-2'>订单编号</td><td><input type='text' id='order' class='form-control col-sm-4' name='orderNo' value='"+getOrderNo()+"'  readonly='true'></td></tr>" +
			"<tr><td>订单日期</td><td></td><td><a href='javaScript:void(0)' onclick='addStorageOrder()'>提交订单</a></td></tr>" +
			"<tr><td>商品名称</td><td>颜色编号</td>" +
			"<td>尺码名称</td><td>数量</td><td>金额</td></tr>" +
		"</table></form>");
		addTr();
		var $orDetail = $("#orDetail td>input");
		$orDetail.each(function(){
		$(this).dblclick(function(){
			$("#prop").empty();
			$(this).parent().append("<div id='prop'  style='position:absolute;top:40px;left: 130px;width:565px; background-color: #fbfbfb!important;zz-index:999;border:1px solid red'><table id='choosePro' class='table table-condensed'></table></div>")
			var type = $(this).attr("name");
			$.get("/BeautyLady/servlet/getProductExt","opr=findAllProExt"+"&type="+type+"&pageNo="+1+"&pageSize="+10,function(data){
				if(data != false){
					var $choosePro = $("#choosePro");
					$.each(data.list,function(i,item){
						$choosePro.append("<tr><td><input type='radio' name='productNo' value='"+item.productNo+"'>"+item.productNo+"</td><td>"+item.productName+"</td><td>"+inputColor(item.colorName,item.colorNo)+"</td><td>"+inputSize(item.sizeName,item.sizeNo)+"</td></tr>")
					})
				}
				pageChangeToW("prop",data.pageNo,data.pageCount,data.type);
				$("#prop").append("<button onclick='chooseProp()'>确定</button>");
				
			},"JSON");
		});
	})
	}
	
	chooseProp = function (){
		var choose = $("#choosePro :checked");
		var parentTr = $("#prop").parent().parent(0);
		for(var i =0 ;i <choose.length ; i++){
			var value = $(choose[i]).val();
			$(parentTr.children("td")[i]).children("input").val(value);
		}
		$("#prop").remove("#prop");
	}
	
	pageChangeToW = function(id,pageNo,pageCount,type){
		$("#"+id).append("当前页码["+pageNo+"/"+pageCount+"]<div class='btn-toolbar' role='toolbar'><div>");//添加分页显示及按钮组父容器
    	var btnstr = "";//btn-group字符串
    	var btnlist = ""//btn-group子标签
    	if(pageCount <=5){
    		for(var i = 1;i<=pageCount;i++){
    			btnstr += getgroup(getbtnToW(i,type));//第一个btn-group里面的字符串
    		}
    	}else if(pageCount >5 && pageNo <4){
    		for (var i = 1; i <= pageNo +2; i++) {
    			btnlist += getbtnToW(i,type);
			}
    		btnstr += getgroup(btnlist);//第一个btn-group里面的字符串
    		btnstr += getgroup(getbtnToW(pageCount,type));//第二个btn-group里面的字符串
    	}else if(pageCount>5 && pageNo>=4 && pageNo+2<pageCount){
    		btnstr += getgroup(getbtnToW(1,type));//第一个btn-group里面的字符串
			for (var j = pageNo-2; j <= pageNo+2; j++) {
				btnlist += getbtnToW(j,type);
			}
			btnstr += getgroup(btnlist);//第二个btn-group里面的字符串
			btnstr += getgroup(getbtnToW(pageCount,type));//第三个btn-group里面的字符串
		}else if(pageCount>5 && pageNo >=4 && pageNo+2>=pageCount){
			btnstr += getgroup(getbtnToW(1,type));
			for (var k = pageNo-3; k <= pageCount; k++) {
				btnlist += getbtnToW(k,type);
			}
			btnstr += getgroup(btnlist);
		}
    	$("#"+id).append(btnstr);
	}
	
	
	//获取btn拼接字段
    getbtnToW = function(index,type){
    	return "<button type='button' class='btn btn-link btn-outline-dark' onclick='choosePage("+index+",&quot;"+type+"&quot;)'>"+index+"</button>";
    }
    //获取btn-group拼接字段
    getgroupToW = function(btnlist){
    	return "<div class='btn-group' role='group'>"+btnlist + "</div>"
    }
    
    /**
     * 分页
     */
    choosePage = function(pageNo,type){
    	$("#prop").empty();
    	$("#prop").append("<table id='choosePro' class='table table-condensed'></table>");
    	$.post("/BeautyLady/servlet/getProductExt","pageNo="+pageNo+"&pageSize="+10+"&type="+type,callPage,"JSON");
    	
    }
    
    /**
     * 显示分页
     */
    callPage = function(data) {
		if (data != false) {
			var $choosePro = $("#choosePro");
			$.each(data.list, function(i, item) {
				$choosePro
						.append("<tr><td><input type='radio' name='productNo' >"
								+ item.productNo
								+ "</td><td>"
								+ item.productName
								+ "</td><td>"
								+ inputColor(item.colorName, item.colorNo)
								+ "</td><td>"
								+ inputSize(item.sizeName, item.sizeNo)
								+ "</td></tr>")
			})
		}
		pageChangeToW("prop", data.pageNo, data.pageCount, data.type);
		$("#prop").append("<button onclick='chooseProp()'>确定</button>");
	}

	
	
	addTr = function (){
		
		for(var i =0 ; i < 10 ; i++){
			$("#storageOr table").append("<tr><td><input class='form-control' type='text' name='ProductExt'  ></td>"+ 
			"<td><input class='form-control' type='text' name='color' ></td>"+ 
			"<td><input class='form-control' type='text' name='size''></td>"+ 
			"<td><input class='form-control' type='text' name='number' ></td>"+ 
			"<td><input class='form-control' type='text' name='totalMoney' ></td><tr>");
		}
	}
	
/*	"<tr><td><input class='form-control' type='text' name='productNo'  ></td>"+ 
			"<td><input class='form-control' type='text' name='colorNo' ></td>"+ 
			"<td><input class='form-control' type='text' name='sizeNo''></td>"+ 
			"<td><input class='form-control' type='text' name='number' ></td>"+ 
			"<td><input class='form-control' type='text' name='totalMoney' ></td>"+ */
	
	
	inputColor = function (colorName , colorNo){
		var names = colorName.split(",");
		var nos = colorNo.split(",");
		var inp = "";
		for(var i =0 ;i < names.length ; i ++){
			if(names[i]!="" || name[i] != undefined){
				inp =inp + "<input type='radio' name='colorNo' value='"+nos[i]+"' >"+names[i];
			}
		}
		return inp;
	}
	
	inputSize = function (sizeName , sizeNo){
		var names = sizeName.split(",");
		var nos = sizeNo.split(",");
		var inp = "";
		for(var i =0 ;i < names.length ; i ++){
			if(names[i]!="" || name[i] != undefined){
				inp =inp + "<input type='radio' name='sizeNo' value='"+nos[i]+"' >"+names[i];
			}
		}
		return inp;
	}
	
	
	/**
	 * 删除订单
	 */
	del = function(orderNo){
		var opr="del";
		$.post("/BeautyLady/servlet/storageOrder","orderNo="+orderNo+"&opr="+opr,function(data){
		if(data=="true"){
		getStorageOrder('StorageOrder','findOrder')
		}else{
			$("#storageOrder").empty();
			createWindow("storageOrder", "商品入库单");
			$("#storageOrder").append("<p>删除失败</p>");
		}});
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
	
	/**
	 * 显示库存
	 */
	showStorage = function(){
		var opr = "showStorage";
		$.post("/BeautyLady/servlet/storageOrder","opr="+opr,function(data){
			$("#storage").empty();
			createWindow("storage", "商品库存");
			$("#storage").append("<table id='stor' class='table table-hover table-condensed content'>" +
			"<tr>"+
			"<td>商品编号</td><td>颜色编号</td><td>尺码编号</td>"+ 
			"<td>库存数量</td></tr>"+
			"</table>");
			var $table = $("#stor");
			$.each(data,function(i,d){
				$table.append("<tr><td>"+d.productNo+"</td><td>"+d.colorNo+"</td><td>"+d.sizeNo+"</td>" +
					"<td>"+d.number+"</td></tr>")
			})
		},"JSON");
	
	}
})