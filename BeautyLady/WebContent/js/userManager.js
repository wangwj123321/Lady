/*冻结和恢复*/
function FreeAndRecovery(id,status){
	$.getJSON("/BeautyLady/servlet/UserServlet","opr=FreeAndRecovery&id="+id+"&status="+status,function(data){
		$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
	});
}
//获取btn拼接字段
getbtnUser = function(index,type){
	return "<button type='button' class='btn btn-link btn-outline-dark' onclick='initUser("+index+",&quot;"+type+"&quot;)'>"+index+"</button>";
}
//分页显示方法
pageChangeUser = function(pageNo,pageCount,type){
	$("#"+type+"pageChange").append("当前页码["+pageNo+"/"+pageCount+"]<div class='btn-toolbar' role='toolbar'><div>");//添加分页显示及按钮组父容器
	var btnstr = "";//btn-group字符串
	var btnlist = ""//btn-group子标签
	if(pageCount <=5){
		for(var i = 1;i<=pageCount;i++){
			btnstr += getgroup(getbtnUser(i,type));//第一个btn-group里面的字符串
		}
	}else if(pageCount >5 && pageNo <4){
		for (var i = 1; i <= pageNo +2; i++) {
			btnlist += getbtnUser(i,type);
		}
		btnstr += getgroup(btnlist);//第一个btn-group里面的字符串
		btnstr += getgroup(getbtnUser(pageCount,type));//第二个btn-group里面的字符串
	}else if(pageCount>5 && pageNo>=4 && pageNo+2<pageCount){
		btnstr += getgroup(getbtnUser(1,type));//第一个btn-group里面的字符串
		for (var j = pageNo-2; j <= pageNo+2; j++) {
			btnlist += getbtnUser(j,type);
		}
		btnstr += getgroup(btnlist);//第二个btn-group里面的字符串
		btnstr += getgroup(getbtnUser(pageCount,type));//第三个btn-group里面的字符串
	}else if(pageCount>5 && pageNo >=4 && pageNo+2>=pageCount){
		btnstr += getgroup(getbtnUser(1,type));
		for (var k = pageNo-3; k <= pageCount; k++) {
			btnlist += getbtnUser(k,type);
		}
		btnstr += getgroup(btnlist);
	}
	$("#"+type+"pageChange").children().append(btnstr);
}
//用户分页列表
initUser = function(pageNo,type){
	$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser&pageNo="+pageNo,showUser);
}
/*添加新后台用户*/
function addBackUser(){
	if($("[name='userName']").val() == ""){
		$("#hint").html("登录名不能为空");
		return;
	}
	if($("[name='userAccount']").val() == ""){
		$("#hint").html("用户名不能为空");
		return;
	}
	if($("[name='pwd']").val() == ""){
		$("#hint").html("密码不能为空");
		return;
	}
	if($("[name='email']").val() == ""){
		$("#hint").html("邮箱不能为空");
		return;
	}
	$("#hint").html("");
	if($("#hint").html() == ""){
		$.getJSON("/BeautyLady/servlet/UserServlet","opr=backAddUser&"+$("#addForm").serialize(),function(data){
			alert("新增成功");
			$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
		});
	}
}
function modifyBackUser(){
	if($("[name='muserName']").val() == ""){
		$("#mhint").html("登录名不能为空");
		return;
	}
	if($("[name='mpwd']").val() == ""){
		$("#mhint").html("新密码不能为空");
		return;
	}
	$("#mhint").html("");
	alert($("#modifyForm").serialize());
	if($("#mhint").html() == ""){
		$.getJSON("/BeautyLady/servlet/UserServlet","opr=modifyBackUser&"+$("#modifyForm").serialize(),function(data){
			alert("修改成功");
			$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
		});
	}
}
function showModify(id){
	$.getJSON("/BeautyLady/servlet/UserServlet","opr=showModifyBackUser&id="+id,function(data){
		createWindow("backmodifyUser","后台用户修改");
		$("#backmodifyUser").empty();
		$("#backmodifyUser").append("<form id='modifyForm' method='post'><table class='table table-hover'>" +
				"<tr><td><div id='mhint' style='color:red;'></div></td></tr>" +
				"<tr><th class='text-center'><h5>后台用户修改</h5></th><td></td></tr>" +
				"<tr><td class='text-right'>登录名：</td><td><input type='text' name='muserName' placeholder='登录名' required value='"+data.userName+"' /></td></tr>" +
				"<tr><td class='text-right'>用户名：</td><td><input type='text' name='muserAccount' placeholder='用户名' required value='"+data.userAccount+"' readonly='readonly' /></td></tr>" +
				"<tr><td class='text-right'>新密码：</td><td><input type='password' name='mpwd' placeholder='新密码' required /></td></tr>" +
				"<tr><td class='text-right'>邮箱：</td><td><input type='text' name='memail' placeholder='邮箱' required value='"+data.email+"' readonly='readonly' /></td></tr>" +
				"<tr><td class='text-right'><input type='button' onclick='modifyBackUser()'  value='修改' /></td><td><input type='reset'  value='重置' /></td></tr>" +
				"</table></form>");
	});
}
function showUser(data){
	createWindow("showUser", "用户列表");
	$("#showUser").empty();
	$("#showUser").append("<table class='table table-hover table-bordered table-sm'><thead id='showUsergoodList'></thead><tbody id='showUserclassList'></tbody></table>");
	var top = "<tr><td>用户登录名</td><td>用户名</td><td>email</td><td>状态</td><td>前/后台</td><td>创建人</td><td>创建时间</td><td>修改人</td><td>修改时间</td><td>操作</td></tr>";
	var diff= "";
	for(var i = 0;i < data.list.length;i++){
		var status = "";
		var stage = "";
		if(data.list[i].status == 0){
			status = "未激活";
		}
		if(data.list[i].status == 1){
			status = "激活";
		}
		if(data.list[i].status == 2){
			status = "冻结";
		}
		if(data.list[i].stage == 0){
			stage = "后台";
		}
		if(data.list[i].stage == 1){
			stage = "前台";
		}
		if(data.list[i].stage == 0){
			diff += "<tr><td>"+data.list[i].userAccount+"</td><td>"+data.list[i].userName+"</td><td>"+data.list[i].email+"</td><td>"+status+"</td><td>"+stage+"</td><td>"+data.list[i].createdBy+"</td><td>"+data.list[i].createDate+"</td><td>"+data.list[i].modifyBy+"</td><td>"+data.list[i].modifyDate+"</td><td><a href='javascirpt:void(0)' onclick='FreeAndRecovery("+data.list[i].id+",2)'>停用</a>&nbsp;&nbsp;&nbsp;<a href='javascirpt:void(0)' onclick='FreeAndRecovery("+data.list[i].id+",1)'>恢复</a>&nbsp;&nbsp;&nbsp;<a href='javascirpt:void(0)' onclick='showModify("+data.list[i].id+")'>修改</a></td></tr>";
		}else{
			diff += "<tr><td>"+data.list[i].userAccount+"</td><td>"+data.list[i].userName+"</td><td>"+data.list[i].email+"</td><td>"+status+"</td><td>"+stage+"</td><td>"+data.list[i].createdBy+"</td><td>"+data.list[i].createDate+"</td><td>"+data.list[i].modifyBy+"</td><td>"+data.list[i].modifyDate+"</td><td><a href='javascirpt:void(0)' onclick='FreeAndRecovery("+data.list[i].id+",2)'>停用</a>&nbsp;&nbsp;&nbsp;<a href='javascirpt:void(0)' onclick='FreeAndRecovery("+data.list[i].id+",1)'>恢复</a></td></tr>";
		}
	}
	$("#showUsergoodList").append(top);
	$("#showUserclassList").append(diff);
	$("#showUser").append("<span id='showUserpageChange'></span>");
	pageChangeUser(data.pageNo,data.pageCount,"showUser");
}
$(document).ready(function(){
	$("body").on("blur","[name='userAccount']",function(){
		var userAccount = $("[name='userAccount']").val();
		$.get("/BeautyLady/servlet/UserServlet","opr=getUserByUserAccount&userAccount="+userAccount,function (data){
			if(data=="true"){
				$("#hint").html("该用户以存在，请使用别的用户名！");
			}else{
				$("#hint").html("");
			}
		},"html");
	});
	
	$("body").on("blur","[name='email']",function(){
		var email = $("[name='email']").val();
		$.get("/BeautyLady/servlet/UserServlet","opr=getUserByEmailt&email="+email,function (data){
			if(data=="true"){
				$("#hint").html("该邮箱以存在，请使用别的邮箱！");
			}else{
				$("#hint").html("");
			}
		},"html");
	});
	
	$("#product_oper>ul>li:nth-of-type(1)").click(function(){
		$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
	});
	
	$("#product_oper>ul>li:nth-of-type(2)").click(function(){
		createWindow("backaddUser","后台新增用户");
		$("#backaddUser").empty();
		$("#backaddUser").append("<form id='addForm' method='post'><table class='table table-hover'>" +
				"<tr><th><div id='hint' style='color:red;'></div></th></tr>" +
				"<tr><th class='text-center'><h5>后台用户添加</h5></th><td></td></tr>" +
				"<tr><td class='text-right'>登录名：</td><td><input type='text' name='userName' placeholder='登录名' required /></td></tr>" +
				"<tr><td class='text-right'>用户名：</td><td><input type='text' name='userAccount' placeholder='用户名' required /></td></tr>" +
				"<tr><td class='text-right'>密码：</td><td><input type='password' name='pwd' placeholder='密码' required /></td></tr>" +
				"<tr><td class='text-right'>邮箱：</td><td><input type='text' name='email' placeholder='邮箱' required /></td></tr>" +
				"<tr><td class='text-right'><input type='button' onclick='addBackUser()'  value='新增' /></td><td><input type='reset'  value='重置' /></td></tr>" +
				"</table></form>");
	});
});