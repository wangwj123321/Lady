package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.Address;
import cn.beautylady.service.AddressService;
import cn.beautylady.service.impl.AddressServiceImpl;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/servlet/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressService addressService=new AddressServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String opr=request.getParameter("opr");
		String json="";
		if ("addAdderss".equals(opr)) {
			String userAccount=(String)request.getSession().getAttribute("userAccount");
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String isDefault=request.getParameter("isDefault");
			int isd=0;
			if (isDefault!=null && !isDefault.equals("")) {
				isd=Integer.parseInt(isDefault);
			}
			Address ads=new Address(null, userAccount, address, name, phone,isd);
			if (isd!=0) {
				addressService.updateDefaultAddress(userAccount);
			}
			if (addressService.addAddress(ads)) {
				if (isd!=0) {
					Address DefaultAddress=addressService.getDefaultAddress(userAccount);
					String addressJson=JSON.toJSONString(DefaultAddress);
					out.print("[{\"is\":\"updateDefaultTrue\"},"+addressJson+"]");
					return;
				}
				out.print("[{\"is\":\"true\"}]");
			}else {
				out.print("[{\"is\":\"false\"}]");
			}
		}else if("getNotDefaultAddress".equals(opr)) {
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			Integer id=Integer.parseInt(request.getParameter("id"));
			List<Address> list=addressService.getOtherAddress(userAccount,id);
			json=JSON.toJSONString(list);
			out.print(json);
		}else if("getAllAddress".equals(opr)){
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			List<Address> list = addressService.getAllAddress(userAccount);
			request.setAttribute("allAddress", list);
			request.getRequestDispatcher("/userMain.jsp").forward(request, response);
		}else if("deleteAddress".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			int count = 0;
			try {
				count = addressService.deleteAddress(id);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(count > 0){
				out.println("<script type='text/javascript'>alert('删除成功');location.href='AddressServlet?opr=getAllAddress'</script>");
			}else{
				out.println("<script type='text/javascript'>alert('删除失败');location.href='AddressServlet?opr=getAllAddress'</script>");
			}
		}else if("addNotAjax".equals(opr)){
			String userAccount=(String)request.getSession().getAttribute("userAccount");
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String isDefault=request.getParameter("isDefault");
			int isd=0;
			if (isDefault!=null && !isDefault.equals("")) {
				isd=Integer.parseInt(isDefault);
			}
			Address ads=new Address(null, userAccount, address, name, phone,isd);
			if (isd!=0) {
				addressService.updateDefaultAddress(userAccount);
			}
			if (addressService.addAddress(ads)) {
				out.println("<script type='text/javascript'>alert('新增成功');location.href='AddressServlet?opr=getAllAddress'</script>");
			}else {
				out.println("<script type='text/javascript'>alert('新增失败');location.href='AddressServlet?opr=getAllAddress'</script>");
			}
		}else if("modifys".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Address address = null;
			try {
				address = addressService.getAddressById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("modifyAddOne", address);
			response.sendRedirect("../modifyaddress.jsp");
		}else if("modifyAddress".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			String userAccount=(String)request.getSession().getAttribute("userAccount");
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String isDefault=request.getParameter("isDefault");
			int isd=0;
			if (isDefault!=null && !isDefault.equals("")) {
				isd=Integer.parseInt(isDefault);
			}
			Address ads=new Address(id, userAccount, address, name, phone,isd);
			if (isd!=0) {
				addressService.updateDefaultAddress(userAccount);
			}
			int count = 0;
			try {
				count = addressService.modifyAddress(ads);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (count > 0) {
				out.println("<script type='text/javascript'>alert('修改成功');location.href='AddressServlet?opr=getAllAddress'</script>");
			}else {
				out.println("<script type='text/javascript'>alert('修改失败');location.href='AddressServlet?opr=getAllAddress'</script>");
			}
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
