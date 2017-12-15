package cn.beautylady.service;

import java.util.List;

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
	/**
	 * 获取用户其他地址
	 * @param userAccount 用户名
	 * @return 其他地址对象集合
	 */
	public List<Address> getOtherAddress(String userAccount,int id);
}
