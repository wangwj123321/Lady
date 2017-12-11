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
			$("#"+type+"pageChange").append("当前页码["+data.pageNo+"/"+data.pageCount+"]")
			if(data.pageNo > 1){
				$("#"+type+"pageChange").append("<a href='javascript:void(0)' onclick = initProduct(1,'"+data.type+"')>首页</a>" +
						"<a href='javascript:void(0)' onclick = initProduct("+(data.pageNo-1)+",'"+data.type+"')>上一页</a>")
			}
			if(data.pageNo < data.pageCount){
				$("#"+type+"pageChange").append("<a href='javascript:void(0)' onclick = initProduct("+(data.pageNo+1)+",'"+data.type+"')>下一页</a>" +
						"<a href='javascript:void(0)' onclick = initProduct("+(data.pageCount)+",'"+data.type+"')>尾页</a>")
			}
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
	//select改变页面显示数量
	btnchange = function(values){
		var pageChange = "pageChange";
		$.get(ctx+"/servlet/ProductServlet","opr="+pageChange+"&pageSize="+values,function(data){
			if(data){
				alert("修改成功");
				pageSize = $("[name='pageSize']").val();
				$ids = $()
			}
		},"JSON");
	}
	
	uploadTable = function(){
		$("#tablist").append("<a class='nav-link' data-toggle='tab' href='#upload'>Category<button type='button' class='close_btn' value='x'></button></a>");
		$("#tabcontent").append("<form action='${pageContext.request.contextPath }/servlet/uploadDate' method='post' enctype='multipart/form-data'>"+
				"资料导入<input type='file' name='file'>"+
		"</form>");
	}
});
