package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import cn.beautylady.entity.NewProduct;
/**
 * 新增商品服务接口
 * @author acsars
 *
 */
public interface AddProductService {
	/**
	 * 新增商品信息
	 * @param newProduct 新增商品对象
	 * @return 执行结果
	 */
	int addNewProduct(NewProduct newProduct);
	/**
	 * 新增不同颜色的商品信息
	 * @param newProduct 新增商品对象
	 * @return 执行结果
	 */
	int addDiffColorProduct(NewProduct newProduct);
	/**
	 * 查看商品编号是否存在
	 * @param productNo 商品编号
	 * @return 执行结果
	 */
	NewProduct findNewProduct(NewProduct newProduct) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	/**
	 * 存储不同颜色商品信息
	 * @throws SQLException 
	 */
	void storeProduct() throws SQLException;
}
