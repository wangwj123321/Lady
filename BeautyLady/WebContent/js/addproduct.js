$(function(){
	//获取上传字段单属性字段id：表单label的id type:表单的类型  propertyName:添加属性的名称 hint:提示内容
	getItem = function(propertyName,id,type,hint){
		return "<label class='col-sm-1 control-label' for='"+id+"' sytle='line-height:1.5'>"+propertyName+":</label>" +
				"<div class='col-sm-3'><input class='form-control' id='"+id+"' type='"+type+"' placeholder='"+hint+"'/></div>"
	}
	//获取formgroup拼接字段 itemsList:拼接字段属性的字符串数组
	getFormGroup = function(itemsList){
		return "<div enctype='multipart/form-data' class='form-group row' style='position:relative'>"+itemsList+"</div>";
	}
	//获取商品各属性字段fieldset title综合属性 formGroupList同类型属性
	getFieldSet =function(title,formGroupList){
		return "<fieldset><legend>"+title+"</legend>"+formGroupList+"</fieldset>";
	}
	addProduct =function(){
		createWindow("newProduct","添加新商品"," ");
		$("#newProduct").empty();
		var formGroupList1 = "";//基本信息
		var formGroupList2 = "";//商品属性
		var formGroupList3 = "";//商品图片
		var fieldsetList = "";
		formGroupList1 += getFormGroup(getItem("商品编号","proNumber","text","1JY4032020010") +getItem("商品名称","proNamer","text","长外套"));
		formGroupList1 += getFormGroup(getItem("商品价格","proPrice","text","99.00") +getItem("商品成本","proTagPrice","text","99.00"));
		formGroupList1 += getFormGroup(getItem("商品年份","proYear","text","2017") +getItem("商品季节","proSeason","text","1"));
		formGroupList2 += getFormGroup(getItem("大类编号","categoryNo","text","BY") +getItem("大类名称","categoryName","text","长外套"));
		formGroupList2 += getFormGroup(getItem("小类编号","subClassesNo","text","12") +getItem("小类名称","subClassesName","text","活动礼品"));
		formGroupList2 += getFormGroup(getItem("颜色编号","colorNo","text","123") +getItem("颜色名称","colorName","text","橘红"));
		formGroupList2 += getFormGroup(getItem("尺码编号","sizeNo","text","123") +getItem("尺码名称","sizeName","text","XXL"));
		formGroupList2 += getFormGroup(getItem("波段编号","bandNo","text","11A") +getItem("波段名称","bandName","text","11A"));
		formGroupList2 += getFormGroup(getItem("主题编号","themeNo","text","11A") +getItem("主题名称","themeName","text","11A"));
		formGroupList2 += getFormGroup(getItem("系列编号","seriesNo","text","11A") +getItem("系列名称","seriesName","text","11A"));
		formGroupList3 += getFormGroup(getItem("主图","mainpic","file",""));
		formGroupList3 += getFormGroup(getItem("小图1","pic1","file","") + getItem("小图2","pic2","file","") + getItem("小图3","pic3","file","") + getItem("小图4","pic4","file",""));
		formGroupList3 += getFormGroup(getItem("细节1","detailpic1","file","") + getItem("细节2","detailpic2","file","") + getItem("细节3","detailpic3","file",""));
		formGroupList3 += getFormGroup(getItem("放大镜1","magnifypic1","file","") + getItem("放大镜2","magnifypic2","file",""));
		formGroupList3 += getFormGroup(getItem("颜色图1","colorpic1","file","") + getItem("颜色图2","colorpic2","file",""));
		fieldsetList += getFieldSet("基本信息",formGroupList1) + getFieldSet("商品属性",formGroupList2) + getFieldSet("图片",formGroupList3);
		var formStr = "<form class='form-horizontal' role='form' style='font-size:13px'>"+fieldsetList+"<input type='submit' value='提交'/></form>";
		$("#newProduct").append(formStr);
		//遍历所有No属性
		var $idlist = $("input[id$='No']");
		$idlist.each(function(){
			/*双击击单个输入框*/
			$(this).dblclick( function() {
				var id = $(this).attr("id");
				if(!($("#"+id+"form").length >0)){
					createform(id);
					var getNumber = "getNumber";
					$.get(ctx+"/servlet/ProductServlet","opr="+getNumber+"&className="+id.substr(0,id.length-2),function(data){
						if(data == null){return;}
						for(i in data){
							$("#"+id+"form ul").append("<li class='col-2' style='color:white' ><input type='radio' name='"+id+"' value='"+data[i][id]+"'>"+data[i][id]+"<span>  "+data[i][id.substr(0,id.length-2)+"Name"]+"</span></li>")
						}
						$("#"+id+"form ul").append("<li class='col-12'><input type='button' name='"+id+"btn' value='确认'></li>")
						/*点击下拉弹框确认按钮*/
						var $sbtlist = $("input[name$='btn']");
						$sbtlist.each(function(){
							$(this).click(function(){
								var productNo = $("input[name='"+id+"']:checked").val();
								var productName = "";
								for(j in data){
									if(data[j][id] == productNo){
										productName = data[j][id.substr(0,id.length-2)+"Name"];
										break;
									}
								}
								$(this).parent().parent().parent().parent().remove();
								$("#"+id).val(productNo);
								$("#"+id.substr(0,id.length-2)+"Name").val(productName);
							});
						});
					},"JSON");
				}
			}); 
			$("#newProduct>form").submit(function(){
				var formData = new FormData($(this));
				var addProduct = "addProduct";
				$.get(ctx+"/servlet/ProductServlet","opr="+addProduct+"&formData="+formData,function(data){
					if(data){alert("上传成功")}else{alert("上传失败")};
				},"JSON")
			});
		});
		//生成下拉弹框
		createform = function(id){
			$("#"+id).parent().append("<div class='bg-dark' style='position:absolute;top:40px;width:900px;z-index:999;border:1px solid red'>" +
					"<form id='"+id+"form'><ul class='row'></ul></form></div>")
		}

	};

});