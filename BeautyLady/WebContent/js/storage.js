$(function(){
	getProductExt = function(value){
		if(value != null && value!=""){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNo="+value,getProduct);
		}
	}
	
	 function getProduct(data){
	 	$("#choose").empty();
	 	var productNo= data.productNo;
		var colorNos = data.colorNo.split("|");
		var colorNames = data.colorName.split("|");
		var table="<table id='search'><tr><td>选择</td><td>颜色编号</td><td>颜色名称</td></tr></table>";
		$("#choose").append(table);
		var $search = $("#search");
		for(var i=0 ; i < colorNos.length ; i++){
			if(colorNos[i]!=""){
				$search.append("<tr id='tr'><td><input class='color' name='color' value='"+colorNos[i]+"' type='checkbox' onclick=selectColor(this)></td><td id='color'>"+colorNos[i]+"</td><td id='colorName'>"+colorNames[i]+"</td></tr>");
			}
		}		
		
		$("#choose").append("<button onclick='choose("+productNo+")'>确定</button>");
		
		
	}
	
	selectColor = function(c){
		var colors = $(".color");
		console.log(colors);
		var value="";
		for(var i =0 ;i <colors.length ; i++){
			if($(colors[i]).is("checked")){
				colors[i].removeAttr("checked");
				console.log(value);
			}
		}
		$(c).attr("checked","true");
		
	}
	 
	 getColor = function(no){
	 	var productNo = $("#productNo"+no).val();
		if(productNo!=null && productNo!=""){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNo="+productNo,getProduct);
		}	 
	 }
	 
	 choose = function(productNo){
	 	var colors = $(".color");
		console.log(colors);
		var value="";
		for(var i =0 ;i <colors.length ; i++){
			if(colors[i].is("checked")){
				value = colors[i].val();
				console.log(value);
			}
		}
	 	$("#choose").hide();
	 }
	 
	
})