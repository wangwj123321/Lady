$(function () {
	var pageSize = "";
    //显示窗体
    showmainmenu = function () {
        $("#main_win").addClass("active").parent().siblings().children().removeClass("active");
        $("#main_menu").addClass("active").siblings().removeClass("active");
    }
    //点击生成查询窗体
    var Commontitle = "<th>状态</th><th>创建者</th><th>创建时间</th><th>修改者</th><th>修改时间</th><th>操作</th></tr>";//表头相同内容
	initProduct = function(pageNo,type){
		if($("#"+type).length ==0){
			$("#tablist").append("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#"+type+"'>"+type+"" +
			"<button type='button' class='close_btn' value='x'></button></a></li>");
	$("#tabcontent").append("<div id="+type+" class='tab_item show_info tab-pane'>" +
			"<table class='table table-hover table-bordered table-sm'><thead id='"+type+"goodList'></thead><tbody id='"+type+"classList'></tbody></table><span id='"+type+"pageChange'><span></div>")
			$closes = $(".close_btn");
		}
		$("[href='#"+type+"']").addClass("active").parent().siblings().children().removeClass("active");
		$("#"+type).addClass("active").siblings().removeClass("active");
		$("#"+type+"goodList").empty();
		$("#"+type+"classList").empty();
		$("#"+type+"pageChange").empty();
		var arr = new Array();
		var page = "page";
		$.get(ctx+"/servlet/ProductServlet","opr="+page+"&pageNo="+pageNo+"&type="+type+"&pageSize="+pageSize,function(data){
			arr = data.list;//接受数据列表
			var flag = true;//判断是否输入的为表单
			for(i in arr){
				var diffData = "";
				var commonData = "<td>"+arr[i].status+"</td><td>"+arr[i].createdBy+"</td><td>"+arr[i].createDate+"</td>" +
						"<td>"+arr[i].modifyBy+"</td><td>"+arr[i].modifyDate+"</td>"
						+"<td><a href='"+ctx+"/modify.jsp?id="+arr[i].id+"&type="+data.type+"'>修改</a>&nbsp;&nbsp;&nbsp;" +
								"<a href='"+ctx+"/stop.jsp?id="+arr[i].id+"&type="+data.type+"'>停用</a></td></tr>"
				if(data.type == "Category"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>大类编号</th><th>大类名称</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].categoryNo+"</td><td>"+arr[i].categoryName+"</td>"
				}else if(data.type == "SubClasses"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>小类编号</th><th>小类名称</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].subClassesNo+"</td><td>"+arr[i].subClassesName+"</td>"
				}else if(data.type == "Color"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>颜色编号</th><th>颜色类型</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].colorNo+"</td><td>"+arr[i].colorName+"</td>"
				}else if(data.type == "Size"){
					if(flag){$(""+type+"#goodList").append("<tr><th>序列号</th><th>尺寸编号</th><th>尺寸大小</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].sizeNo+"</td><td>"+arr[i].sizeName+"</td>"
				}else if(data.type == "Band"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>波段编号</th><th>波段</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].bandNo+"</td><td>"+arr[i].bandName+"</td>"
				}else if(data.type == "Theme"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>主题编号</th><th>主题</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].themeNo+"</td><td>"+arr[i].themeName+"</td>"
				}else if(data.type == "Series"){
					if(flag){$("#"+type+"goodList").append("<tr><th>序列号</th><th>款式编号</th><th>款式</th>"+Commontitle);}
					diffData = "<tr><th scope='row'>"+(i+1)+"</th><td>"+arr[i].seriesNo+"</td><td>"+arr[i].seriesName+"</td>"
				}
				flag = false;
				$("#"+type+"classList").append(diffData + commonData);
			}
			//窗体分页浏览
			var str = "当前页码["+data.pageNo+"/"+data.pageCount+"]<div class='btn-toolbar float-left' role='toolbar'>";
			if(data.pageCount <=7){
				str += "<div class='btn-group' role='group'>";
				$("#"+type+"pageChange").append("<div class='btn-group' role='group'>");
				for (var i = 1; i <= data.pageCount; i++) {
					str += "<button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+i+",&quot;"+data.type+"&quot;)'>"+i+"</button>";
				}
				str += "</div>";
			}else if(data.pageCount >7 && data.pageNo<5 ){
				str += "<div class='btn-group' role='group'>";
				for (var i = 1; i <= data.pageNo +3; i++) {
					str += "<button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+i+",&quot;"+data.type+"&quot;)'>"+i+"</button>";
				}
				str += "</div><div class='btn-group' role='group'><button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+data.pageCount+",&quot;"+data.type+"&quot;)'>"+data.pageCount+"</button></div>";
			}else if(data.pageCount>7 && data.pageNo>=5 && data.pageNo+3<data.pageCount){
				str += "<div class='btn-group' role='group'><button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct(1,&quot;"+data.type+"&quot;)'>1</button></div><div class='btn-group' role='group'>";
				for (var j = data.pageNo-3; j <= data.pageNo+3; j++) {
					str += "<button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+j+",&quot;"+data.type+"&quot;)'>"+j+"</button>";
				}
				str += "</div><div class='btn-group' role='group'><button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+data.pageCount+",&quot;"+data.type+"&quot;)'>"+data.pageCount+"</button></div>";
			}else if(data.pageCount>7 && data.pageNo >=5 && pageNo+3>=data.pageCount){
				str += "<div class='btn-group' role='group'><button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct(1,&quot;"+data.type+"&quot;)'>1</button></div><div class='btn-group' role='group'>";
				for (var j = data.pageNo-3; j <= data.pageCount; j++) {
					str += "<button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+j+",&quot;"+data.type+"&quot;)'>"+j+"</button>";
				}
				str+= "</div>";
			}
			str +="</div>";
			$("#"+type+"pageChange").append(str);
		},"JSON");
		 var $closes = $(".close_btn");
		    //点击删除窗体
		    $closes.each(function (i,$close) {
		       $($close).click(function () {
		           var idName = $(this).parent().attr("href");
		           $(this).parent().parent().remove();
		           $(idName).remove();
		           showmainmenu();
		       });
		    });
		    return false;
	}
	uploadTable = function(){
		$("#tablist").append("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#upload'>资料导入<button type='button' class='close_btn' value='x'></button></a></li>");
		$("#tabcontent").append("<div id='upload' class='tab_item show_info tab-pane'><form action='"+ctx+"/servlet/uploadDate' method='post' enctype='multipart/form-data'>"+
				"资料导入<input type='file' name='file'><br/><input type='submit' value='提交'/>"+
		"</form></div>");
	}
	//select改变页面显示数量
	btnchange = function(values){
		var pageChange = "pageChange";
		$.get(ctx+"/servlet/ProductServlet","opr="+pageChange+"&pageSize="+values,function(data){
			if(data){
				alert("修改成功");
				pageSize = $("[name='pageSize']").val();
				//查找当前显示的窗体
				$("#main_menu").siblings().each(function(){
					if($(this).hasClass("active")){
						initProduct(1,$(this).attr("id"));
					}
				})
			}
		},"JSON");
	}
});
