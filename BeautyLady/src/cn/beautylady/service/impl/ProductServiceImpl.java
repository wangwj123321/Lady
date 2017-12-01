package cn.beautylady.service.impl;

import cn.beautylady.dao.ProductDao;
import cn.beautylady.dao.impl.ProductDaoImpl;
import cn.beautylady.entity.Page;
import cn.beautylady.service.ProductService;

/**
 * 商品信息服务实现类
 * @author acsars
 *
 */
public class ProductServiceImpl implements ProductService{
	ProductDao dao = new ProductDaoImpl();

	@Override
	public <T> Page<T> getPageObj(Integer pageNo, Integer pageSize, Class<T> clazz) {
		return dao.getPageObj(pageNo, pageSize, clazz);
	}

}
