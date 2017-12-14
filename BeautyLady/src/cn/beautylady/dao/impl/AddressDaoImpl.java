package cn.beautylady.dao.impl;

import java.sql.SQLException;

import cn.beautylady.dao.AddressDao;
import cn.beautylady.dao.BaseDao;
import cn.beautylady.entity.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao{

	@Override
	public int addAddress(Address address) {
		String sql="INSERT INTO `address` VALUES(NULL,?,?,?,?)";
		Object[] objs= {address.getUserAccount(),address.getAddress(),address.getName(),address.getPhone()};
		int count=0;
		try {
			count=executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
