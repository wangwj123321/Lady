package cn.beautylady.service.impl;

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

}
