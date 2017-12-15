package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.beautylady.entity.User;
import cn.beautylady.service.UserService;
import cn.beautylady.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/servlet/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		if ("isLogin".equals(opr)) {
			HttpSession session=request.getSession();
			String loginUser=(String)session.getAttribute("loginUser");
			if (loginUser==null) {
				response.sendRedirect("../login.jsp");
			}else {
				response.sendRedirect("../userMain.jsp");
			}
		}
		if ("getUserByUserAccount".equals(opr)) {
			String userAccount=request.getParameter("userAccount");
			if (userService.getUserByUserAccount(userAccount)) {
				out.print("true"); 
			}else {
				out.print("false"); 
			}
		}
		if ("getUserByEmailt".equals(opr)) {
			String email=request.getParameter("email");
			if (userService.getUserByEmail(email)) {
				out.print("true"); 
			}else {
				out.print("false"); 
			}
		}
		if ("login".equals(opr)) {
			String userAccount=request.getParameter("userAccount");
			String pwd=request.getParameter("pwd");
			String pass=request.getParameter("pass");
			int checkCode=Integer.parseInt(request.getParameter("checkCode"));
			HttpSession session=request.getSession();
			int check=Integer.parseInt((String)session.getAttribute("randCheckCode"));
			if (checkCode!=check) {
				session.setAttribute("hint", "验证码有误！");
				session.setAttribute("userAccount", userAccount);
				response.sendRedirect("../login.jsp");
				return;
			}
			User user=new User();
			if(userAccount.indexOf("@") != -1) {
				user.setEmail(userAccount);
			}else {
				user.setUserAccount(userAccount);
			}
			user.setPassword(pwd);
			User loginUser=userService.login(user);
			if (loginUser!=null) {
				if(loginUser.getStatus() == 1) {
					session.setAttribute("loginUser", loginUser.getUserName());
					session.setAttribute("userAccount", loginUser.getUserAccount());
					session.setAttribute("hint", null);
					if ("true".equals(pass)) {
						Cookie cookie=new Cookie("loginUser", loginUser.getUserName());
						Cookie cookie2=new Cookie("userAccount", loginUser.getUserAccount());
						cookie.setMaxAge(1296000);
						cookie.setPath("/BeautyLady");
						response.addCookie(cookie);
						cookie2.setMaxAge(1296000);
						cookie2.setPath("/BeautyLady");
						response.addCookie(cookie2);
					}
					response.sendRedirect("../index.jsp");
				}else if(loginUser.getStatus() == 0) {
					session.setAttribute("hint", "账号未激活，请先激活再尝试登陆！");
					session.setAttribute("userAccount", userAccount);
					response.sendRedirect("../login.jsp");
				}else if(loginUser.getStatus() == 2) {
					session.setAttribute("hint", "账号以被冻结，请联系管理员解冻再尝试登陆！");
					session.setAttribute("userAccount", userAccount);
					response.sendRedirect("../login.jsp");
				}
			}else {
				session.setAttribute("hint", "密码错误！");
				session.setAttribute("userAccount", userAccount);
				response.sendRedirect("../login.jsp");
			}
		}
		if("exitLogin".equals(opr)) {
			HttpSession session=request.getSession();
			session.removeAttribute("loginUser");
			session.removeAttribute("userAccount");
			Cookie[] cookies=request.getCookies();
			for (Cookie cookie : cookies) {
				if ("loginUser".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setPath("/BeautyLady");
					response.addCookie(cookie);
				}
				if ("userAccount".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setPath("/BeautyLady");
					response.addCookie(cookie);
				}
			}
			response.sendRedirect("../login.jsp");
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
