package cn.beautylady.dao.impl;

import java.sql.SQLException;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.BuyCarDao;
import cn.beautylady.entity.BuyCar;

public class BuyCarDaoImpl extends BaseDao implements BuyCarDao{

	@Override
	public int addBuyCar(BuyCar buyCar) {
		String sql="INSERT INTO `buycar` VALUES(NULL,?,?,?,?,'0',NULL,?,?,?,?,1)";
		Object[] objs= {buyCar.getColorNo(),buyCar.getSizeNo(),buyCar.getProductNo(),buyCar.getUserAccount(),buyCar.getTagPrice(),buyCar.getZk(),buyCar.getAmount(),buyCar.getUserName()};
		int count=0;
		try {
			count = executeUpdate(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public BuyCar getBuyCar(String productNo,String userAccount,String colorNo,String sizeNo) {
		String sql="SELECT * FROM `buycar` WHERE `productNo`=? AND userAccount=? AND colorNo=? AND sizeNo=?;";
		return getOne(sql, BuyCar.class, productNo,userAccount,colorNo,sizeNo);
	}

	@Override
	public int updateBuyCarCount(int id) {
		String sql="UPDATE `buycar` SET `count`=`count`+1,amount=tagPrice*`count` WHERE id=?";
		int count=0;
		try {
			count=executeUpdate(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
