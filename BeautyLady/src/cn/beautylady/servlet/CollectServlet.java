package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.entity.Collect;
import cn.beautylady.service.CollectService;
import cn.beautylady.service.impl.CollectServiceImpl;

/**
 * Servlet implementation class CollectServlet
 */
@WebServlet("/servlet/CollectServlet")
public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollectService collectService=new CollectServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String opr=request.getParameter("opr");
		if ("addCollect".equals(opr)) {
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			String userName=(String) request.getSession().getAttribute("loginUser");
			String productNo=request.getParameter("productNo");
			String subClassesName=request.getParameter("subClassesName");
			if (userAccount==null) {
				out.print("login");
				return;
			}
			Collect collect=new Collect(null, userAccount, userName, productNo, subClassesName,null);
			if (collectService.addCollect(collect)) {
				out.print("true");
			}else {
				out.print("false");
			}
		}
		if ("getListCollect".equals(opr)) {
			String userAccount=(String) request.getSession().getAttribute("userAccount");
			if(userAccount==null) {
				response.sendRedirect("../login.jsp");
				return;
			}
			List<Collect> userCollect=collectService.getCollectList(userAccount);
			request.setAttribute("userCollect", userCollect);
			request.getRequestDispatcher("/collect.jsp").forward(request, response);
		}
		if ("delCollect".equals(opr)) {
			int id=Integer.parseInt(request.getParameter("id"));
			if (collectService.delCollect(id)) {
				out.print("true");
			}else {
				out.print("false");
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
