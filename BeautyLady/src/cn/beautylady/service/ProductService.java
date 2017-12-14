package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import cn.beautylady.entity.Page;
import cn.beautylady.entity.Product;
/**
 * 商品信息服务接口
 * @author acsars
 *
 */
public interface ProductService {
	/**
	 * 获取页面对象
	 * @param pageNo 页码
	 * @param pageSize 当前页数据条数
	 * @param clazz 页面信息类型
	 * @return 页面对象
	 */
    public <T>Page<T> getPageObj(Integer pageNo,Integer pageSize, Class<T> clazz);
    /**
     * 获取指定条件的商品列表
     * @param page 分页对象
     * @param map 条件
     * @param order 价钱排序
     */
    public void getListProduct(Page<Product> page,Map<String, Object> map,String order);
        /**
     * 根据id获取商品
     * @param id 商品id
     * @return 商品对象
     */
    public Product getProductById(int id);
    
    /**
     * 根据商品编号获取商品对象
     * @param productNo
     * @return
     * @throws SQLException 
     * @throws InvocationTargetException 
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     * @throws NoSuchMethodException 
     * @throws NoSuchFieldException 
     */
    public Product getProductByNo(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
