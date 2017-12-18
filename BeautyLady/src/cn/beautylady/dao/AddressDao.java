package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
	 * 获取用户其他地址
	 * @param userAccount 用户名
	 * @return 其他地址对象集合
	 */
	public List<Address> getOtherAddress(String userAccount,int id);
	
	/**
	 * 获取用户所有地址
	 * @param userAccount 用户登录名
	 * @return 地址列表
	 */
	public List<Address> getAllAddress(String userAccount);
	
	/**
	 * 删除地址
	 * @param id 地址id
	 * @return 影响行数
	 */
	public int deleteAddress(Integer id) throws SQLException;
	
	/**
	 * 修改地址
	 * @param address 地址对象
	 * @return 影响行数
	 */
	public int modifyAddress(Address address) throws SQLException;
	
	/**
	 * 按照id获取地址
	 * @param id 地址ID
	 * @return 地址对象
	 */
	public Address getAddressById(Integer id) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
