package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
