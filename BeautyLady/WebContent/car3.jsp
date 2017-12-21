<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/car3.css">
</head>
<body>
    <div id="top"><a href="index.jsp"><img src="images/ochirly.png" alt=""></a>	<span>${sessionScope.loginUser } ,您好！&nbsp;&nbsp;<a href="">退出<span>购物车</span></a></span></div>
    <div id="complete">
        <div id="comp_img"><img src="images/comp.png" alt=""></div>
        <div id="order_no">
            <h2>订单已生成，请继续完成支付！</h2>
            <p>订单编号：<span>${sessionScope.newOrder.orderNo } </span>支付金额：<b>￥<span>${sessionScope.newOrder.costPrice }</span></b></p>
        </div>
    </div>
    <div id="ch_pay">
        <p>你需要支付：<b>￥${sessionScope.newOrder.costPrice }</b>元，请选择：</p>
        <div id="pay">
            <img src="images/zfb.png" alt="">
            <img src="images/wx.png" alt="">
            <img src="images/xyyh.png" alt="">
        </div>
        <p>支付 <b>￥${sessionScope.newOrder.costPrice }</b></p>
        <p><a href="servlet/OrderServlet?opr=updateOrderStatus&id=${sessionScope.newOrder.id }&status=1" id="pay_btn">支付</a></p>
    </div>
    <div id="fotter">
        <h3>tyj有限公司</h3>
        <p>隐私申明 联系我们</p>
        <p>Copyright @ 2010-2017 广州赫基信息科技有限公司版权所有 增值电信业务经营许可证 粤B2-20100553 粤ICP备10229258-1号</p>
    </div>
</body>
</html>