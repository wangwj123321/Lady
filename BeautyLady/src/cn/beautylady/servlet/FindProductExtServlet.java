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
import com.alibaba.fastjson.JSONArray;

import cn.beautylady.entity.Product;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.service.ProductExtService;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.StorageOrderService;
import cn.beautylady.service.impl.ProductExtServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.service.impl.StorageOrderServiceImpl;

/**
 * Servlet implementation class FindProductExt
 */
@WebServlet("/servlet/getProductExt")
public class FindProductExtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNos = request.getParameter("productNos");
		String[] nos = productNos.split(",");
		StorageOrderService order = new StorageOrderServiceImpl();
		try {
			List<ProductExt> exts =order.getProductExtByNos(nos);
			System.out.println(exts);
			String jsonExts = JSON.toJSONStringWithDateFormat(exts, "yyyy-MM-dd");
			PrintWriter out = response.getWriter();
			out.println(jsonExts);
			out.flush();
			out.close();
		} catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException | SQLException e) {
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
