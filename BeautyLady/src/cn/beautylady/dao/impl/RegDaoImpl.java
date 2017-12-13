package cn.beautylady.dao.impl;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.RegDAO;
import cn.beautylady.entity.User;

public class RegDaoImpl extends BaseDao implements RegDAO {
	@Override
	public User reg(User user) {
		String sql = "insert into user(userAccount,userName,password,status,createdBy,acode,email) values(?,?,?,?,?,?,?)";
		String acode = UUID.randomUUID().toString().replaceAll("-", "");
		Object[] param = {user.getUserAccount(),user.getUserName(),user.getPassword(),0,"咸鱼",acode,user.getEmail()};
		try {
			executeUpdate(sql, param);
			user.setAcode(acode);
			user.setStatus(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	public int active(String acode) {
		String sql = "select count(1) from user where acode=? and status=0";
		
		try {
			int count =getCount(sql, acode);
			if (count == 0) {
				sql = "select count(1) from user where acode=? and status=1";
				count = getCount(sql, acode);
				if(count==1){
					return 1;//已经注册过了
				}else{
					return 0;//没有对应的acode
				}
			} else {
				sql = "update user set status =1 where acode=?";
				executeUpdate(sql, acode);
				return 2;//成功注册
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//出异常
		}
	}
}
