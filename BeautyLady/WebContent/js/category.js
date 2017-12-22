//用户分页列表
initCategory = function(type,windowName){
	createWindow("add"+type,"添加"+windowName);
	$("#add"+type+"").empty();
	$("#add"+type+"").append("<form class='form-horizontal' id='add"+type+"Form' method='post'><table class='table table-hover'>" +
			"<tr><th><div id='chint' style='color:red;'></div></th></tr>" +
			"<tr><th class='text-center'><h5>添加"+windowName+"</h5></th><td></td></tr>" +
			"<tr><td class='text-right'>"+windowName+"编号：</td><td><input type='text' name='"+type+"No' placeholder='编号' required /></td></tr>" +
			"<tr><td class='text-right'>"+windowName+"名：</td><td><input type='text' name='"+type+"Name' placeholder='名字' required /></td></tr>" +
			"<tr><td class='text-right'><input type='button' onclick='addCategorys(\""+type+"\")'  value='新增' /></td><td><input type='reset'  value='重置' /></td></tr>" +
			"</table></form>");
}
addCategorys = function(type){
	if($("[name='categoryNo']").val() == ""){
		$("#chint").html("编号不能为空");
		return;
	}
	if($("[name='categoryName']").val() == ""){
		$("#chint").html("名字不能为空");
		return;
	}
	$("#chint").html("");
	var types = type.substr(0,1).toUpperCase()+type.substr(1);
	if($("#chint").html() == ""){
		$.post("/BeautyLady/servlet/prop","opr=adds&type="+type+"&"+$("#add"+type+"Form").serialize()+"&createdBy="+userName,function(data){
			if(data == "1"){
				alert("新增成功");
				initProduct(1,types)
			}else{
				alert("新增失败");
			}
			/*$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);*/
		},"json");
	}
}
$(document).ready(function(){
	
});