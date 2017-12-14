$(function(){
	getProductExt = function(value){
		if(value != null && value!=""){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNo="+value,getProduct);
		}
	}
	
	 function getProduct(data){
		var colorNos = data.colorNo.split("|");
		var colorNames = data.colorName.split("|");
		var arr=[colorNos,colorNames];
		var table="<table id='search'><tr><td>选择</td><td>颜色编号</td><td>颜色名称</td></tr></table>";
		$("#choose").append(table);
		var $search = $("#search");
		for(var i=0 ; i < colorNos.length ; i++){
			if(colorNos[i]!=""){
				$search.append("<tr id='tr'><td><input type='radio'></td><td id='color'>"+colorNos[i]+"</td><td id='colorName'>"+colorNames[i]+"</td></tr>");
			}
		}
		
	}
	 
	 getColor = function(no){
	 	 var product = $("#productNo"+no).val();
		if(product!=null && product!=""){
			$.getJSON("/BeautyLady/servlet/getProductExt","productNo="+product,getProduct);
		}	 
	 }
	 
	
})