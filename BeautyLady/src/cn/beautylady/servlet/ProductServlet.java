package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import cn.beautylady.entity.*;

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
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String pageNo = request.getParameter("pageNo");
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
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
