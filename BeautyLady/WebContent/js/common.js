$(function () {
    /*导航栏点击下拉弹窗*/
    $(".menu").click(function () {
        $(".main_top ul").slideToggle("slow",function () {
        })
    });
    $(window).resize(function () {
        if($(document).width()>=991){
            $(".main_top ul").css("display","block");
        }else{
        	$(".main_top ul").css("display","none");
        }
    });
    /*  随页面滚动的内容*/
    FixPosition = function () {
        $(".side_right ul").css("top",$(".main").scrollTop()+50+"px");
    };
  FixPosition();
  $(".main").scroll(function () {
      FixPosition();
  });
    /*改变右侧框样式*/
    $(".side_right ul li span:eq(0)").hover(function () {
        $(this).removeClass("fa-user-circle-o").addClass("fa-user-circle").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-user-circle").addClass("fa-user-circle-o").parent().siblings().hide();
    });
    $(".side_right ul li span:eq(1)").hover(function () {
        $(this).removeClass("fa-search-plus").addClass("fa-search").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-search").addClass("fa-search-plus");
    });
    $(".side_right ul li span:eq(2)").hover(function () {
        $(this).removeClass("fa-cart-plus").addClass("fa-shopping-cart").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-shopping-cart").addClass("fa-cart-plus").parent().siblings().hide();
    });
    $(".side_right ul li span:eq(3)").hover(function () {
        $(this).removeClass("fa-heart-o").addClass("fa-heart").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-heart").addClass("fa-heart-o").parent().siblings().hide();
    });
    $(".side_right ul li span:eq(4)").hover(function () {
        $(this).removeClass("fa-pencil-square-o").addClass("fa-pencil-square").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-pencil-square").addClass("fa-pencil-square-o").parent().siblings().hide();
    });
    $(".side_right ul li span:eq(5)").hover(function () {
        $(this).removeClass("fa-envelope-o").addClass("fa-envelope").parent().siblings().show();
    },function () {
        $(this).removeClass("fa-envelope").addClass("fa-envelope-o").parent().siblings().hide();
    });
    $(".side_right ul li span:eq(6)").hover(function () {
        $(this).parent().siblings().show();
    },function () {
        $(this).parent().siblings().hide();
    });
});


