package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.beautylady.entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.beautylady.entity.Page;
import cn.beautylady.service.ColorService;
import cn.beautylady.service.ProductExtService;
import cn.beautylady.service.ProductService;
import cn.beautylady.service.SizeService;
import cn.beautylady.service.impl.ColorServiceImpl;
import cn.beautylady.service.impl.ProductExtServiceImpl;
import cn.beautylady.service.impl.ProductServiceImpl;
import cn.beautylady.service.impl.SizeServiceImpl;
import cn.beautylady.util.ClassNameUtil;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/servlet/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService=new ProductServiceImpl();
	private ColorService colorService=new ColorServiceImpl();
	private SizeService sizeService=new SizeServiceImpl();
	private ProductExtService productExtService=new ProductExtServiceImpl();
       
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
		ProductExtService extService = new ProductExtServiceImpl();
		String opr=request.getParameter("opr");
		String pageNo = request.getParameter("pageNo");
		String type = request.getParameter("type");
		String pageSize = request.getParameter("pageSize");
		if(pageSize == null || "".equals(pageSize)){
			pageSize = "20";
		}
		ProductService ps = new ProductServiceImpl();
		PrintWriter out = response.getWriter();
		if("page".equals(opr)){
			Class clazz;
			try {
				clazz = Class.forName(ClassNameUtil.getClassName(type));
				Page page = ps.getPageObj(Integer.parseInt(pageNo), Integer.parseInt(pageSize), clazz);
				String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd", SerializerFeature.WriteNullListAsEmpty);
				out.print(json);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else if("pageChange".equals(opr)){
			out.print(true);
		}else if("getListProduct".equals(opr)) {
			String key=request.getParameter("key");
			String value=request.getParameter("value");
			String order=request.getParameter("order");
			String pageNO=request.getParameter("pageNO");
			int pn=1;
			Map<String, Object> map=new HashMap<String, Object>();
			if (key!=null && !"".equals(key)) {
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
		}else if("productDetail".equals(opr)) {
			/*Integer proId=Integer.parseInt(request.getParameter("proId"));
			Product product=productService.getProductById(proId);
			List<Color> product_Colors=colorService.getListColorByProNo(product.getProductNo());
			List<Size> product_Sizes=sizeService.getListSizeByProNo(product.getProductNo());
			List<Pic> pics = productService.getPicListByProductNo(product.getProductNo());
			request.setAttribute("product", product);
			request.setAttribute("colors", product_Colors);
			request.setAttribute("sizes", product_Sizes);
			request.setAttribute("pics", pics);*/
			String proNo = request.getParameter("proNo");
			String colorNo = request.getParameter("colorNo");
			// 往客户端写入cookie  
	        String historyNo = makeId(proNo, request);
	        Cookie c = new Cookie("history", historyNo);
	        c.setMaxAge(1296000);
			c.setPath("/BeautyLady");
	        response.addCookie(c);
			try {
				ProductExt ext = extService.getProductExt(proNo);
				if("-1".equals(colorNo)) {
					colorNo = ext.getColorNo().split(",")[0];				
				}
				List<Pic> pics = productService.getPicListByProductNo(ext.getProductNo(),colorNo);
				request.setAttribute("ext", ext);
				request.setAttribute("pics", pics);
				request.getRequestDispatcher("../productDetail.jsp").forward(request, response);
			} catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException
					| InvocationTargetException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("history".equals(opr)){
			List<Product> history = new ArrayList<>();
			Cookie[] cs = request.getCookies();
            for (int i = 0; cs != null && i < cs.length; i++) {
                if ("history".equals(cs[i].getName())) {
                    String[] ids = cs[i].getValue().split("-");
                    for (String s : ids) {
                    	try {
                            history.add(productService.getProductByNo(s));
						} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                }
            }
            request.getSession().setAttribute("histroys", history);
            response.sendRedirect("../history.jsp");
		}
	}
	
	private String makeId(String productNo, HttpServletRequest request) {  
        // cookie为null
        Cookie[] cs = request.getCookies();  
        if (cs == null) {
            return productNo;
        }
        
        String result = "";
        for (int i = 0; i < cs.length; i++) {
            if ("history".equals(cs[i].getName())) {
                // 浏览历史中不存在该id
                if (cs[i].getValue().indexOf(productNo) == -1) {
                    result = productNo + "-" + cs[i].getValue();
                    break;
                }
                else if (cs[i].getValue().indexOf(productNo) == 0) {
                    result = cs[i].getValue();
                    break;
                }
                else {
                    result = productNo;
                    String[] ids = cs[i].getValue().split("-");
                    for (String str : ids) {
                        if (!str.equals(productNo)) {
                            result += "-" + str;
                        }
                    }
                    break;
                }
            }
        }
        String[] count = result.split("-");
        if (count.length <= 10) {
            return result;
        }
        else {
        	result = "";
        	for (int i = 0; i < 10; i++) {
				result += count[i] + "-";
			}
            return result;
        }
    }  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
