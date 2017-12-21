package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.beautylady.dao.ProductDao;
import cn.beautylady.dao.impl.ProductDaoImpl;
import cn.beautylady.entity.Page;
import cn.beautylady.entity.Pic;
import cn.beautylady.entity.Product;
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

	@Override
	public void getListProduct(Page<Product> page, Map<String, Object> map, String order) {
		// TODO Auto-generated method stub
		int count=dao.getProductTotal(map);
		page.setDataCount(count);
		List<Product> list=dao.getListProduct(page, map, order);
		page.setList(list);
	}

	@Override
	public Product getProductById(int id) {
		return dao.getProductById(id);
	}

	@Override
	public Product getProductByNo(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.getProductByNo(productNo);
	}

	@Override
	public List<Pic> getPicListByProductNo(String productNo) {
		return dao.getPicListByProductNo(productNo);
	}

	@Override
	public List<Pic> getPicListByProductNo(String productNo, String colorNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return dao.getPicListByProductNo(productNo,colorNo);
	}
	
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
	public <T>T getProperty(Class<T> clazz , Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException{
		return dao.getProperty(clazz, id);
		
	}

	@Override
	public <T> int addProperty(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
		return dao.addProduct(t);
	}

	@Override
	public int updateProperty(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException {
		return dao.updateProperty(obj);
	}

}
