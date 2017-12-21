$(function(){
	
	name="";//表单提交的name
	no="";//表单提交的编号名称
	
	/**
	 * 显示属性信息
	 */
	propertyModify = function(id,type){
		var opr = "getProp";
		$.get("/BeautyLady/servlet/prop","opr="+opr+"&id="+id+"&type="+type,function(data){
		$("#prop").empty();
		var propTable ="";
		var propNo = "";
		var propName = "";
		
		//根据商品信息的不同插入不同的表头及数据
		if(type == "Category"){
			propTable = "大类属性";
			propNameTable = "大类名称";
			propNo = data.categoryNo;
			propName = data.categoryName;
			name='categoryName';
			no = "categoryNo";
		}else if(type == "SubClasses"){
			propTable = "小类属性";
			propNameTable = "小类名称";
			propNo = data.subClassesNo;
			propName = data.subClassesName;
			name="subClassesName";
			no = "subClassesNo";
		}else if(type == "Color"){
			propTable = "颜色属性";
			propNameTable = "颜色名称";
			propNo = data.colorNo;
			propName = data.colorName;
			no = "colorNo";
			name="colorName";
		}else if(type == "Size"){
			propTable = "尺码属性";
			propNameTable = "尺码名称";
			propNo = data.sizeNo;
			propName = data.sizeName;;
			no = "sizeNo";
			name="sizeName";
		}else if(type == "Band"){
			propTable = "波段属性";
			propNameTable = "波段名称";
			propNo = data.bandNo;
			propName = data.bandName;
			no = "bandNo";
			name="bandName";
		}else if(type == "Theme"){
			propTable = "主题属性";
			propNameTable = "主题名称";
			propNo = data.themeNo;
			propName = data.themeName;
			no = "themeNo";
			name="themeName";
		}else if(type == "Series"){
			propTable = "系列属性";
			propNameTable = "系列名称";
			propNo = data.seriesNo;
			propName = data.seriesName;
			no = "seriesNo";
			name="seriesName";
		}
		createWindow("prop",propTable,type);
		$("#prop").append("<form class='form-horizontal' id='myFormProp' >" +
		 " <input type='hidden' class='form-control' name='id' id='exampleInputAmount1' value="+data.id+">" +
		"<div class='form-group clean'>"+
        	"<label for='exampleInputName2' class='col-sm-2 control-label left'>"+propNameTable+"</label>"+
        "<div class='col-sm-3 left'>"+
           " <input type='text' class='form-control' name="+name+" id='exampleInputAmount1' value="+propName+">" +
         "</div></div>" +
         "<div class='form-group clean' >"+
        	"<label  class='col-sm-2 control-label left'>属性编号</label>"+
        "<div class='col-sm-3 left left'>"+
           " <input type='text' class='form-control' name="+no+" id='exampleInputAmount1' value="+propNo+">" +
         "</div></div>" +
         "<div class='form-group clean'>"+
        	"<label  class='col-sm-2 control-label left'>属性状态</label>"+
        "<div class='col-sm-3 left'>"+
        isZero('status',data.status)+
         "</div></div>" +
         "<div class='form-group clean'>"+
        	"<label  class='col-sm-2 control-label left'>创建者</label>"+
        "<div class='col-sm-3 left'>"+
           " <input type='text' class='form-control' name='createdBy' id='exampleInputAmount1' readonly value="+data.createdBy+">" +
         "</div></div>" +
         "<div class='form-group clean'>"+
        	"<label  class='col-sm-2 control-label left'>创建时间</label>"+
        "<div class='col-sm-3 left'>"+
           " <input type='text' class='form-control' name='createDate' id='exampleInputAmount1' readonly value='"+data.createDate+"'>" +
         "</div></div>" +
          "<div class='form-group clean'>"+
        	"<label  class='col-sm-2 control-label left'>修改者</label>"+
        "<div class='col-sm-3 left'>"+
           " <input type='text' class='form-control' name='modifyBy' id='exampleInputAmount1' value="+isNull(data.modifyBy)+">"+
         "</div></div>" +
         "<div class='form-group clean'>"+
        	"<label  class='col-sm-2 control-label left'>修改时间</label>"+
        "<div class='col-sm-3 left'>"+
           " <input type='text' class='form-control' name='modifyDate' id='exampleInputAmount1' value='"+isNull(data.modifyDate)+"'>" +
         "</div></div>" +
         "<div class='clean'></div>"+
         "<button type='button' class='btn btn-default' onclick=\"modify('"+userName+"','"+type+"',"+data.id+",'"+propName+"','"+propNo+"','"+data.createdBy+"','"+data.createDate+"','"+userName+"','"+isNull(data.modifyDate)+"')\">Submit</button>"+
    	"</form>");
		},"JSON");
	}
	
	/**
	 * 提交修改
	 */
	modify = function (userName,type,id,propName,propNo,createdBy,createDate,modifyBy,modifyDate){
		var status = $($("[name='status']:checked")[0]).val();
		$.post("/BeautyLady/servlet/prop","opr=modify&userName="+userName+"&type="+type+"&id="+id+"&"+name+"="+propName+"&"+no+"="+propNo+"&status="+status+"&createdBy="+createdBy+"&createDate="+createDate+"&modifyBy="+modifyBy+"&modifyDate="+modifyDate,callModify);
	}
	
	/**
	 * 打印修改是否成功
	 */
	function callModify(data){
		createWindow("prop","属性");
		$("#prop").empty();
		$("#prop").html(data);
	}
	
	/**
	 * 打印默认的选择
	 */
	isZero = function (key,status){
		if(status == 0 || status == null){
			var str ="<label class='radio-inline'>"+
		  "<input type='radio' name="+key+" id='inlineRadio1' value='0' checked> 使用"+
			"</label>"+
		"<label class='radio-inline'>"+
		  "<input type='radio' name="+key+" id='inlineRadio2' value='1'> 停用"+
			"</label>";
		}else {
			var str ="<label class='radio-inline'>"+
		  	"<input type='radio' name="+key+" id='inlineRadio1' value='0' > 使用"+
			"</label>"+
			"<label class='radio-inline'>"+
		  	"<input type='radio' name="+key+" id='inlineRadio2' value='1' checked> 停用"+
			"</label>";
		}
		return str;
	}
	
	/**
	 * 如何值为空，或者为undefined，则输出空
	 */
	isNull = function(value){
		if(value == null || value == "" || value == undefined){
			return "";
		}else {
			return value;
		}
	}

});