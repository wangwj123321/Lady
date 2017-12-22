package cn.beautylady.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.AddressDao;
import cn.beautylady.dao.BaseDao;
import cn.beautylady.entity.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao{

	@Override
	public int addAddress(Address address) {
		String sql="INSERT INTO `address` VALUES(NULL,?,?,?,?,?,1)";
		Object[] objs= {address.getUserAccount(),address.getAddress(),address.getName(),address.getPhone(),address.getIsDefault()};
		int count=0;
		try {
			count=executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Address getDefaultAddress(String userAccount) {
		String sql="SELECT * FROM `address` WHERE userAccount=? AND isDefault=1 AND STATUS=1";
		return getOne(sql, Address.class, userAccount);
	}

	@Override
	public int updateDefaultAddress(String userAccount) {
		String sql="UPDATE `address` SET isDefault=0 WHERE userAccount=? AND STATUS=1";
		int count=0;
		try {
			count = executeUpdate(sql, userAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Address> getOtherAddress(String userAccount,int id) {	
		String sql="SELECT * FROM `address` WHERE userAccount=? AND id!=? AND STATUS=1";
		return getArrayList(sql, Address.class, userAccount,id);
	}

	@Override
	public List<Address> getAllAddress(String userAccount) {
		String sql = "select * from `address` where userAccount = ? AND STATUS=1";
		return getArrayList(sql, Address.class, userAccount);
	}

	@Override
	public int deleteAddress(Integer id) throws SQLException {
		String sql = "UPDATE `address` SET `status`=0 WHERE id=?";
		return executeUpdate(sql, id);
	}

	@Override
	public int modifyAddress(Address address) throws SQLException {
		String sql = "update `address` set address = ?,name = ?,phone = ?,isDefault = ? where id = ?";
		return executeUpdate(sql, address.getAddress(),address.getName(),address.getPhone(),address.getIsDefault(),address.getId());
	}

	@Override
	public Address getAddressById(Integer id) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		String sql = "select * from `address` where id = ?";
		return selectOne(Address.class, sql, id);
	}
}
