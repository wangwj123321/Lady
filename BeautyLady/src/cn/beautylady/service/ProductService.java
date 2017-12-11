package cn.beautylady.service;

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
    
    public void getListProduct(Page<Product> page,Map<String, Object> map,String order);
}
