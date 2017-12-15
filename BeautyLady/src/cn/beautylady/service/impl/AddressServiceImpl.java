package cn.beautylady.service.impl;

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
	public List<Address> getNotDefaultAddress(String userAccount) {
		return addressDao.getNotDefaultAddress(userAccount);
	}

}
