package cn.beautylady.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.beautylady.entity.User;
import cn.beautylady.service.UserService;
import cn.beautylady.service.impl.UserServiceImpl;

/**
 * Servlet Filter implementation class BackstageLogin
 */
@WebFilter("/backstage/*")
public class BackstageLogin implements Filter {

    /**
     * Default constructor. 
     */
    public BackstageLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if(request.getSession().getAttribute("user")==null || "".equals(request.getSession().getAttribute("user"))) {
			Cookie[] cookies=request.getCookies();
			String loginUser = null;
			String userAccount = null;
			String pwd = null;
			int i=0;
	    	if(cookies!=null && cookies.length>0 ){
	    		for(Cookie cookie:cookies){
	        		if(cookie.getName().equals("userAccount")){
	        			userAccount = cookie.getValue();
	        			i++;
	        		}
	        		if(cookie.getName().equals("pwd")) {
	        			pwd = cookie.getValue();
	        			i++;
	        		}
	        	}
	    		if(i==2) {
	    			User user = new User();
			    	user.setUserAccount(userAccount);
			    	user.setUserName(loginUser);
			    	user.setPassword(pwd);
			    	UserService service = new UserServiceImpl();
			    	User u = service.login(user);
			    	if(u==null) {
			    		response.sendRedirect("/BeautyLady/login.jsp");
			    	}
	    		}else {
	    			response.sendRedirect("/BeautyLady/login.jsp");
	    		}
		    	
	    	} else {
	    		response.sendRedirect("/BeautyLady/login.jsp");
	    	}
	    	
		}		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
