package cn.beautylady.dao.impl;

import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.SizeDao;
import cn.beautylady.entity.Size;

public class SizeDaoImpl extends BaseDao implements SizeDao{

	@Override
	public List<Size> getListSizeByProNo(String proNo) {
		String sql="SELECT `size`.* FROM `size`,`product_size` WHERE `size`.`sizeNo`=`product_size`.`sizeNo` AND `product_size`.`productNo`=?";
		return getArrayList(sql, Size.class, proNo);
	}

}
