$(function () {
    //显示主页
    showmainmenu = function () {
        $("#main_win").addClass("active").parent().siblings().children().removeClass("active");
        $("#main_menu").addClass("active").siblings().removeClass("active");
    }
    //显示当前窗体
    showWindow = function(id){
		$("[href='#"+id+"']").addClass("active").parent().siblings().children().removeClass("active");
		$("#"+id).addClass("active").siblings().removeClass("active");
    }
	//生成窗体的方法及删除窗体
	createWindow = function(id,winName){
		if($("#"+id).length == 0){
			$("#tablist").append("<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#"+id+"'>"+winName+"" +
			"&nbsp;&nbsp;&nbsp;<span class='close_btn'>&times;</span></a></li>");//添加窗体关闭title
			$("#tabcontent").append("<div id="+id+" class='tab_item show_info tab-pane'></div>");//添加窗体内容容器
			//关闭窗体的方法
			var $closes = $(".close_btn");;//获取所有窗体
			$closes.each(function () {
				$(this).click(function () {
					var idName = $(this).parent().attr("href");//锚点id属性值
					$(this).parent().parent().remove();//删除导航窗口
					$(idName).remove();//删除窗口内容
					showmainmenu();//返回主页
					$closes = $(".close_btn");//重新获取窗体按钮数量
				});
			});
		}
		showWindow(id);//显示当前窗体
	}
	//清空窗体内容
	emptyWindow = function(id){
		$("#"+id+"goodList").empty();
		$("#"+id+"classList").empty();
		$("#"+id+"pageChange").empty();
	}
	var pageSize = "";//页面行数全局变量
    //商品列表查询
    var Commontitle = "<th>状态</th><th>创建者</th><th>创建时间</th><th>修改者</th><th>修改时间</th><th>操作</th></tr>";//表头相同内容
    initProduct = function(pageNo,type){
    	createWindow(type,type);
    	$("#"+type).append("<table class='table table-hover table-bordered table-sm'><thead id='"+type+"goodList'></thead><tbody id='"+type+"classList'></tbody></table><span id='"+type+"pageChange'><span>");
    	emptyWindow(type);//清空商品表窗体内容
    	var arr = new Array();//新建存储数据列表容器
    	var page = "page";//请求数据参数
    	//ajax获取商品详情页信息
    	$.get(ctx+"/servlet/ProductServlet","opr="+page+"&pageNo="+pageNo+"&type="+type+"&pageSize="+pageSize,function(data){
    		arr = data.list;//将商品信息传入容器
    		var flag = true;//判断是否生成表头
    		for(i in arr){
    			var diff = "";//不同商品的数据信息
    			//相同类型的表格数据
    			var comm = "<td>"+arr[i].status+"</td><td>"+arr[i].createdBy+"</td><td>"+arr[i].createDate+"</td>" +
				"<td>"+arr[i].modifyBy+"</td><td>"+arr[i].modifyDate+"</td>"
				+"<td><a href='"+ctx+"/modify.jsp?id="+arr[i].id+"&type="+data.type+"'>修改</a>&nbsp;&nbsp;&nbsp;" +
						"<a href='"+ctx+"/stop.jsp?id="+arr[i].id+"&type="+data.type+"'>停用</a></td></tr>";
    			//根据商品信息的不同插入不同的表头及数据
				if(data.type == "Category"){
					if(flag){$("#"+type+"goodList").append("<tr><th>大类编号</th><th>大类名称</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].categoryNo+"</td><td>"+arr[i].categoryName+"</td>"
				}else if(data.type == "SubClasses"){
					if(flag){$("#"+type+"goodList").append("<tr><th>小类编号</th><th>小类名称</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].subClassesNo+"</td><td>"+arr[i].subClassesName+"</td>"
				}else if(data.type == "Color"){
					if(flag){$("#"+type+"goodList").append("<tr><th>颜色编号</th><th>颜色类型</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].colorNo+"</td><td>"+arr[i].colorName+"</td>"
				}else if(data.type == "Size"){
					if(flag){$("#"+type+"#goodList").append("<tr><th>尺寸编号</th><th>尺寸大小</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].sizeNo+"</td><td>"+arr[i].sizeName+"</td>"
				}else if(data.type == "Band"){
					if(flag){$("#"+type+"goodList").append("<tr><th>波段编号</th><th>波段</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].bandNo+"</td><td>"+arr[i].bandName+"</td>"
				}else if(data.type == "Theme"){
					if(flag){$("#"+type+"goodList").append("<tr><th>主题编号</th><th>主题</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].themeNo+"</td><td>"+arr[i].themeName+"</td>"
				}else if(data.type == "Series"){
					if(flag){$("#"+type+"goodList").append("<tr><th>款式编号</th><th>款式</th>"+Commontitle);}
					diff = "<tr><td>"+arr[i].seriesNo+"</td><td>"+arr[i].seriesName+"</td>"
				}
				flag = false;
				//拼接成完整的数据并附加到表中
				$("#"+type+"classList").append(diff + comm);
    		}
    		//商品信息分页显示
    		pageChange(data.pageNo,data.pageCount,type);
    	},"JSON");
    	return false;//阻止浏览器刷新按钮刷新
    }
    //获取btn拼接字段
    getbtn = function(index,type){
    	return "<button type='button' class='btn btn-link btn-outline-dark' onclick='initProduct("+index+",&quot;"+type+"&quot;)'>"+index+"</button>";
    }
    //获取btn-group拼接字段
    getgroup = function(btnlist){
    	return "<div class='btn-group' role='group'>"+btnlist + "</div>"
    }
    //分页显示方法
    pageChange = function(pageNo,pageCount,type){
    	$("#"+type+"pageChange").append("当前页码["+pageNo+"/"+pageCount+"]<div class='btn-toolbar' role='toolbar'><div>");//添加分页显示及按钮组父容器
    	var btnstr = "";//btn-group字符串
    	var btnlist = ""//btn-group子标签
    	if(pageCount <=5){
    		for(var i = 1;i<=pageCount;i++){
    			btnstr += getgroup(getbtn(i,type));//第一个btn-group里面的字符串
    		}
    	}else if(pageCount >5 && pageNo <4){
    		for (var i = 1; i <= pageNo +2; i++) {
    			btnlist += getbtn(i,type);
			}
    		btnstr += getgroup(btnlist);//第一个btn-group里面的字符串
    		btnstr += getgroup(getbtn(pageCount,type));//第二个btn-group里面的字符串
    	}else if(pageCount>5 && pageNo>=4 && pageNo+2<pageCount){
    		btnstr += getgroup(getbtn(1,type));//第一个btn-group里面的字符串
			for (var j = pageNo-2; j <= pageNo+2; j++) {
				btnlist += getbtn(j,type);
			}
			btnstr += getgroup(btnlist);//第二个btn-group里面的字符串
			btnstr += getgroup(getbtn(pageCount,type));//第三个btn-group里面的字符串
		}else if(pageCount>5 && pageNo >=4 && pageNo+2>=pageCount){
			btnstr += getgroup(getbtn(1,type));
			for (var k = pageNo-3; k <= pageCount; k++) {
				btnlist += getbtn(k,type);
			}
			btnstr += getgroup(btnlist);
		}
    	$("#"+type+"pageChange").children().append(btnstr);
    }
	uploadTable = function(){
		createWindow("upload","上传文件");
		$("#upload").empty();
		$("#upload").append("<form action='"+ctx+"/servlet/uploadDate' method='post' enctype='multipart/form-data'>"+
				"资料导入<input type='file' name='file'><br/><input type='submit' value='提交'/></form>");
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
