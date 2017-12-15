package cn.beautylady.dao.impl;

import java.sql.SQLException;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.OrderDao;
import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public int addOrder(Order order) {
		String sql="INSERT INTO `order` VALUES(NULL,?,?,?,?,NOW(),?,0)";
		Object[] objs= {order.getOrderNo(),order.getUserAccount(),order.getUserName(),order.getAddressID(),order.getCostPrice()};
		int count=0;
		try {
			count = executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Order getOrderByOrderNo(String orderNo) {
		String sql="SELECT * FROM `order` WHERE orderNo=?";
		return getOne(sql, Order.class, orderNo);
	}

	@Override
	public Order getUserAccountLastOrder(String userAccount) {
		String sql="SELECT * FROM `order` WHERE userAccount=? ORDER BY createDate DESC";
		return getOne(sql, Order.class, userAccount);
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		String sql="INSERT INTO `orderdetail` VALUES(NULL,?,?,?,?,?,?,?,?)";
		Object[] objs= {orderDetail.getOrderNo(),orderDetail.getColorNo(),orderDetail.getSizeNo(),orderDetail.getProductNo(),orderDetail.getTagPrice(),orderDetail.getCount(),orderDetail.getAmount(),orderDetail.getZk()};
		int count=0;
		try {
			count=executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
