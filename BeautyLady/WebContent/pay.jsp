<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/car3.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
    	var s=5;
    	$(document).ready(function(){
    		setInterval("bbb()",1000);
    	});
		function bbb(){
			if(s==1){
				location.href="index.jsp";
			}
			$("#hint").text(s+"秒后跳转首页");
			s=s-1;
		}
    </script>
</head>
<body>
	<div id="top"><a href="index.jsp">Beauty <span>Lady</span></a>	<span>${sessionScope.loginUser } ,您好！&nbsp;&nbsp;<a href="">退出<span>购物车</span></a></span></div>
	<div id="complete">
        <div id="comp_img"><img src="images/comp.png" alt=""></div>
        <div id="order_no">
            <h2>订单已支付，感谢惠顾！</h2>
            <p id="hint"></p>
        </div>
    </div>
	<div id="fotter">
        <h3>tyj有限公司</h3>
        <p>隐私申明 联系我们</p>
        <p>Copyright @ 2010-2017 广州赫基信息科技有限公司版权所有 增值电信业务经营许可证 粤B2-20100553 粤ICP备10229258-1号</p>
    </div>
</body>
</html>