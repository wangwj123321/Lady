package cn.beautylady.dao;

import cn.beautylady.entity.Address;

public interface AddressDao {
	/**
	 * 添加地址
	 * @param address 地址实体类
	 * @return 影响行数
	 */
	public int addAddress(Address address);
}
