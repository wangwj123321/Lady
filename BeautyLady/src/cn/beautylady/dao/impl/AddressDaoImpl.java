package cn.beautylady.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.AddressDao;
import cn.beautylady.dao.BaseDao;
import cn.beautylady.entity.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao{

	@Override
	public int addAddress(Address address) {
		String sql="INSERT INTO `address` VALUES(NULL,?,?,?,?,?)";
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
		String sql="SELECT * FROM `address` WHERE userAccount=? AND isDefault=1";
		return getOne(sql, Address.class, userAccount);
	}

	@Override
	public int updateDefaultAddress(String userAccount) {
		String sql="UPDATE `address` SET isDefault=0 WHERE userAccount=?";
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
	public List<Address> getNotDefaultAddress(String userAccount) {	
		String sql="SELECT * FROM `address` WHERE userAccount=? AND isDefault=0";
		return getArrayList(sql, Address.class, userAccount);
	}
}
