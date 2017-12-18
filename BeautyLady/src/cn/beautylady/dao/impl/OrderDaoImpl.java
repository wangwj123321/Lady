package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

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

	@Override
	public List<Order> getOrderByUserAccount(String userAccount) {
		String sql = "select * from `order` where userAccount = ?";
		return getArrayList(sql, Order.class, userAccount);
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderNo(String orderNo) {
		String sql = "select * from `orderdetail` where orderNo = ?";
		return getArrayList(sql, OrderDetail.class, orderNo);
	}

	@Override
	public OrderDetail getOrderDetailById(Integer id) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "select * from `orderdetail` where id = ?";
		return selectOne(OrderDetail.class, sql, id);
	}
	
}
