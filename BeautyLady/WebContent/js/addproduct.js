$(function(){
	//获取上传字段单属性字段id：表单label的id type:表单的类型  propertyName:添加属性的名称,name:表单name属性 hint:提示内容
	getItem = function(propertyName,id,type,name,hint){
		return "<label class='col-sm-1 control-label' for='"+id+"' sytle='line-height:1.5'>"+propertyName+":</label>" +
				"<div class='col-sm-3'><input class='form-control' id='"+id+"' type='"+type+"' name='"+name+"' placeholder='"+hint+"' autocomplete='off'/></div>"
	}
	//获取formgroup拼接字段 itemsList:拼接字段属性的字符串数组
	getFormGroup = function(itemsList){
		return "<div class='form-group row' style='position:relative'>"+itemsList+"</div>";
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
		formGroupList1 += getFormGroup(getItem("创建者","userName","text","userName","???") + getItem("商品编号","proNumber","text","proNumber","1JY4032020010") +getItem("商品名称","proName","text","proName","长外套"));
		formGroupList1 += getFormGroup(getItem("商品成本","proPrice","text","proPrice","99.00") +getItem("商品价格","proTagPrice","text","proTagPrice","99.00"));
		formGroupList1 += getFormGroup(getItem("商品年份","proYear","text","proYear","2017") +getItem("商品季节","proSeason","text","proSeason","1"));
		formGroupList2 += getFormGroup(getItem("大类编号","categoryNo1","text","categoryNo","BY") +getItem("大类名称","categoryName1","text","categoryName","长外套"));
		formGroupList2 += getFormGroup(getItem("小类编号","subClassesNo1","text","subClassesNo","12") +getItem("小类名称","subClassesName1","text","subClassesName","活动礼品"));
		formGroupList2 += getFormGroup(getItem("颜色编号1","colorNo1","text","colorNo1","123") +getItem("颜色名称1","colorName1","text","colorName1","橘红"));
		formGroupList2 += getFormGroup(getItem("颜色编号2","colorNo2","text","colorNo2","123") +getItem("颜色名称2","colorName2","text","colorName2","橘红"));
		formGroupList2 += getFormGroup(getItem("尺码编号","sizeNo1","text","sizeNo","123") +getItem("尺码名称","sizeName1","text","sizeName","XXL"));
		formGroupList2 += getFormGroup(getItem("波段编号","bandNo1","text","bandNo","11A") +getItem("波段名称","bandName1","text","bandName","11A"));
		formGroupList2 += getFormGroup(getItem("主题编号","themeNo1","text","themeNo","11A") +getItem("主题名称","themeName1","text","themeName","11A"));
		formGroupList2 += getFormGroup(getItem("系列编号","seriesNo1","text","seriesNo","11A") +getItem("系列名称","seriesName1","text","seriesName","11A"));
		formGroupList3 += getFormGroup(getItem("主图","mainpic","file","mainpic",""));
		formGroupList3 += getFormGroup(getItem("小图1","pic1","file","pic1","") + getItem("小图2","pic2","file","pic2","") + getItem("小图3","pic3","file","pic3","") + getItem("小图4","pic4","file","pic4",""));
		formGroupList3 += getFormGroup(getItem("细节1","detailpic1","file","detailpic1","") + getItem("细节2","detailpic2","file","detailpic2","") + getItem("细节3","detailpic3","file","detailpic3",""));
		formGroupList3 += getFormGroup(getItem("放大镜1","magnifypic1","file","magnifypic1","") + getItem("放大镜2","magnifypic2","file","magnifypic2",""));
		formGroupList3 += getFormGroup(getItem("颜色图1","colorpic1","file","colorpic1","") + getItem("颜色图2","colorpic2","file","colorpic2",""));
		fieldsetList += getFieldSet("基本信息",formGroupList1) + getFieldSet("商品属性",formGroupList2) + getFieldSet("图片",formGroupList3);
		var formStr = "<form enctype='multipart/form-data' action='"+ctx+"/servlet/AddProductServlet' method='post' class='form-horizontal' role='form' style='font-size:13px'>"+fieldsetList+"<input type='submit' name='sbtForm' value='提交'/></form>";
		$("#newProduct").append(formStr);
		$("input[name='userName'").val(userName).parent().addClass("d-none").prev().addClass("d-none");
		//添加年份可能值
		$("input[name='proYear'").attr("list","year").append("<datalist id='year'><option value='2016'><option value='2017'><option value='2018'><option value='2019'><option value='2020'><option value='2021'></datalist>");
		//添加季节可能值
		$("input[name='proSeason'").attr("list","season").append("<datalist id='season'><option value='1'><option value='2'><option value='3'><option value='4'></datalist>");
		//表单验证
		var $input = $("#newProduct>form input:lt(7),#newProduct>form input:odd,#newProduct>form input:gt(22)");//所有不为空的表单
		var retEmpty = /^\S$/;//非空字符
		var retNum = /^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;//验证价格
		var retYear = /^(2[0-9]{3})$/;//匹配年份
		var retSeason = /^[1-4]$/;//匹配年份
		$input.each(function(){
			$(this).blur(function(){
				if($(this).val() == ""){
					$(this).val("").attr("placeholder","该项不能为空");
				}
				if($(this).attr("name") == "proPrice"){
					if(!retNum.test($(this).val())){
						$(this).val("").attr("placeholder","价格必须为是数值");
					}
				}
				if($(this).attr("name") == "proYear"){
					if(!retYear.test($(this).val())){
						$(this).val("").attr("placeholder","年份必须是以2开头的4位整数");
					}
				}
				if($(this).attr("name") == "proSeason"){
					if(!retSeason.test($(this).val())){
						$(this).val("").attr("placeholder","季节必须是1~4的整数");
					}
				}
				checkForm();
			});
		});
		checkForm = function(){
			var flag = true;
			$input.each(function(){
				if($(this).val() == ""){
					flag = false;
				}
				if($(this).attr("name") == "proPrice"){
					if(!retNum.test($(this).val())){
						flag = false;
					}
				}
				if($(this).attr("name") == "proYear"){
					if(!retYear.test($(this).val())){
						flag = false;
					}
				}
				if($(this).attr("name") == "proSeason"){
					if(!retSeason.test($(this).val())){
						flag = false;
					}
				}
			});
			if(!flag){
				$("input[name='sbtForm']").attr("disabled",'disabled');;
			}else{
				$("input[name='sbtForm']").removeAttr("disabled");
			}
		};
		checkForm();
		//遍历所有文本框name属性值里带有No标签
		var $idlist = $("input[id*='No']");
		$idlist.each(function(){
			/*双击击单个输入框*/
			$(this).dblclick( function() {
				var id = $(this).attr("id");
				if(!($("#"+id+"form").length >0)){
					createform(id);//创建form结构
					var getNumber = "getNumber";
					$.get(ctx+"/servlet/ProductServlet","opr="+getNumber+"&className="+id.substr(0,id.length-3),function(data){
						if(data == null){return;}
						for(i in data){
							$("#"+id+"form ul").append("<li class='col-2' style='color:white' ><input type='radio' name='"+id+"' value='"+data[i][id.substr(0,id.length-1)]+"'>"+data[i][id.substr(0,id.length-1)]+"<span>  "+data[i][id.substr(0,id.length-3)+"Name"]+"</span></li>")
						}
						$("#"+id+"form ul").append("<li class='col-12'><input type='button' name='"+id+"btn' value='确认'></li>")
						/*点击下拉弹框确认按钮*/
						var $sbtlist = $("input[name$='btn']");
						$sbtlist.each(function(){
							$(this).click(function(){
								var productNo = $("input[name='"+id+"']:checked").val();
								var productName = "";
								for(j in data){
									if(data[j][id.substr(0,id.length-1)] == productNo){
										productName = data[j][id.substr(0,id.length-3)+"Name"];
										break;
									}
								}
								$(this).parent().parent().parent().parent().remove();
								$("#"+id).val(productNo);
								$("#"+id.substr(0,id.length-3)+"Name"+id.substr(id.length-1)).val(productName);
							});
						});
					},"JSON");
				}
			}); 
			$("#newProduct>form").submit(function(){
				var formData = new FormData($(this)[0]);
				$.get(ctx+"/servlet/AddProductServlet",formData,function(data){
					alert(data);
				},"JSON")
			});
		});
		//生成下拉弹框
		createform = function(id){
			$("#"+id).parent().append("<div class='bg-dark' style='position:absolute;top:40px;width:900px;height:150px;overflow:auto;overflow-x:hidden;z-index:999;border:1px solid red'>" +
					"<form id='"+id+"form'><ul class='row'></ul></form></div>")
		}

	};

});