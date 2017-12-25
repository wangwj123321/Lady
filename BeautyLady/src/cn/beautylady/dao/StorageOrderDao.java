package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.ProductExt;
import cn.beautylady.entity.Storage;
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
	
	/**
	 * 添加订单和订单明细
	 * @param order
	 * @param list
	 * @return
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
	public int addStorageOrder(Connection conn ,StorageOrder order, List list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException;
	
	/**
	 * 验收入库单
	 * @param conn
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
	public int accept(Connection conn, StorageOrder order,List<StorageOrderDetail> detail) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException;
	
	/**
	 * 根据订单编号获取订单
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public StorageOrder getStorageOrder(String orderNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	/**
	 * 根据订单编号获取订单明细
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public List<StorageOrderDetail> getOrderDetail(String orderNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	/**
	 * 验收入库，调用存储过程
	 * @param conn
	 * @param orderNo
	 * @return
	 * @throws SQLException
	 */
	public boolean accept(Connection conn, String orderNo) throws SQLException;
	
	/**
	 * 查看库存
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public List<Storage> showStorage() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;

}
