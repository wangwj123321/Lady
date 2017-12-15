$(document).ready(function(){
	/*添加地址按妞点击事件*/
	$("#addBtu").click(function(){
		var name=$("[name='name']").val();
		var phone=$("[name='phone']").val();
		var address=$("[name='address']").val();
		var isDefault="";
		var isChecked = $("[name='isDefault']").is(":checked");
		if(isChecked){
			isDefault="1";
		}
		$.post("servlet/AddressServlet","opr=addAdderss&name="+name+"&phone="+phone+"&address="+address+"&isDefault="+isDefault,succ,"json");
		function succ(data){
			var is=data[0].is;
			var object =data[1];
			if(is=="true"){
				alert("添加地址成功！");
			}else if(is=="updateDefaultTrue"){
				alert("添加默认地址成功！");
				$(".ch_address").remove();
				$("#ab").find("h3").after("<div class='ch_address' name='"+object.id+"'><p>姓名："+object.name+"</p><p>电话："+object.phone+"</p><p>地址："+object.address+"</p></div>");
			}else{
				alert("添加地址失败！");
			}
		}
	});
	/*加载所有地址按妞点击事件*/
	$("#ch_dd_btn").click(function(){
		$.getJSON("servlet/AddressServlet","opr=getNotDefaultAddress",succ);
		function succ(data){
			$(data).each(function(i,t){
				$("div.sure").after("<div class='ch_address' name='"+t.id+"'><p>姓名："+t.name+"</p><p>电话："+t.phone+"</p><p>地址："+t.address+"</p></div>");
			});
		}
	});
	/*更换收货地址*/
	$("#ab").on("click","div.ch_address",function(){
		$(this).siblings(".ch_address").remove();
		$(this).addClass("sure");
	});
	getTotal();
});
function getTotal(){
	var prices=$(".one_total");
	var total=0;
	$(prices).each(function(i,t){
		var price=parseInt($(t).text());
		total=total+price;
	});
	$("#total").text(total);
	if(total>=1000){
		$("#youhui").text("-8.0");
		$("#costTotal").text(total);
	}else{
		total=total+8;
		$("#costTotal").text(total);
	}
}
