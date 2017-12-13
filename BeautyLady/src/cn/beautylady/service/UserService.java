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
    
    /**
     * 通过用户名查找用户（判断用户输入的用户名是否存在）
     * @param userAccount 用户名
     * @return 用户对象
     */
    public boolean  getUserByUserAccount(String userAccount);
    
    /**
     * 通过邮箱查找用户（判断是否存在邮箱）
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email);
}
