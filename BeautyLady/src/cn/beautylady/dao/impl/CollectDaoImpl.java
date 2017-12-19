package cn.beautylady.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.CollectDao;
import cn.beautylady.entity.Collect;

public class CollectDaoImpl extends BaseDao implements CollectDao{

	@Override
	public int addCollect(Collect collect) {
		String sql="INSERT INTO `collect` VALUES(NULL,?,?,?,?,NOW())";
		Object[] objs= {collect.getUserAccount(),collect.getUserName(),collect.getProductNo(),collect.getSubClassesName()};
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
	public List<Collect> getCollectList(String userAccount) {
		String sql="SELECT `collect`.*,`product`.`picpath` picpath,`product`.`tagPrice`  tagPrice\r\n" + 
				"FROM `product`,`collect`\r\n" + 
				"WHERE `collect`.`productNo`=`product`.`productNo`\r\n" + 
				"AND `collect`.`userAccount`=?";
		return getArrayList(sql, Collect.class, userAccount);
	}

	@Override
	public int delCollect(int id) {
		String sql="DELETE FROM `collect` WHERE id=?";
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
