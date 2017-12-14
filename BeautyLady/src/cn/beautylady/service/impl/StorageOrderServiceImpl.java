package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import cn.beautylady.dao.StorageOrderDao;
import cn.beautylady.dao.impl.StorageOrderDaoImpl;
import cn.beautylady.entity.StorageOrder;
import cn.beautylady.service.StorageOrderService;

public class StorageOrderServiceImpl implements StorageOrderService {
	StorageOrderDao dao = new StorageOrderDaoImpl();
	@Override
	public String getOrderNo() {
		Date date = new Date();
		String orderNo = date.getTime()+"";
		return "SO"+orderNo;
	}

}
