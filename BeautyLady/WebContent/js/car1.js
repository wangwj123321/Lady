$(document).ready(function(){
	/*全选按妞点击事件 */
    $("#allch").click(function(){
        var isChecked = $('#allch').is(":checked");
        if(isChecked){
            $("[name='ch']").prop("checked",true);
            count();
            getTotal();
        }else{
            $("[name='ch']").prop("checked",false);
            $("#count").text("0");
            $("b").text("0");
        }
    });
    /*数量改变事件*/
    $("[type='number']").bind("input",function(){
        var index=$(this).attr("id");
        var price= parseInt($(this).parent().prev().find("span").text());
        var num=$(this).val();
        var id=$(this).attr("class");
        var total=price*num;
        $.get("servlet/BuyCarServlet","opr=updateCount&id="+id+"&count="+num);
        $(this).parent().next().find("span").text(total);
        count();
        getTotal();
    });
    /*选中商品*/
    $("[name='ch']").click(function(){
        count();
        getTotal();
    });
    /*删除按妞点击事件*/
    $("#del_ch").click(function(){
        var ch=$("[name='ch']");
        $(ch).each(function(i,t){
            var isChecked=$(t).is(":checked");
            if(isChecked){
            	var id=$(t).attr("class");
                $.get("servlet/BuyCarServlet","opr=delBuyCar&id="+id);
                $(t).parent().parent().remove();
            }
        });
        count();
        getTotal();
    });
});
/*计算商品总共多少件*/
function count(){
    var counts=$("[type='number']");
    var count=0;
    $(counts).each(function(i,t){
        var a=$(t).parent().parent().find("[name='ch']");
        var isChecked = a.is(":checked");
        if(isChecked){
            var number=parseInt($(t).val());
            count=count+number;
        }
    });
    $("#count").text(count);
}
/*计算所有商品总共多少钱*/
function getTotal(){
    var prices= $(".p_t");
    var total=0;
    $(prices).each(function(i,t){
        var a=$(t).parent().parent().find("[name='ch']");
        var isChecked = a.is(":checked");
        if(isChecked){
            var price=parseFloat($(t).text());
            total=total+price;
        }
    });
    $("b").text(total);
}