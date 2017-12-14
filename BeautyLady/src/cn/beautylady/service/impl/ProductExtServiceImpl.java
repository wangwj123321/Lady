package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import cn.beautylady.dao.ProductExtDao;
import cn.beautylady.dao.impl.ProductExtDaoImpl;
import cn.beautylady.entity.ProductExt;
import cn.beautylady.service.ProductExtService;

public class ProductExtServiceImpl implements ProductExtService{
	ProductExtDao dao = new ProductExtDaoImpl();
	@Override
	public ProductExt getProductExt(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		
		return dao.getProductExt(productNo);
	}

}
