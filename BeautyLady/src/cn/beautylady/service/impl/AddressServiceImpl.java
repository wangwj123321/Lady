package cn.beautylady.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.AddressDao;
import cn.beautylady.dao.impl.AddressDaoImpl;
import cn.beautylady.entity.Address;
import cn.beautylady.service.AddressService;

public class AddressServiceImpl implements AddressService{
	private AddressDao addressDao=new AddressDaoImpl();
	@Override
	public boolean addAddress(Address address) {
		int count=addressDao.addAddress(address);
		return count==1?true:false;
	}
	@Override
	public Address getDefaultAddress(String userAccount) {
		return addressDao.getDefaultAddress(userAccount);
	}
	@Override
	public void updateDefaultAddress(String userAccount) {
		addressDao.updateDefaultAddress(userAccount);
	}
	@Override
	public List<Address> getOtherAddress(String userAccount,int id) {
		return addressDao.getOtherAddress(userAccount,id);
	}
	@Override
	public List<Address> getAllAddress(String userAccount) {
		return addressDao.getAllAddress(userAccount);
	}
	@Override
	public int deleteAddress(Integer id) throws SQLException {
		return addressDao.deleteAddress(id);
	}
	@Override
	public int modifyAddress(Address address) throws SQLException {
		return addressDao.modifyAddress(address);
	}
	@Override
	public Address getAddressById(Integer id) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException, SQLException {
		return addressDao.getAddressById(id);
	}

}
