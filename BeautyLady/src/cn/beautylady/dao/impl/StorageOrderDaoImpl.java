package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.StorageOrderDao;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.entity.Storage;
import cn.beautylady.entity.StorageOrder;
import cn.beautylady.entity.StorageOrderDetail;

public class StorageOrderDaoImpl extends BaseDao implements StorageOrderDao{

	@Override
	public StorageOrder getOrderNo() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT MAX(orderNo) FROM `storageorder`";
		StorageOrder order = selectOne(StorageOrder.class, sql,null);
		return order;
	}

	@Override
	public List<ProductExt> getProductExtByNos(String[] nos) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `productext` WHERE productNo=?";
		List<ProductExt> exts = new ArrayList();
		for(int i = 0 ; i <nos.length ; i++) {
			ProductExt ext = selectOne(ProductExt.class, sql, nos[i]);
			exts.add(ext);
		}
		return exts;
	}

	@Override
	public void addStorageOrder(List<StorageOrderDetail> list, StorageOrder storageOrder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
		insert(storageOrder);
		for (StorageOrderDetail storageOrderDetail : list) {
			insert(storageOrderDetail);
		}
		
	}

	@Override
	public List<StorageOrder> getAllStorageOrder() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `storageorder`";
		return select(StorageOrder.class, sql);
	}

	@Override
	public int delStorageOrder(Connection conn, String orderNo) throws SQLException {
		String sql = "delete from `storageorder` WHERE orderNo= ? and `status`=0";
		return delete(conn,sql,orderNo);
	}

	@Override
	public int delStorageOrderDetail(Connection conn, String orderNo) throws SQLException {
		String sql = "delete from `storageorderdetail` where orderNo= ? ";
		return delete(conn,sql,orderNo);
	}

	@Override
	public int addStorageOrder(Connection conn , StorageOrder order, List list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
		int result=0;
		result += insert(conn, order);
		for(int i =0 ;i <list.size() ;i ++) {
			result += insert(conn, list.get(i));
		}
		return result;
	}

	@Override
	public int accept(Connection conn,StorageOrder order,List<StorageOrderDetail> detail) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException {
		
		return 0;
	}

	@Override
	public StorageOrder getStorageOrder(String orderNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `storageorder` WHERE `orderNo` = ?";
		return selectOne(StorageOrder.class, sql, orderNo);
	}

	@Override
	public List<StorageOrderDetail> getOrderDetail(String orderNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql ="SELECT * FROM `storageorderdetail` WHERE `orderNo` = ?";
		return select(StorageOrderDetail.class, sql, orderNo);
		 
	}

	@Override
	public boolean accept(Connection conn, String orderNo) throws SQLException {
		CallableStatement cstmt = conn.prepareCall("{call acceptStorageOrder(?)}");
		cstmt.setString(1, orderNo);
		boolean flag = cstmt.execute();
		cstmt.close();
		conn.close();
		return flag;
	}

	@Override
	public List<Storage> showStorage() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql ="SELECT * FROM `storage`";
		return select(Storage.class, sql);
	}

	

}
