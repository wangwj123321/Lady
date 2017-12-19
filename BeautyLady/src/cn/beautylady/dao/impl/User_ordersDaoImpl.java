package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.User_ordersDao;
import cn.beautylady.entity.User_orders;

public class User_ordersDaoImpl extends BaseDao implements User_ordersDao {

	@Override
	public List<User_orders> getUser_ordersByorderNo(String orderNo) {
		String sql = "SELECT * FROM `user_orders` WHERE orderNo = ?";
		return getArrayList(sql, User_orders.class, orderNo);
	}

	@Override
	public User_orders getgetUser_ordersById(Integer id) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `user_orders` WHERE id = ?";
		return selectOne(User_orders.class, sql, id);
	}
	
}
