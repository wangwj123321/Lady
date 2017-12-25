package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import cn.beautylady.entity.NewProduct;

/**
 * 新增商品操作接口
 * @author acsars
 *
 */
public interface AddProductDao {
	/**
	 * 新增商品信息
	 * @param conn
	 * @param newProduct 新增商品对象
	 * @return 执行结果
	 */
	int addNewProduct(Connection conn,NewProduct newProduct);
	/**
	 * 新增不同颜色的商品信息
	 * @param conn
	 * @param newProduct 新增商品对象
	 * @return 执行结果
	 */
	int addDiffColorProduct(Connection conn,NewProduct newProduct);
	/**
	 * 查看商品编号是否存在
	 * @param productNo 商品编号
	 * @return 执行结果
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	NewProduct findNewProduct(NewProduct newProduct) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
