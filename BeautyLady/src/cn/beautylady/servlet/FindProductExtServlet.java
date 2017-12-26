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

import cn.beautylady.entity.Page;
import cn.beautylady.entity.Product;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.service.ProductExtService;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.StorageOrderService;
import cn.beautylady.service.impl.ProductExtServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.service.impl.StorageOrderServiceImpl;
import cn.beautylady.util.ClassNameUtil;

/**
 * Servlet implementation class FindProductExt
 */
@WebServlet("/servlet/getProductExt")
public class FindProductExtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if(opr == null ) {
			opr="findAllProExt";
		}
		ProductExtService extService = new ProductExtServiceImpl();
		ProductService proService = new ProductServiceImpl();
		if("findAllProExt".equals(opr)) {
			String produectExt = request.getParameter("type");
			try {
				String className = ClassNameUtil.getClassName(produectExt);
				Class clazz = Class.forName(className);
				Page<ProductExt> page = proService.getPageObj(Integer.parseInt(request.getParameter("pageNo")),Integer.parseInt( request.getParameter("pageSize")), clazz);
				PrintWriter out = response.getWriter();
				if(page != null && page.getList().size()>0) {
					String jsonData = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss");
					out.println(jsonData);
				}else {
					out.println(false);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
