package cn.beautylady.service.impl;

import cn.beautylady.dao.OrderDao;
import cn.beautylady.dao.impl.OrderDaoImpl;
import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;
import cn.beautylady.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao=new OrderDaoImpl();
	@Override
	public boolean addOrder(Order order) {
		int count=orderDao.addOrder(order);
		return count==1?true:false;
	}
	@Override
	public Order getOrderByOrderNo(String orderNo) {
		return orderDao.getOrderByOrderNo(orderNo);
	}
	@Override
	public Order getUserAccountLastOrder(String userAccount) {
		return orderDao.getUserAccountLastOrder(userAccount);
	}
	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		int count=orderDao.addOrderDetail(orderDetail);
		return count==1?true:false;
	}

}
