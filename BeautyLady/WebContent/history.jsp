<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/collect.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/collect.js"></script>
</head>
<body>
    <div id="top"><a href=""><img src="images/ochirly.png" alt=""></a>	<%-- <span>${sessionScope.loginUser } ,您好！&nbsp;&nbsp;<a href="servlet/UserServlet?opr=exitLogin">退出</a></span> --%></div>
    <div id="coll">
    	<h4>您最近浏览的历史</h4>
        <ul id="collect_list">
        	<c:forEach var="history" items="${sessionScope.histroys }">
	        	<li>
	                <a href="servlet/ProductServlet?opr=productDetail&productNo=${history.productNo }"><img src="images/${history.picpath }" alt=""></a>
	                <p>${history.productName } ${history.productNo }</p>
	                <p>￥<span>${history.tagPrice }</span></p>
	                <p class="del">删除</p>
	            </li>
        	</c:forEach>
        </ul>
    </div>
    <div id="fotter">
        <h3>tyj有限公司</h3>
        <p>隐私申明 联系我们</p>
        <p>Copyright @ 2010-2017 广州赫基信息科技有限公司版权所有 增值电信业务经营许可证 粤B2-20100553 粤ICP备10229258-1号</p>
    </div>
</body>
</html>