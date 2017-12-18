package cn.beautylady.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.Color;

public interface ColorService {
	/**
	 * 获取指定商品的所有颜色
	 * @param proNo 商品编号
	 * @return 颜色列表
	 */
	public List<Color> getListColorByProNo(String proNo);
	
	/**
	 * 按照颜色标号获取颜色
	 * @param colorNo 颜色编号
	 * @return 颜色对象
	 */
	public Color getColorBycolorNo(String colorNo) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
