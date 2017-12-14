package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.StorageOrderDao;
import cn.beautylady.entity.StorageOrder;

public class StorageOrderDaoImpl extends BaseDao implements StorageOrderDao{

	@Override
	public StorageOrder getOrderNo() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT MAX(orderNo) FROM `storageorder`";
		StorageOrder order = selectOne(StorageOrder.class, sql,null);
		return order;
	}

}
