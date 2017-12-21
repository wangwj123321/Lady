package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.User_orders;

public interface User_ordersDao {
	/**
	 * 获得订单对应详情
	 * @return 订单对应详情
	 */
	public List<User_orders> getUser_ordersByorderNo(String orderNo);
	
	/**
	 * 获取订单详情对象
	 * @param id 订单id
	 * @return 订单详情对象
	 */
	public User_orders getgetUser_ordersById(Integer id) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
}
