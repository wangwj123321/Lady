package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface StorageOrderService {
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public String getOrderNo();

}
