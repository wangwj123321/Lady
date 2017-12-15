package cn.beautylady.dao;

import java.util.List;

import cn.beautylady.entity.Address;

public interface AddressDao {
	/**
	 * 添加地址
	 * @param address 地址实体类
	 * @return 影响行数
	 */
	public int addAddress(Address address);
	/**
	 * 获取用户默认地址
	 * @param userAccount 用户名
	 * @return 默认地址实体类
	 */
	public Address getDefaultAddress(String userAccount);
	/**
	 * 更新用户默认地址
	 * @param userAccount 用户名
	 * @return 影响行数
	 */
	public int updateDefaultAddress(String userAccount);
	/**
	 * 获取用户所有非默认地址
	 * @param userAccount 用户名
	 * @return 非默认地址对象集合
	 */
	public List<Address> getNotDefaultAddress(String userAccount);
}
