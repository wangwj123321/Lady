package cn.beautylady.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.beautylady.entity.Page;
import cn.beautylady.entity.Product;
import cn.beautylady.service.impl.ProductServiceImpl;

public class InitListener implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Page<Product> page=new Page<>();
		page.setPageNo(1);
		page.setPageSize(24);
		new ProductServiceImpl().getListProduct(page,null,"ASC");
		ServletContext application=arg0.getServletContext();
		application.setAttribute("ProductPage", page);
		application.setAttribute("order", "ASC");
	}

}
