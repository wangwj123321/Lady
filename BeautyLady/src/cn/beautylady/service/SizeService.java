package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.Size;

public interface SizeService {
	/**
	 * 获取指定商品的所有尺码
	 * @param proNo 商品编号
	 * @return 尺码列表
	 */
	public List<Size> getListSizeByProNo(String proNo);
	
	/**
	 * 按照尺寸编号获取尺寸
	 * @param sizeNo 尺寸标号
	 * @return 尺寸对象
	 * @throws NoSuchFieldException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws SQLException
	 */
	public Size getSizeBysizeNo(String sizeNo)throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
