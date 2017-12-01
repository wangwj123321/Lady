package cn.beautylady.service;

import cn.beautylady.entity.User;
/**
 * 管理员信息服务接口
 * @author acsars
 *
 */
public interface UserService {
	/**
	 * 登录用户信息
	 * @param user 登录用户
	 * @return
	 */
    public User login(User user);
}
