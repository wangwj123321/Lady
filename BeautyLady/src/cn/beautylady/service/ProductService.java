package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.beautylady.entity.Page;
import cn.beautylady.entity.Pic;
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
    
    /**
     * 根据商品标号，查找商品赌赢的图片
     * @param productNo
     * @return
     */
    public List<Pic> getPicListByProductNo(String productNo);
    
    /**
     * 查找商品的图片
     * @param productNo
     * @param colorNo
     * @return
     * @throws SQLException 
     * @throws InvocationTargetException 
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     * @throws NoSuchMethodException 
     * @throws NoSuchFieldException 
     */
	public List<Pic> getPicListByProductNo(String productNo, String colorNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
	
	
	/**
	 * 根据id，获取class类的对象
	 * @param clazz	属性的类
	 * @param id	属性id
	 * @return
	 * @throws SQLException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 */
	public <T>T getProperty(Class<T> clazz , Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException;

	/**
	 * 传入一个对象添加到数据库
	 * @param t
	 * @return
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
	public <T>int addProperty(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException;

	
	
	/**
	 * 传入一个对象修改对象
	 * @param obj
	 * @return
	 * @throws SQLException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
	public int updateProperty(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException;
	/**
	 * 获取对象列表
	 * @param clazz
	 * @return 编号集合
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public <T>List getProductList(Class<T> clazz) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException; 

}
