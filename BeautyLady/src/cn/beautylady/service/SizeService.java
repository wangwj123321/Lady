package cn.beautylady.service;

import java.util.List;

import cn.beautylady.entity.Size;

public interface SizeService {
	/**
	 * 获取指定商品的所有尺码
	 * @param proNo 商品编号
	 * @return 尺码列表
	 */
	public List<Size> getListSizeByProNo(String proNo);
}
