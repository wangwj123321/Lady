package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.ProductExt;

/**
 * 商品扩展类的dao接口
 * @author 王
 *
 */
public interface ProductExtDao {
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
	
	/**
	 * 获取所有的商品扩展类
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public List<ProductExt> findAllProductExt(Class clazz) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
