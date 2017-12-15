package cn.beautylady.servlet;

import java.io.IOException;

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
		StorageOrderService service = new StorageOrderServiceImpl();
		String orderNo;

		try {
			orderNo = service.getOrderNo();
			request.setAttribute("orderNo", orderNo);
			request.getRequestDispatcher("/test/storageorderdetail.jsp").forward(request, response);
		} catch (Exception e) {
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
