package cn.beautylady.service.impl;

import java.util.List;

import cn.beautylady.dao.SizeDao;
import cn.beautylady.dao.impl.SizeDaoImpl;
import cn.beautylady.entity.Size;
import cn.beautylady.service.SizeService;

public class SizeServiceImpl implements SizeService{
	private SizeDao sizeDao=new SizeDaoImpl();
	@Override
	public List<Size> getListSizeByProNo(String proNo) {
		return sizeDao.getListSizeByProNo(proNo);
	}

}
