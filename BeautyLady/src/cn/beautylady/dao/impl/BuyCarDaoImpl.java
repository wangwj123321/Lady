package cn.beautylady.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.BuyCarDao;
import cn.beautylady.entity.BuyCar;

public class BuyCarDaoImpl extends BaseDao implements BuyCarDao{

	@Override
	public int addBuyCar(BuyCar buyCar) {
		String sql="INSERT INTO `buycar` VALUES(NULL,?,?,?,?,'1',NULL,?,?,?,?,1)";
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
		String sql="SELECT * FROM `buycar` WHERE `productNo`=? AND userAccount=? AND colorNo=? AND sizeNo=? AND `buycar`.`status`='1';";
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

	@Override
	public List<BuyCar> getBuyCarByUserAccount(String userAccount) {
		String sql="SELECT `buycar`.*,`product`.`productName`,`color`.`colorName`,`size`.`sizeName`,`product`.`picpath`\r\n" + 
				"FROM `buycar`,`product`,`color`,`size` \r\n" + 
				"WHERE `buycar`.`productNo`=`product`.`productNo` \r\n" + 
				"AND `buycar`.`colorNo`=`color`.`colorNo`\r\n" + 
				"AND `buycar`.`sizeNo`=`size`.`sizeNo`\r\n" + 
				"AND userAccount=? AND `buycar`.`status`='1'";
		return getArrayList(sql, BuyCar.class, userAccount);
	}

	@Override
	public int delBuyCar(int id) {
		String sql="DELETE FROM `buycar` WHERE id=?";
		int count=0;
		try {
			count=executeUpdate(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateCount(int id, int count) {
		String sql="UPDATE `buycar` SET `count`=?,amount=tagPrice*`count` WHERE id=?";
		int num=0;
		try {
			count=executeUpdate(sql, count,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public BuyCar getBuyCarById(int id) {
		String sql="SELECT `buycar`.*,`product`.`productName`,`color`.`colorName`,`size`.`sizeName`,`product`.`picpath`\r\n" + 
				"FROM `buycar`,`product`,`color`,`size` \r\n" + 
				"WHERE `buycar`.`productNo`=`product`.`productNo` \r\n" + 
				"AND `buycar`.`colorNo`=`color`.`colorNo`\r\n" + 
				"AND `buycar`.`sizeNo`=`size`.`sizeNo` \r\n" + 
				"AND `buycar`.id=?";
		return getOne(sql, BuyCar.class, id);
	}
	
}
