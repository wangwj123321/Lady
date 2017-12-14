<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/car2.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/car2.js"></script>
</head>
<body>
    <div id="top"><a href=""><img src="images/ochirly.png" alt=""></a>	<span>张三 ,您好！&nbsp;&nbsp;<a href="">退出<span>购物车（0）</span></a></span></div>
    <div id="gwd"><img src="images/car2.png" alt=""><br></div>
    <p>订单确认</p>
    <div id="order_content">
        <div id="order_left">
            <h3>确定收货地址</h3>
            <div>
                <p>姓名：刘耀辉</p>
                <p>电话：13318786412</p>
                <p>地址：广东省广州市海珠区南极路315号</p>
            </div>
                <table>
                    <form action="servlet/AddressServlet?opr=addAdderss" id="aa">
                        <tr>
                            <td>姓名：</td>
                            <td><input type="text" name="name"/></td>
                        </tr>
                        <tr>
                            <td>电话：</td>
                            <td><input type="text" name="phone"/></td>
                        </tr>
                        <tr>
                            <td>地址：</td>
                            <td><input type="text" name="address"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>设置默认地址 &nbsp;<input type="checkbox" name=""/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" id="addBtu"/></td>
                        </tr>
                    </form>
                </table>

        </div>

        <div id="order_right">
			
        </div>
    </div>
</body>
</html>