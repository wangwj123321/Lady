package cn.beautylady.service.impl;

import java.util.List;

import cn.beautylady.dao.ColorDao;
import cn.beautylady.dao.impl.ColorDaoImpl;
import cn.beautylady.entity.Color;
import cn.beautylady.service.ColorService;

public class ColorServiceImpl implements ColorService{
	private ColorDao colorDao=new ColorDaoImpl();
	@Override
	public List<Color> getListColorByProNo(String proNo) {
		return colorDao.getListColorByProNo(proNo);
	}
	
}
