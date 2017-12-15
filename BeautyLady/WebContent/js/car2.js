$(document).ready(function(){
	$("#addBtu").click(function(){
		var name=$("[name='name']").val();
		var phone=$("[name='phone']").val();
		var address=$("[name='address']").val();
		var isDefault="";
		var isChecked = $("[name='isDefault']").is(":checked");
		if(isChecked){
			isDefault="1";
		}
		$.post("servlet/AddressServlet","opr=addAdderss&name="+name+"&phone="+phone+"&address="+address+"&isDefault="+isDefault,succ,"html");
		function succ(data){
			if(data=="true"){
				alert("添加地址成功！");
			}else if(data=="updateDefaultTrue"){
				alert("添加默认地址成功！");
			}else{
				alert("添加地址失败！");
			}
			location.reload();
		}
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
