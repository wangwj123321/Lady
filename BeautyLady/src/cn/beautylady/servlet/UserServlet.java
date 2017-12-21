package cn.beautylady.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.beautylady.entity.User;
import cn.beautylady.service.UserService;
import cn.beautylady.service.impl.UserServiceImpl;
import cn.beautylady.util.MD5Util;
import cn.beautylady.util.MySendMailThread;

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
		if ("UserInfo".equals(opr)) {
			HttpSession session=request.getSession();
			String loginUser=(String)session.getAttribute("userAccount");
			User user = null;
			if(loginUser.indexOf("@") > 0){
				user = userService.getUserByEmails(loginUser);
			}else {
				user = userService.getUserByUserAccounts(loginUser);
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/userMain.jsp").forward(request, response);
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
			String pwd=MD5Util.MD5(request.getParameter("pwd"));
			String pass=request.getParameter("pass");
			int checkCode=Integer.parseInt(request.getParameter("checkCode"));
			HttpSession session=request.getSession();
			int check=Integer.parseInt((String)session.getAttribute("randCheckCode"));
			if (checkCode!=check) {
				request.setAttribute("hint", "验证码有误！");
				session.setAttribute("userAccount", userAccount);
				request.getRequestDispatcher("../login.jsp").forward(request, response);
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
						Cookie pwdCookie=new Cookie("pwd",loginUser.getPassword() );
						cookie.setMaxAge(1296000);
						cookie.setPath("/BeautyLady");
						pwdCookie.setMaxAge(1296000);
						pwdCookie.setPath("/BeautyLady");
						cookie2.setMaxAge(1296000);
						cookie2.setPath("/BeautyLady");
						response.addCookie(cookie);
						response.addCookie(cookie2);
						response.addCookie(pwdCookie);
					}
					if(loginUser.getStage()==1) {
						response.sendRedirect("../index.jsp");
						return ;
					}else if(loginUser.getStage()==0){
						session.setAttribute("backUser", loginUser);
						response.sendRedirect("/BeautyLady/backstage/backstage.jsp");
						return ;
					}
				}else if(loginUser.getStatus() == 0) {
					request.setAttribute("hint", "账号未激活，请先激活再尝试登陆！");
					session.setAttribute("userAccount", userAccount);
					request.getRequestDispatcher("../login.jsp").forward(request, response);
				}else if(loginUser.getStatus() == 2) {
					request.setAttribute("hint", "账号以被冻结，请联系管理员解冻再尝试登陆！");
					session.setAttribute("userAccount", userAccount);
					request.getRequestDispatcher("../login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("hint", "密码错误！");
				session.setAttribute("userAccount", userAccount);
				request.getRequestDispatcher("../login.jsp").forward(request, response);
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
				if ("pwd".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setPath("/BeautyLady");
					response.addCookie(cookie);
				}
			}
			response.sendRedirect("../login.jsp");
		}
		if("showModifyUser".equals(opr)){
			String userAccount = (String)request.getSession().getAttribute("userAccount");
			User user = null;
			if(userAccount.indexOf("@") > 0){
				user = userService.getUserByEmails(userAccount);
			}else{
				user = userService.getUserByUserAccounts(userAccount);
			}
			request.getSession().setAttribute("modifyOneUser", user);
			response.sendRedirect("../modifyUser.jsp");
		}
		if("modifyUser".equals(opr)){
			String userAccount = request.getParameter("userAccount");
			String userName = request.getParameter("userName");
			String pwd = MD5Util.MD5(request.getParameter("pwd"));
			String email = request.getParameter("email");
			String oldpwd = MD5Util.MD5(request.getParameter("oldpwd"));
			User user = new User();
			user.setUserAccount(userAccount);
			user.setPassword(oldpwd);
			user = userService.login(user);
			if(user != null){
				user.setUserName(userName);
				user.setPassword(pwd);
				int count = 0;
				try {
					if(!email.equals(user.getEmail())){
						user.setEmail(email);
						count = userService.modifyUserStatusToZero(user);
						new MySendMailThread(user).start();
						out.println("<script type='text/javascript'>alert('修改成功，邮箱已改，请重新激活！');location.href='../login.jsp'</script>");
						return;
					}else{
						count = userService.modifyUser(user);
						out.println("<script type='text/javascript'>alert('修改成功');location.href='UserServlet?opr=UserInfo'</script>");
						return;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				out.println("<script type='text/javascript'>alert('修改失败');location.href='../modifyUser.jsp'</script>");
			}else{
				request.setAttribute("hint", "密码错误！");
				request.getRequestDispatcher("../modifyUser.jsp").forward(request, response);
			}
		}
		/**
		 * 显示所有用户
		 */
		if("showUser".equals(opr)){
			List<User> list = userService.getUsersList();
			String str = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
			out.print(str);
		}
		/**
		 * 冻结用户
		 */
		if("FreeAndRecovery".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer status = Integer.parseInt(request.getParameter("status"));
			try {
				userService.FreeAndRecovery(id, status);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("true");
		}
		/**
		 * 后台用户新增
		 */
		if("backAddUser".equals(opr)){
			String name = (String)request.getSession().getAttribute("userAccount");
			String userAccount=request.getParameter("userAccount");
			String userName = request.getParameter("userName");
			String pwd=MD5Util.MD5(request.getParameter("pwd"));
			String email = request.getParameter("email");
			String acode = UUID.randomUUID().toString().replaceAll("-", "");
			User user = new User();
			user.setUserAccount(userAccount);
			user.setUserName(userName);
			user.setPassword(pwd);
			user.setEmail(email);
			user.setAcode(acode);
			user.setStatus(1);
			user.setStage(0);
			user.setCreatedBy(name);
			int count = 0;
			try {
				count = userService.addBackUser(user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			out.print(count);
		}
		if("showModifyBackUser".equals(opr)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			User user = new User();
			user.setId(id);
			user=userService.login(user);
			String str = JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd");
			out.print(str);
		}
		if("modifyBackUser".equals(opr)){
			String userAccount = request.getParameter("muserAccount");
			String userName = request.getParameter("muserName");
			String pwd = MD5Util.MD5(request.getParameter("mpwd"));
			String email = request.getParameter("memail");
			User user = new User();
			user.setUserAccount(userAccount);
			user.setUserName(userName);
			user.setPassword(pwd);
			user.setEmail(email);
			int count = 0;
			try {
				count = userService.modifyUser(user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			out.print(count);
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
