package cn.beautylady.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
public class CharacterEncodingFilter implements Filter {
	private String charset = null;
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
        HttpServletResponse response;
        try{
            request=(HttpServletRequest)req;
            response=(HttpServletResponse)resp;
        }catch (ClassCastException e){
            throw new ServletException("non-HTTP request or response");
        }

        if ("get".equalsIgnoreCase(request.getMethod())) {
            request = new MyHttpRequest(request);
        }else {
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String initParam = fConfig.getInitParameter("charset");
		if(initParam != null && (initParam = initParam.trim()).length() != 0) {
			charset = initParam;
		}
	}

}
