package cn.beautylady.dao.impl;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.ProductDao;
import cn.beautylady.entity.Page;
/**
 * 商品信息操作实现类
 * @author acsars
 *
 */
public class ProductDaoImpl extends BaseDao implements ProductDao{
	@Override
	public <T> int addProduct(T t) {
		return insertData(t.getClass());
	}

	@Override
	public <T> Page<T> getPageObj(Integer pageNo,Integer pageSize, Class<T> clazz) {
		return getPage(pageNo,pageSize, clazz);
	}
}
