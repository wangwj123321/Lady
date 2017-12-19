package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.entity.User;
import cn.beautylady.service.IRegService;
import cn.beautylady.service.impl.RegServiceImpl;
import cn.beautylady.util.MD5Util;
import cn.beautylady.util.MySendMailThread;
import cn.beautylady.service.IRegService;

@WebServlet("/servlet/RegServlet")
public class RegServlet extends HttpServlet {
	//依赖注入
	private IRegService service = new RegServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("请去注册页面注册！.");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userAccount = request.getParameter("userAccount");
		String userName = request.getParameter("userName");
		String pwd = MD5Util.MD5(request.getParameter("pwd"));
		String email = request.getParameter("email");
		
		User user = new User();
		user.setUserAccount(userAccount);;
		user.setUserName(userName);
		user.setPassword(pwd);
		user.setEmail(email);
		
		user = service.reg(user);
		
		if(user!=null){
			//这里有一个小知识点，必须新开一个线程来发邮件，不能把发邮件的动作写在这里
			//如果写在这里，用户的前台显示会等待过长时间，不好！
			new MySendMailThread(user).start();
			out.println("您已经注册成功，请去邮箱激活账号后再进行登录，如果没有收到邮件，请稍等!<br/>");
			out.println("<a href='"+request.getContextPath()+"/login.jsp"+"'>返回登录页</a><br/>");
			
		}else{
			out.println("很抱歉，服务器繁忙，注册失败，需要重新注册！");
		}
		out.close();
	}
}

