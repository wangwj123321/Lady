package cn.beautylady.service.impl;

import java.sql.SQLException;

import cn.beautylady.dao.UserDao;
import cn.beautylady.dao.impl.UserDaoImpl;
import cn.beautylady.entity.User;
import cn.beautylady.service.UserService;

/**
 * 管理员信息服务实现类
 * @author acsars
 *
 */
public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		return dao.findUser(user);
	}
	
	@Override
	public boolean getUserByUserAccount(String userAccount) {
		User user=dao.getUserByUserAccount(userAccount);
		if (user!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getUserByEmail(String email) {
		User user=dao.getUserByEmail(email);
		if (user!=null) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUserAccounts(String userAccount) {
		return dao.getUserByUserAccount(userAccount);
	}

	@Override
	public User getUserByEmails(String email) {
		// TODO 自动生成的方法存根
		return dao.getUserByEmail(email);
	}

	@Override
	public int modifyUser(User user) throws SQLException {
		return dao.modifyUser(user);
	}

	@Override
	public int modifyUserStatusToZero(User user) throws SQLException {
		return dao.modifyUserStatusToZero(user);
	}

}
