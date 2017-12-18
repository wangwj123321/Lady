package cn.beautylady.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.service.StorageOrderService;
import cn.beautylady.service.impl.StorageOrderServiceImpl;



/**
 * Servlet implementation class AddStorageOrderDetail
 * 
 */
@WebServlet("/servlet/addStorageOrder")
public class AddStorageOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ss =  request.getParameter("pNo");
		System.out.println(ss);
		String[] productNos = request.getParameter("pNo").split(",");
		String[] colorNos = request.getParameter("cNo").split(",");
		String[] sizeNos = request.getParameter("sNo").split(",");
		String[] numbers = request.getParameter("num").split(",");
		String[] totalMoneys = request.getParameter("money").split(",");
		String order = request.getParameter("so");
		String desc = request.getParameter("ds");
		String userName = "admit";
		StorageOrderService service = new StorageOrderServiceImpl();
		try {
			service.addStorageOrder(userName,productNos,colorNos,sizeNos,numbers,totalMoneys,order,desc);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
