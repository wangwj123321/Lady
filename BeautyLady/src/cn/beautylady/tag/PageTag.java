package cn.beautylady.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.beautylady.entity.Page;

public class PageTag extends SimpleTagSupport{
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		{
	        StringBuffer buffer = new StringBuffer();
	        Class clazz = page.getList().get(0).getClass();
	        String clazzName = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
	        int totalPage = page.getPageCount();
	        int pageNum = page.getPageNo();
	        int pageSize = page.getPageSize();
	        System.out.println(pageNum);
	        if (pageNum - 3 > 0) {
	            for (int i = pageNum-3; i <= (pageNum+2>totalPage?totalPage:pageNum+2); i++) {
	                if (i == pageNum) {
	                    buffer.append("<a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
	                            "&currentPage="+pageSize+"'>" +
	                            "<font color='green'>"+i+"</font></a>");
	                }else {
	                    buffer.append("<a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
	                            "&currentPage="+pageSize+"'>" +i+"</a>");
	                }
	            }
	        }
	        
	        else if (pageNum - 3 <=0){
	            for (int i = 1; i <= (5>totalPage?totalPage:5); i++) {
	                if (i == pageNum) {
	                    buffer.append("<a href='/test/servlet/showProperty?property=" + clazzName + "&pageNum=" + i +
	                            "&currentPage=" + pageSize + "'>" +
	                            "<font color='green'>" + i + "</font></a>");
	                } else {
	                    buffer.append("<a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
	                            "&currentPage="+pageSize+"'>" +i+"</a>");
	                }
	            }

	        }
	        this.getJspContext().getOut().write(buffer.toString());
	    }
	}
	
	

}
