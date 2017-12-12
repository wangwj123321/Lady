package cn.beautylady.dao.impl;

import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.ColorDao;
import cn.beautylady.entity.Color;

public class ColorDaoImpl extends BaseDao implements ColorDao{

	@Override
	public List<Color> getListColorByProNo(String proNo) {
		String sql="SELECT `color`.* FROM `color`,`product_color` WHERE `color`.`colorNo`=`product_color`.`colorNo` AND `product_color`.`productNo`=?";
		return getArrayList(sql, Color.class, proNo);
	}
	
}
