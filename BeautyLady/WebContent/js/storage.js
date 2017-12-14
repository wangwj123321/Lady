$(function(){
	getProductExt = function(){
		var productNo= $("#productNo").val();
		if(productNo != null && productNo!=""){
			$.get("/BeautyLady/servlet/getProductExt","productNo="+productNo,getProduct);
		}
	}
	
	 function getProduct(data){
		return data;
	}
	 
	 getColor = function(){
		 var data = getProductExt();
		 console.log(data);
		 var colorNos = data.colorNo.split;
		 var colorNames = data.colorName.split;
		 var table="<table id=search><tr><td>选择</td><td>颜色编号</td><td>颜色名称</td></tr></table>";
		 colorNos.each(function(){$("#search").append("<tr><td><input type='radio'></td><t</tr>")})
		 
	 }
	
})