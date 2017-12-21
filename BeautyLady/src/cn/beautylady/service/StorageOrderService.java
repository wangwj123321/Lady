package cn.beautylady.service;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.ProductExt;
import cn.beautylady.entity.StorageOrder;


public interface StorageOrderService {
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public String getOrderNo();

	public List<ProductExt> getProductExtByNos(String[] nos) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;

	public void addStorageOrder(String userName, String[] productNos, String[] colorNos, String[] sizeNos,
			String[] numbers, String[] totalMoneys, String order, String desc) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException;
	
	/**
	 * 查找所有的订单
	 * @return
	 * @throws NoSuchFieldException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws SQLException
	 */
	public List<StorageOrder> getAllStorageOrder() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	/**
	 * 删除订单
	 * @param orderNo
	 * @return
	 */
	public int delStorageOrder(String orderNo);

}
