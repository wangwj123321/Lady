package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import cn.beautylady.entity.ProductExt;

/**
 * 扩展product类的service
 * @author 王
 *
 */
public interface ProductExtService {
	/**
	 * 根据商品编号查找商品扩展类
	 * @param productNo
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public ProductExt getProductExt(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
