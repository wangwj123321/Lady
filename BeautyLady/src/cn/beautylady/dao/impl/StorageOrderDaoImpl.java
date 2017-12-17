package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.StorageOrderDao;
import cn.beautylady.entity.ProductExt;
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

	

}
