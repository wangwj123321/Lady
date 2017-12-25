package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import cn.beautylady.dao.AddProductDao;
import cn.beautylady.dao.impl.AddProductDaoImpl;
import cn.beautylady.entity.NewProduct;
import cn.beautylady.service.AddProductService;
import cn.beautylady.util.JdbcUtil;
/**
 * 新增商品实现服务类
 * @author acsars
 *
 */
public class AddProductServiceImpl implements AddProductService{
	AddProductDao dao = new AddProductDaoImpl();
	@Override
	public int addNewProduct(NewProduct newProduct) {
		Connection conn = JdbcUtil.getConnection();
		int count = -1;
		try {
			conn.setAutoCommit(false);
			count =  dao.addNewProduct(conn,newProduct);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	
	}
	@Override
	public int addDiffColorProduct(NewProduct newProduct) {
		Connection conn = JdbcUtil.getConnection();
		int count = -1;
		try {
			conn.setAutoCommit(false);
			count  = dao.addDiffColorProduct(conn, newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	@Override
	public NewProduct findNewProduct(NewProduct newProduct) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.findNewProduct(newProduct);
	}

}
