package cn.beautylady.dao;

import java.util.List;

import cn.beautylady.entity.Color;

public interface ColorDao {
	/**
	 * 获取指定商品的所有颜色
	 * @param proNo 商品编号
	 * @return 颜色列表
	 */
	public List<Color> getListColorByProNo(String proNo);
}
