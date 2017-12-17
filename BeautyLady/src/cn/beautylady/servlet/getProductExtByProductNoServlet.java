package cn.beautylady.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.entity.Pic;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.service.ProductExtService;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.impl.ProductExtServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class getProductExtByProductNoServlet
 */
@WebServlet("/servlet/getProductExtByProductNo")
public class getProductExtByProductNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productNo = request.getParameter("productNo");
		System.out.println(productNo);
		ProductExtService service = new ProductExtServiceImpl();
		ProductService productService = new ProductServiceImpl();
		try {
			ProductExt ext = service.getProductExt(productNo);
			List<Pic> pics = productService.getPicListByProductNo(productNo);
			String colorName = request.getParameter("colorName");
			if(colorName == null) {
				colorName = "米白";
				System.out.println(colorName);
			}
			request.setAttribute("pics", pics);
			request.setAttribute("product", ext);
			request.setAttribute("colorName", colorName);			
			request.getRequestDispatcher("/test/productdetial.jsp").forward(request, response);
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
