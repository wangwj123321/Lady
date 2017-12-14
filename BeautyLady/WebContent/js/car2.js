$(document).ready(function(){
	$("#addBtu").click(function(){
		var name=$("[name='name']").val();
		var phone=$("[name='phone']").val();
		var address=$("[name='address']").val();
		$.get("servlet/AddressServlet","opr=addAdderss&name="+name+"&phone="+phone+"&address="+address,succ,"html");
		function succ(data){
			if(data=="true"){
				alert("添加地址成功！");
			}else{
				alert("添加地址失败！");
			}
		}
	});
});
