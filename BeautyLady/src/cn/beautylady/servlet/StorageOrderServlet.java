package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.StorageOrder;
import cn.beautylady.service.StorageOrderService;
import cn.beautylady.service.impl.StorageOrderServiceImpl;

/**
 * Servlet implementation class StorageOrder
 */
@WebServlet("/servlet/storageOrder")
public class StorageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StorageOrderService service = new StorageOrderServiceImpl();
		String opr=request.getParameter("opr");
		/**
		 * 查找所有的入库订单
		 */
		if("findOrder".equals(opr)) {
			try {
				List<StorageOrder> list = service.getAllStorageOrder();
				String jsonData = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");
				PrintWriter out = response.getWriter();
				out.println(jsonData);
				out.close();
			} catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException
					| InvocationTargetException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 删除订单
		 */
		else if("del".equals(opr)) {
			String orderNo = request.getParameter("orderNo");
			int result = service.delStorageOrder(orderNo);
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println(true);
			}else {
				out.println(false);
			}
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
