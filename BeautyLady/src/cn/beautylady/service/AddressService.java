package cn.beautylady.service;

import cn.beautylady.entity.Address;

public interface AddressService {
	/**
	 * 添加地址
	 * @param address 地址实体类
	 * @return 是否成功
	 */
	public boolean addAddress(Address address);
}
