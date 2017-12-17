package cn.beautylady.service;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.ProductExt;

public interface StorageOrderService {
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public String getOrderNo();

	public List<ProductExt> getProductExtByNos(String[] nos) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;

	public void addStorageOrder(String userName, String[] productNos, String[] colorNos, String[] sizeNos,
			String[] numbers, String[] totalMoneys, String order, String desc) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException;

}
