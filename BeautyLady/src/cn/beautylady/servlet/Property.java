package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.beautylady.service.ProductService;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.util.ClassNameUtil;
import cn.beautylady.util.JavaBeanUtil;

/**
 * Servlet implementation class Property
 */
@WebServlet("/servlet/prop")
public class Property extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductServiceImpl();
		String opr = request.getParameter("opr");
		/**
		 * 获取商品属性
		 */
		if("getProp".equals(opr)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String type = request.getParameter("type");
			Class<?> clazz;
			try {
				clazz = Class.forName(ClassNameUtil.getClassName(type));
				Object obj = service.getProperty(clazz, id);
				System.out.println(obj);
				String jsonData = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
				PrintWriter out = response.getWriter();
				out.println(jsonData);
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/**
		 * 获取用户提交修改的数据
		 */
		else if("modify".equals(opr)) {
			try {
				Class clazz = Class.forName(ClassNameUtil.getClassName(request.getParameter("type")));
				Object obj = JavaBeanUtil.populate(clazz, request.getParameterMap());
				int result = service.updateProperty(obj);
				PrintWriter out = response.getWriter();
				if(result > 0) {
					out.println("修改成功");
				}else {
					out.println("修改失败");
				}
				out.close();
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
