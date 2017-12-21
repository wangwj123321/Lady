package cn.beautylady.dao.impl;
import java.sql.SQLException;
import java.util.List;

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

	@Override
	public int modifyUser(User user) throws SQLException {
		String sql = "update `user` set userName = ?,password = ?,email = ? where userAccount = ?";
		return executeUpdate(sql, user.getUserName(),user.getPassword(),user.getEmail(),user.getUserAccount());
	}

	@Override
	public int modifyUserStatusToZero(User user) throws SQLException {
		String sql = "update `user` set userName = ?,password = ?,email = ?,status = 0 where userAccount = ?";
		return executeUpdate(sql, user.getUserName(),user.getPassword(),user.getEmail(),user.getUserAccount());
	}

	@Override
	public List<User> getUsersList() {
		String sql = "select * from `user`";
		return getArrayList(sql, User.class);
	}

	@Override
	 public int FreeAndRecovery(Integer id,Integer status) throws SQLException {
		String sql = "update `user` set status = ? where id = ?";
		return executeUpdate(sql, status, id);
	}

	@Override
	public int addBackUser(User user) throws SQLException {
		String sql = "insert into `user`(userAccount,userName,password,email,acode,status,stage,createdBy) values(?,?,?,?,?,?,?,?)";
		return executeUpdate(sql, user.getUserAccount(),user.getUserName(),user.getPassword(),user.getEmail(),user.getAcode(),user.getStatus(),user.getStage(),user.getCreatedBy());
	}

}
