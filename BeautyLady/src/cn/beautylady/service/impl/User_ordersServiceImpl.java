package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.User_ordersDao;
import cn.beautylady.dao.impl.User_ordersDaoImpl;
import cn.beautylady.entity.User_orders;
import cn.beautylady.service.User_ordersService;

public class User_ordersServiceImpl implements User_ordersService {
	private User_ordersDao dao = new User_ordersDaoImpl();

	@Override
	public List<User_orders> getUser_ordersByorderNo(String orderNo) {
		return dao.getUser_ordersByorderNo(orderNo);
	}

	@Override
	public User_orders getgetUser_ordersById(Integer id) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.getgetUser_ordersById(id);
	}

}
