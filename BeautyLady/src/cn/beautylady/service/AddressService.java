package cn.beautylady.service;

import cn.beautylady.entity.Address;

public interface AddressService {
	/**
	 * 添加地址
	 * @param address 地址实体类
	 * @return 是否成功
	 */
	public boolean addAddress(Address address);
	/**
	 * 获取用户默认地址
	 * @param userAccount 用户名
	 * @return 默认地址实体类
	 */
	public Address getDefaultAddress(String userAccount);
	/**
	 * 更新用户默认地址
	 * @param userAccount 用户名
	 * @return 是否成功
	 */
	public void updateDefaultAddress(String userAccount);
}
