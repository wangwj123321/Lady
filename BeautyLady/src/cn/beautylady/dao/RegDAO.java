package cn.beautylady.dao;

import cn.beautylady.entity.User;

public interface RegDAO {
	/**
	 * 发送email的方法
	 * @param user
	 * @return
	 */
	public User reg(User user);
	/**
	 * 激活的方法
	 * @param acode
	 * @return
	 */
	public int active(String acode);
}
