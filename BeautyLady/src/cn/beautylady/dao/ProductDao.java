package cn.beautylady.dao;

import java.util.List;
import java.util.Map;

import cn.beautylady.entity.Page;
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
	 */
    public <T>int addProduct(T t);
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
}
