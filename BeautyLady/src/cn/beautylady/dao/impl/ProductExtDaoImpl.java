package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.ProductExtDao;
import cn.beautylady.entity.ProductExt;

public class ProductExtDaoImpl extends BaseDao implements ProductExtDao{

	@Override
	public ProductExt getProductExt(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `productext` WHERE productNo=?";
		ProductExt ext = selectOne(ProductExt.class, sql, productNo);
		return ext;
	}

}
