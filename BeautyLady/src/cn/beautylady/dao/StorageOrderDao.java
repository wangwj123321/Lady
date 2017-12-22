package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.ProductExt;
import cn.beautylady.entity.StorageOrder;
import cn.beautylady.entity.StorageOrderDetail;

public interface StorageOrderDao {
	/**
	 * 获取入库单的最后一个订单编号
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public StorageOrder getOrderNo() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;

	public List<ProductExt> getProductExtByNos(String[] nos) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;

	

	public void addStorageOrder(List<StorageOrderDetail> list, StorageOrder storageOrder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException;

	public List<StorageOrder> getAllStorageOrder() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	/**
	 * 根据订单编号删除订单
	 * @param conn
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 */
	public int delStorageOrder(Connection conn, String orderNo) throws SQLException;
	
	/**
	 * 根据订单编号删除订单明细
	 * @param conn
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 */
	public int delStorageOrderDetail(Connection conn, String orderNo) throws SQLException;

}
