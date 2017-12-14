package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.Product;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.service.ProductExtService;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.impl.ProductExtServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class FindProductExt
 */
@WebServlet("/servlet/getProductExt")
public class FindProductExtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		ProductExtService service = new ProductExtServiceImpl();
		ProductExt productExt;
		try {
			productExt = service.getProductExt(productNo);
			System.out.println(productExt);
			String jsonData = JSON.toJSONStringWithDateFormat(productExt, "yyyy-MM-dd");
			PrintWriter out = response.getWriter();
			out.print(jsonData);
			out.flush();
			out.close();
		} catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException | SQLException e) {
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
