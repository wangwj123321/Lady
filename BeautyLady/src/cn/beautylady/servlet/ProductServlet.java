package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.beautylady.entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.beautylady.entity.Page;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.util.ClassNameUtil;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/servlet/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService=new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*String pageNo = request.getParameter("pageNo");
		String type = request.getParameter("type");
		ProductService ps = new ProductServiceImpl();
		PrintWriter out = response.getWriter();
		Class clazz;
		try {
			clazz = Class.forName(ClassNameUtil.getClassName(type));
			Page page = ps.getPageObj(Integer.parseInt(pageNo), 20, clazz);
			String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd", SerializerFeature.WriteNullListAsEmpty);
			out.print(json);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		String opr=request.getParameter("opr");
		if ("getListProduct".equals(opr)) {
			String key=request.getParameter("key");
			String value=request.getParameter("value");
			String order=request.getParameter("order");
			String pageNO=request.getParameter("pageNO");
			int pn=1;
			Map<String, Object> map=new HashMap<String, Object>();
			if (key!=null && key!="") {
				map.put(key, value);
			}
			Page<Product> page=new Page<>();
			if (pageNO!=null) {
				pn=Integer.parseInt(pageNO);
			}
			page.setPageNo(pn);
			page.setPageSize(24);
			productService.getListProduct(page, map, order);
			ServletContext application=request.getServletContext();
			application.setAttribute("ProductPage", page);
			application.setAttribute("order", order);
			application.setAttribute("key", key);
			application.setAttribute("value", value);
			response.sendRedirect("../index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
