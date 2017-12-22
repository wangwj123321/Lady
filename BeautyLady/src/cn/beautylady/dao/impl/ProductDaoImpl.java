package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.ProductDao;
import cn.beautylady.entity.Page;
import cn.beautylady.entity.Pic;
import cn.beautylady.entity.Product;
/**
 * 商品信息操作实现类
 * @author acsars
 *
 */
public class ProductDaoImpl extends BaseDao implements ProductDao{
	@Override
	public <T> int addProduct(T t) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		return insert(t);
	}

	@Override
	public <T> Page<T> getPageObj(Integer pageNo,Integer pageSize, Class<T> clazz) {
		return getPage(pageNo,pageSize, clazz);
	}

	@Override
	public List<Product> getListProduct(Page<Product> page,Map<String, Object> map,String order) {
		String sql="SELECT `product`.*,`subclasses`.`subClassesName` subClassesName FROM `product`,`subclasses` WHERE  `product`.`subclassesNo`=`subclasses`.`subClassesNo` ";
		if (map!=null && map.size()!=0) {
			Set<String> key=map.keySet();
			for (String s : key) {
				if ("productName".equals(s)) {
					sql+="and "+s+" like '%"+map.get(s)+"%'";
					break;
				}
				if ("quarter".equals(s)) {
					sql+="and "+s+"="+map.get(s);
					break;
				}
				sql+="and "+s+"='"+map.get(s)+"'";
			}
		}
		sql+=" ORDER BY  createDate DESC";
		if (order!=null && !order.equals("")) {
			sql+=", tagPrice "+order;
		}
		sql+=" LIMIT ?,?";
		System.out.println(sql);
		Object[] objs= {(page.getPageNo()-1)*page.getPageSize(),page.getPageSize()};
		return getArrayList(sql, Product.class, objs);
	}

	@Override
	public int getProductTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `product` ";
		if (map!=null && map.size()!=0) {
			Set<String> key=map.keySet();
			for (String s : key) {
				if ("productName".equals(s)) {
					sql+="where "+s+" like '%"+map.get(s)+"%'";
					break;
				}
				if ("quarter".equals(s)) {
					sql+="where "+s+"="+map.get(s);
					break;
				}
				sql+="where "+s+"='"+map.get(s)+"'";
			}
		}
		return getCount(sql);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT `product`.*,`subclasses`.`subClassesName` FROM `product`,`subclasses` WHERE `product`.`subclassesNo`=`subclasses`.`subClassesNo` AND `product`.id=?";
		return getOne(sql, Product.class, id);
	}

	@Override
	public Product getProductByNo(String productNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM `product` WHERE productNo=?";
		return selectOne(Product.class, sql, productNo);
	}

	@Override
	public List<Pic> getPicListByProductNo(String productNo) {
		String sql = "select * from `pic` where productNo = ?";
		return getArrayList(sql, Pic.class, productNo);
	}

	@Override
	public List<Pic> getPicListByProductNo(String productNo, String colorNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT * FROM pic WHERE productNo=? AND colorNo=?";
		return select(Pic.class, sql, productNo,colorNo);
	}

	@Override
	public <T> T getProperty(Class<T> clazz, Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException {
		T t = selectOne(clazz, id);
		return t;
	}

	@Override
	public int updateProperty(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException {
		return update(obj);
	}

	@Override
	public <T>List getProductList(Class<T> clazz) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "SELECT `"+getClassName(clazz)+"No`,`"+getClassName(clazz)+"Name` FROM "+getClassName(clazz);
		return select(clazz, sql, null);
	}
}
