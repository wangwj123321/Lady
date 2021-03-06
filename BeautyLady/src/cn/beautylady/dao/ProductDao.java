package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.beautylady.entity.Page;
import cn.beautylady.entity.Pic;
import cn.beautylady.entity.Product;
/**
 * 商品信息操作接口
 * @author acsars
 *
 */
public interface ProductDao {
	/**
	 * 添加商品信息
	 * @param t 商品对象
	 * @return 执行结果
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
    public <T>int addProduct(T t) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    /**
     * 查找页面对象
     * @param pageNo 页码
     * @param pageSize 当前页数据条数
     * @param clazz 数据信息类型
     * @return 页面对象
     */
    public <T>Page<T> getPageObj(Integer pageNo,Integer pageSize,Class<T> clazz);
    /**
     * 获取首页的商品列表
     * @param page 页面对象
     * @return 商品列表
     */
    public List<Product> getListProduct(Page<Product> page,Map<String, Object> map,String order);
    /**
     * 获取首页显示商品总数
     * @return 商品总数
     */
    public int getProductTotal(Map<String, Object> map);
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
     * 根据商品标号，查找商品对应的图片
     * @param productNo
     * @return
     */
    public List<Pic> getPicListByProductNo(String productNo);
    
    /**
     * 根据商品标号，查找商品的图片
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
	<T>T getProperty(Class<T> clazz, Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException;
	
	
	/**
	 * 传入对象数据里的数据
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
	 * 获取对应商品所有的编号
	 * @param clazz
	 * @return 商品编号列表
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	<T>List getProductList(Class<T> clazz) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
