
$(function(){

	addProduct = function(){
		$("#product").empty();
		createWindow("product","添加商品");
		$("#product").append("<form class='form-horizontal' enctype ='multipart/form-data' role='form'>"+
    "<fieldset>"+
        "<legend>基本信息</legend>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_host'>商品编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_host' type='text' placeholder='1JY4032020010'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_name'>商品名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_name' type='text' placeholder='长外套'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_username'>商品价格</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_username1' type='text' placeholder='root'/>"+
            "</div>"+
           " <label class='col-sm-1 control-label' for='ds_password'>商品成本</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password2' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_username'>商品年份</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_username' type='text' placeholder='root'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>商品季节</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password3' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
    "</fieldset>"+
    "<fieldset>"+
        "<legend>商品属性</legend>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>大类编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password1' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>大类名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password1' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小类编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小类名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>颜色编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password8' type='password' placeholder='123456'/>"+
            "</div>"+
           " <label class='col-sm-1 control-label' for='ds_password'>颜色名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>尺码编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password9' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>尺码名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>波段编号</label>"+
            "<div class='col-sm-2'>"+
               "<input class='form-control' id='ds_password10' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>波段名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>主题编号</label>"+
           "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password11' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>主题名称</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
           "<label class='col-sm-1 control-label' for='ds_password'>系列编号</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password12' type='password' placeholder='123456'/>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>系列</label>"+
            "<div class='col-sm-2'>"+
                "<input class='form-control' id='ds_password7' type='password' placeholder='123456'/>"+
            "</div>"+
        "</div>"+
    "</fieldset>"+

    "<fieldset>"+
        "<legend>图片</legend>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>主图</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
       " </div>"+
       " <div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小图1</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小图2</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小图3</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>小图4</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
        "</div>"+
        "<div class='form-group row'>"+
            "<label class='col-sm-1 control-label' for='ds_password'>细节1</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>细节2</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+

            "</div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>细节3</label>"+
            "<div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
           "</div>"+
        "</div>"+
        "<div>"+
            "<label class='col-sm-1 control-label' for='ds_password'>放大镜</label>"+
           " <div class='col-sm-2'>"+
                "<input type='file' id='exampleInputFile'>"+
            "</div>"+
        "</div>"+
    "</fieldset>"+
    "<input type='button' onclick='addProp()'/>"+
"</form>");
}

addProp = function(){
}


});