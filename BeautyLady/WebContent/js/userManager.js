
function FreeAndRecovery(id,status){
	$.getJSON("/BeautyLady/servlet/UserServlet","opr=FreeAndRecovery&id="+id+"&status="+status,function(data){
		$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
	});
}
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
	if($("#hint").html() == null){
		$.getJSON("/BeautyLady/servlet/UserServlet?opr=backAddUser","opr=showUser&"+$("#addForm").serialize(),function(data){
			alert("新增成功");s
			$.getJSON("/BeautyLady/servlet/UserServlet","opr=showUser",showUser);
		});
	}
}
function showUser(data){
	createWindow("showUser", "用户列表");
	$("#showUser").empty();
	$("#showUser").append("<table class='table table-hover table-bordered table-sm'><thead id='showUsergoodList'></thead><tbody id='showUserclassList'></tbody></table>");
	var top = "<tr><td>用户登录名</td><td>用户名</td><td>email</td><td>状态</td><td>前/后台</td><td>创建人</td><td>创建时间</td><td>修改人</td><td>修改时间</td><td>操作</td></tr>";
	var diff= "";
	for(var i = 0;i < data.length;i++){
		var status = "";
		var stage = "";
		if(data[i].status == 0){
			status = "未激活";
		}
		if(data[i].status == 1){
			status = "激活";
		}
		if(data[i].status == 2){
			status = "冻结";
		}
		if(data[i].stage == 0){
			stage = "后台";
		}
		if(data[i].stage == 1){
			stage = "前台";
		}
		diff += "<tr><td>"+data[i].userAccount+"</td><td>"+data[i].userName+"</td><td>"+data[i].email+"</td><td>"+status+"</td><td>"+stage+"</td><td>"+data[i].createdBy+"</td><td>"+data[i].createDate+"</td><td>"+data[i].modifyBy+"</td><td>"+data[i].modifyDate+"</td><td><a href='#' onclick='FreeAndRecovery("+data[i].id+",2)'>停用</a>&nbsp;&nbsp;&nbsp;<a href='#' onclick='FreeAndRecovery("+data[i].id+",1)'>恢复</a></td></tr>";
	}
	$("#showUsergoodList").append(top);
	$("#showUserclassList").append(diff);
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
		$("#backaddUser").append("<form id='addForm' method='post'>" +
				"<div id='hint' style='color:red;'></div>" +
				"<h5>后台用户添加</h5>" +
				"<div><input type='text' name='userName' placeholder='登录名' required /></div>" +
				"<div><input type='text' name='userAccount' placeholder='用户名' required /></div>" +
				"<div><input type='password' name='pwd' placeholder='密码' required /></div>" +
				"<div><input type='text' name='email' placeholder='邮箱' required /></div>" +
				"<input type='button' onclick='addBackUser()'  value='新增' />" +
				"</form>");
	});
	
});