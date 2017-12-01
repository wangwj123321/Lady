$(function() {
	var Commontitle = "<td>状态</td><td>创建者</td><td>创建时间</td><td>修改者</td>" +
	"<td>修改时间</td><td>操作</td></tr>";//表头相同内容
	initProduct = function(pageNo,type){
		$("#goodList").empty();
		$("#changePage").empty();
		var arr = new Array();
		$.get(ctx+"/ProductServlet","pageNo="+pageNo+"&type="+type,function(data){
			arr = data.list;//接受数据列表
			var flag = true;//判断是否输入的为表单
			for(i in arr){
				var diffData = "";
				var commonData = "<td>"+arr[i].status+"</td><td>"+arr[i].createdBy+"</td><td>"+arr[i].createDate+"</td>" +
						"<td>"+arr[i].modifyBy+"</td><td>"+arr[i].modifyDate+"</td>"
						+"<td><a href='"+ctx+"/modify.jsp?id="+arr[i].id+"&type="+data.type+"'>修改</a>&nbsp;&nbsp;&nbsp;" +
								"<a href='"+ctx+"/stop.jsp?id="+arr[i].id+"&type="+data.type+"'>停用</a></td></tr>"
				if(data.type == "Category"){
					if(flag){$("#goodList").append("<tr><td>大类编号</td><td>大类名称</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].categoryId+"</td><td>"+arr[i].categoryName+"</td>"
				}else if(data.type == "SubClasses"){
					if(flag){$("#goodList").append("<tr><td>小类编号</td><td>小类名称</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].subClassesId+"</td><td>"+arr[i].subClassesName+"</td>"
				}else if(data.type == "Color"){
					if(flag){$("#goodList").append("<tr><td>颜色编号</td><td>颜色类型</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].colorId+"</td><td>"+arr[i].colorName+"</td>"
				}else if(data.type == "Size"){
					if(flag){$("#goodList").append("<tr><td>尺寸编号</td><td>尺寸大小</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].sizeId+"</td><td>"+arr[i].sizeName+"</td>"
				}else if(data.type == "Band"){
					if(flag){$("#goodList").append("<tr><td>波段编号</td><td>波段</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].bandId+"</td><td>"+arr[i].bandName+"</td>"
				}else if(data.type == "Theme"){
					if(flag){$("#goodList").append("<tr><td>主题编号</td><td>主题</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].themeId+"</td><td>"+arr[i].themeName+"</td>"
				}else if(data.type == "Series"){
					if(flag){$("#goodList").append("<tr><td>款式编号</td><td>款式</td>"+Commontitle);}
					diffData = "<tr><td>"+arr[i].seriesId+"</td><td>"+arr[i].seriesName+"</td>"
				}
				flag = false;
				$("#goodList").append(diffData+commonData);
			}
			$("#changePage").append("当前页码["+data.pageNo+"/"+data.pageCount+"]")
			if(data.pageNo > 1){
				$("#changePage").append("<a href='javascript:void(0)' onclick = initProduct(1,'"+data.type+"')>首页</a>" +
						"<a href='javascript:void(0)' onclick = initProduct("+(data.pageNo-1)+",'"+data.type+"')>上一页</a>")
			}
			if(data.pageNo < data.pageCount){
				$("#changePage").append("<a href='javascript:void(0)' onclick = initProduct("+(data.pageNo+1)+",'"+data.type+"')>下一页</a>" +
						"<a href='javascript:void(0)' onclick = initProduct("+(data.pageCount)+",'"+data.type+"')>尾页</a>")
			}
		},"JSON");
	}
})