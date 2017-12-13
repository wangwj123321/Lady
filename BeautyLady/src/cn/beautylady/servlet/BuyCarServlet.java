package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.entity.BuyCar;
import cn.beautylady.service.BuyCarService;
import cn.beautylady.service.impl.BuyCarServiceImpl;

/**
 * Servlet implementation class BuyCarServlet
 */
@WebServlet("/servlet/BuyCarServlet")
public class BuyCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BuyCarService buyCarService=new BuyCarServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String opr=request.getParameter("opr");
		if ("addBuyCar".equals(opr)) {
			String colorNo=request.getParameter("colorNo");
			String sizeNo=request.getParameter("sizeNo");
			String productNo=request.getParameter("productNo");
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			String userName=(String) request.getSession().getAttribute("loginUser");
			String zk=request.getParameter("zk");
			Double tagPrice=Double.parseDouble(request.getParameter("tagPrice"));
			double zk0=1;
			boolean flag=false; //用户判断用户是否已经把该商品添加到购物车，如果已经添加了，就在购物车表里的数量+1，否则添加该购物车记录
			BuyCar isExistBuyCar=buyCarService.getBuyCar(productNo, userAccount,colorNo,sizeNo);
			if (isExistBuyCar!=null) {
				flag=true;
			}
			if (zk!=null && !zk.equals("")) {
				zk0=Double.parseDouble(zk);
			}
			if (userName==null) {
				out.print("noLogin");
				return;
			}
			BuyCar buyCar=new BuyCar(null, colorNo, sizeNo, productNo, userAccount, null, null, tagPrice, zk0, (tagPrice*zk0), userName, null);
			
			if (flag) {
				if(buyCarService.updateBuyCarCount(isExistBuyCar.getId())) {
					out.print("true");
				}else {
					out.print("false");
				}
			}else {
				if (buyCarService.addBuyCar(buyCar)) {
					out.print("true");
				}else {
					out.print("false");
				}
			}
		}else if("getUserCar".equals(opr)) {
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			if(userAccount==null) {
				response.sendRedirect("../login.jsp");
				return;
			}
			List<BuyCar> list=buyCarService.getBuyCarByUserAccount(userAccount);
			request.setAttribute("list", list);
			request.getRequestDispatcher("../car1.jsp").forward(request, response);
		}else if("delBuyCar".equals(opr)) {
			int id=Integer.parseInt(request.getParameter("id"));
			if (buyCarService.delBuyCar(id)) {
				out.print("true");
			}else {
				out.print("false");
			}
		}else if("updateCount".equals(opr)) {
			int id=Integer.parseInt(request.getParameter("id"));
			int count=Integer.parseInt(request.getParameter("count"));
			if (buyCarService.updateCount(id, count)) {
				out.print("true");
			}else {
				out.print("false");
			}
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
