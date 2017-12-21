package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.OrderDao;
import cn.beautylady.dao.impl.OrderDaoImpl;
import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;
import cn.beautylady.entity.Page;
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
	@Override
	public List<Order> getOrderByUserAccount(String userAccount) {
		return orderDao.getOrderByUserAccount(userAccount);
	}
	@Override
	public List<OrderDetail> getOrderDetailByOrderNo(String orderNo) {
		return orderDao.getOrderDetailByOrderNo(orderNo);
	}
	@Override
	public OrderDetail getOrderDetailById(Integer id) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return orderDao.getOrderDetailById(id);
	}
	@Override
	public boolean updateOrderStatus(int orderId, int status) {
		int count=orderDao.updateOrderStatus(orderId, status);
		return count==1?true:false;
	}
	@Override
	public List<Order> getListOrder(Page<Order> page) {
		int count=orderDao.getOrderCount();
		page.setDataCount(count);
		List<Order> list=orderDao.getListOrder((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		page.setList(list);
		return list;
	}

}
