package cn.beautylady.dao.impl;

import java.awt.Insets;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import cn.beautylady.dao.AddProductDao;
import cn.beautylady.dao.BaseDao;
import cn.beautylady.entity.NewProduct;
import cn.beautylady.entity.Pic;
import cn.beautylady.entity.Product;
import cn.beautylady.entity.Product_Color;
import cn.beautylady.entity.Product_Size;

public class AddProductDaoImpl extends BaseDao implements AddProductDao {

	@Override
	public int addNewProduct(Connection conn,NewProduct newProduct) {
		int count = -1;
		Product_Color product_color = new Product_Color(newProduct.getProductNo(), newProduct.getColorNo1());
		Product_Size product_Size = new Product_Size(newProduct.getProductNo(), newProduct.getSeriesNo());
		Product product = new Product(newProduct.getProductNo(), newProduct.getProductName(), newProduct.getTagPrice(),
				newProduct.getCostPrice(), newProduct.getCategoryNo(), newProduct.getSubclassesNo(), newProduct.getBandNo()
				, newProduct.getThemeNo(), newProduct.getSeriesNo(), newProduct.getYear(), newProduct.getQuarter(),
				newProduct.getMainpic(), newProduct.getCreatedBy());
		try {
			count += insert(conn,product);
			count += insert(conn,product_color);
			count += insert(conn,product_Size);
			for(Pic pic:newProduct.getPicList()){
				count += insert(conn,pic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}

	@Override
	public int addDiffColorProduct(Connection conn, NewProduct newProduct) {
		Product_Color product_color = new Product_Color(newProduct.getProductNo(), newProduct.getColorNo1());
		Product_Size product_Size = new Product_Size(newProduct.getProductNo(), newProduct.getSeriesNo());
		int count = 0;
		try {
			count += insert(conn,product_color);
			count += insert(conn,product_Size);
			for(Pic pic:newProduct.getPicList()){
				count += insert(conn,pic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count; 
	}

	@Override
	public NewProduct findNewProduct(NewProduct newProduct) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `product` WHERE `productNo` = ?";
		return selectOne(newProduct.getClass(), sql, newProduct.getProductNo());
	}

}
