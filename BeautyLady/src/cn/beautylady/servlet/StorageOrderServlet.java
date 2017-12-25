package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.Storage;
import cn.beautylady.entity.StorageOrder;
import cn.beautylady.entity.StorageOrderDetail;
import cn.beautylady.service.StorageOrderService;
import cn.beautylady.service.impl.StorageOrderServiceImpl;
import cn.beautylady.util.ClassNameUtil;
import cn.beautylady.util.JavaBeanUtil;

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
		
		else if("addStorage".equals(opr)) {
			List<StorageOrderDetail> list = new ArrayList();
			String orderNo = request.getParameter("params").substring(request.getParameter("params").indexOf("=")+1);
			String userName = request.getParameter("userName");
			String[] productExtNos = request.getParameterValues("ProductExt");
			String[] colorNos = request.getParameterValues("color");
			String[] sizeNos = request.getParameterValues("size");
			String[] numbers = request.getParameterValues("number");
			Integer totalNum=0;
			for (int i = 0; i < numbers.length; i++) {
				if(numbers[i]!=null && !"".equals(numbers[i])) {
					StorageOrderDetail detail = new StorageOrderDetail(orderNo,productExtNos[i],colorNos[i],sizeNos[i],Integer.parseInt(numbers[i]),0.0);
					totalNum+= Integer.parseInt(numbers[i]);
					list.add(detail);
				}
			}
			StorageOrder order = new StorageOrder(orderNo,totalNum,userName,0.0);
			int result = service.addStorageOrder(order,list);
			
		}
		
		else if("accept".equals(opr)) {
			String orderNo = request.getParameter("orderNo");
			try {
				boolean result = service.accept(orderNo);
				PrintWriter out = response.getWriter();
				if(result) {
					out.println("true");
				}else {
					out.println("false");
				}
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if("showStorage".equals(opr)) {
			try {
				List<Storage> list = service.showStorage();
				String jsonData = JSON.toJSONString(list);
				PrintWriter out = response.getWriter();
				out.println(jsonData);
				out.flush();
				out.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if("showDetail".equals(opr)) {
			String orderNo = request.getParameter("orderNo");
			try {
				List<StorageOrderDetail> list = service.showDetail(orderNo);
				String jsonData = JSON.toJSONString(list);
				PrintWriter out = response.getWriter();
				out.println(jsonData);
				out.flush();
				out.close();
			} catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException
					| InvocationTargetException | SQLException e) {
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
