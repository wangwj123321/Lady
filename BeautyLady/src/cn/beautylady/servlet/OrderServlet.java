package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.BuyCar;
import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;
import cn.beautylady.entity.Page;
import cn.beautylady.entity.User_orders;
import cn.beautylady.service.BuyCarService;
import cn.beautylady.service.OrderService;
import cn.beautylady.service.User_ordersService;
import cn.beautylady.service.impl.BuyCarServiceImpl;
import cn.beautylady.service.impl.ColorServiceImpl;
import cn.beautylady.service.impl.OrderServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.service.impl.SizeServiceImpl;
import cn.beautylady.service.impl.User_ordersServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/servlet/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService orderService=new OrderServiceImpl();
    private BuyCarService buyCarService=new BuyCarServiceImpl();
    private User_ordersService user_ordersService = new User_ordersServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String opr=request.getParameter("opr");
		String json="";
		if ("addOrder".equals(opr)) {
			List<BuyCar> list=(List<BuyCar>) request.getSession().getAttribute("detailList");
			List<OrderDetail> details=new ArrayList<>();
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			String userName=(String) request.getSession().getAttribute("loginUser");
			int addressID=Integer.parseInt(request.getParameter("addressID"));
			double costPrice=Double.parseDouble(request.getParameter("costPrice"));
			String orderNo="";
			while (true) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
				Date date = new Date();
				String nn = sdf.format(date);
				Random random = new Random();
				int ran = random.nextInt(1000);
				orderNo = nn + ran;
				Order order=orderService.getOrderByOrderNo(orderNo);
				if (order==null) {
					break;
				}
			}
			Order order=new Order(null, orderNo, userAccount, userName, addressID, null, costPrice, null);
			if (orderService.addOrder(order)) {
				System.out.println("添加订单成功");
				Order lastOrder=orderService.getUserAccountLastOrder(userAccount);
				for (BuyCar buyCar : list) {
					OrderDetail detail=new OrderDetail(null, lastOrder.getOrderNo(), buyCar.getColorNo(), buyCar.getSizeNo(), buyCar.getProductNo(), buyCar.getTagPrice(), buyCar.getCount(), buyCar.getAmount(), buyCar.getZk());
					orderService.addOrderDetail(detail);
					buyCarService.updateBuyCarStatus(buyCar.getId());
				}
				request.getSession().setAttribute("newOrder", lastOrder);
				response.sendRedirect("../car3.jsp");
			}
		}else if("getOrderByUser".equals(opr)){
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			List<Order> orderList = orderService.getOrderByUserAccount(userAccount);
			for (Order order : orderList) {
				order.setUser_Orders(user_ordersService.getUser_ordersByorderNo(order.getOrderNo()));
			}
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("/userMain.jsp").forward(request, response);
		}else if("OrderDetail".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			User_orders orderDetail = null;
			try {
				orderDetail = user_ordersService.getgetUser_ordersById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("orderDetail", orderDetail);
			request.getRequestDispatcher("/userMain.jsp").forward(request, response);
		}else if("updateOrderStatus".equals(opr)) {
			int id=Integer.parseInt(request.getParameter("id"));
			int status=Integer.parseInt(request.getParameter("status"));
			if (orderService.updateOrderStatus(id, status)) {
				response.sendRedirect("../pay.jsp");
			}
		}else if("getListOrder".equals(opr)) {
			int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			Page<Order> page=new Page<>();
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			orderService.getListOrder(page);
			json=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:mm:ss");
			out.print(json);
		}else if("getUser_ordersByOrderNo".equals(opr)) {
			String orderNo=request.getParameter("orderNo");
			List<User_orders> list=user_ordersService.getUser_ordersByorderNo(orderNo);
			json=JSON.toJSONString(list);
			out.print(json);
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
