package cn.beautylady.dao.impl;
import cn.beautylady.dao.BaseDao;
import cn.beautylady.dao.UserDao;
import cn.beautylady.entity.User;
/**
 * 管理员操作实现类
 * @author acsars
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User findUser(User user) {
		String sql = "SELECT * FROM `user` WHERE userAccount = ? AND `password` = ?";
		return getOne(sql, user.getClass(), user.getUserAccount(),user.getPassword());
	}

	@Override
	public User getUserByUserAccount(String userAccount) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `user` WHERE userAccount=?";
		return getOne(sql, User.class, userAccount);
	}
}
