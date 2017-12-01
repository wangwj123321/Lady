package cn.beautylady.dao;

import cn.beautylady.entity.Page;
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
    }
