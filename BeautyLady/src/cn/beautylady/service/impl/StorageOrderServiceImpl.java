package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.beautylady.dao.StorageOrderDao;
import cn.beautylady.dao.impl.StorageOrderDaoImpl;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.entity.Storage;
import cn.beautylady.entity.StorageOrder;
import cn.beautylady.entity.StorageOrderDetail;
import cn.beautylady.service.StorageOrderService;
import cn.beautylady.util.JdbcUtil;

public class StorageOrderServiceImpl implements StorageOrderService {
	StorageOrderDao dao = new StorageOrderDaoImpl();
	
	@Override
	public String getOrderNo() {
		Date date = new Date();
		String orderNo = date.getTime()+"";
		return "SO"+orderNo;
	}

	@Override
	public List<ProductExt> getProductExtByNos(String[] nos) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.getProductExtByNos(nos);
	}

	@Override
	public void addStorageOrder(String userName, String[] productNos, String[] colorNos, String[] sizeNos,
			String[] numbers, String[] totalMoneys, String order,String desc) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
		List<StorageOrderDetail> list = new ArrayList<StorageOrderDetail>();
		Integer totalNum = 0;
		Double totalMoney =0d;
		for(int i =0 ;i <productNos.length ;i ++) {
			totalNum = totalNum+Integer.parseInt(numbers[i]);
			totalMoney = totalMoney + Double.parseDouble(totalMoneys[i]);
			StorageOrderDetail storageOrderDetail = new StorageOrderDetail(order,productNos[i],colorNos[i],sizeNos[i],Integer.parseInt(numbers[i]),Double.parseDouble(totalMoneys[i]));
			list.add(storageOrderDetail);
		}
		StorageOrder storageOrder = new StorageOrder(order,userName,totalNum,totalMoney,desc);
		dao.addStorageOrder(list,storageOrder);
	}

	@Override
	public List<StorageOrder> getAllStorageOrder() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.getAllStorageOrder();
	}

	@Override
	public int delStorageOrder(String orderNo) {
		Connection conn = JdbcUtil.getConnection();
		int result = -1;
		try {
			conn.setAutoCommit(false);
			result = dao.delStorageOrderDetail(conn, orderNo);
			result += dao.delStorageOrder(conn,orderNo);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int addStorageOrder(StorageOrder order,List list) {
		Connection conn = JdbcUtil.getConnection();
		
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = dao.addStorageOrder(conn, order, list);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean accept(String orderNo) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		boolean result = dao.accept(conn, orderNo);
		return result;
	}

	@Override
	public List<Storage> showStorage() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.showStorage();
	}
	
	
	
	

}
