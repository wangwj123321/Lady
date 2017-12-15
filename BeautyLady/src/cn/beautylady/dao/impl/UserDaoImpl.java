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
		/*String sql = "SELECT * FROM `user` WHERE userAccount = ? AND `password` = ?";
		return getOne(sql, user.getClass(), user.getUserAccount(),user.getPassword());*/
		try {
			return select(user).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUserAccount(String userAccount) {
		String sql="SELECT * FROM `user` WHERE userAccount=?";
		return getOne(sql, User.class, userAccount);
	}

	@Override
	public User getUserByEmail(String email) {
		String sql="SELECT * FROM `user` WHERE email=?";
		return getOne(sql, User.class, email);
	}
}
