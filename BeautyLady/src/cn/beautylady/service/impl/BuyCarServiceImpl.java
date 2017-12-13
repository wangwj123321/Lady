package cn.beautylady.service.impl;

import cn.beautylady.dao.BuyCarDao;
import cn.beautylady.dao.impl.BuyCarDaoImpl;
import cn.beautylady.entity.BuyCar;
import cn.beautylady.service.BuyCarService;

public class BuyCarServiceImpl implements BuyCarService{
	private BuyCarDao buyCarDao=new BuyCarDaoImpl();
	@Override
	public boolean addBuyCar(BuyCar buyCar) {
		int count=buyCarDao.addBuyCar(buyCar);
		return count==1?true:false;
	}
	
	@Override
	public BuyCar getBuyCar(String productNo,String userAccount,String colorNo,String sizeNo) {
		return buyCarDao.getBuyCar(productNo, userAccount,colorNo,sizeNo);
	}

	@Override
	public boolean updateBuyCarCount(int id) {
		int count=buyCarDao.updateBuyCarCount(id);
		return count==1?true:false;
	}

}
