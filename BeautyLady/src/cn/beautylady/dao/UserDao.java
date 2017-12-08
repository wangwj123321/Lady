package cn.beautylady.dao;

import cn.beautylady.entity.User;
/**
 * 管理员信息操作接口
 * @author acsars
 *
 */
public interface UserDao {

    /**
     * 查找管理员对象
     * @param user 登陆输入的管理员对象
     * @return 查找到的管理元=员对象
     */
    public User findUser(User user);

    /**
     * 通过用户名查找用户（判断用户输入的用户名是否存在）
     * @param userAccount 用户名
     * @return 用户对象
     */
    public User getUserByUserAccount(String userAccount);
}
