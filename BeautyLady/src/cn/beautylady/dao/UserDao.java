package cn.beautylady.dao;

import java.sql.SQLException;
import java.util.List;

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
    
    /**
     * 通过邮箱查找用户（判断是否存在邮箱）
     * @param email
     * @return
     */
    public User getUserByEmail(String email);
    
    /**
     * 修改用户的方法
     * @param user 要修改的用户
     * @return 影响行数
     */
    public int modifyUser(User user) throws SQLException;
    /**
     * 修改用户的方法
     * @param user 要修改的用户
     * @return 影响行数
     */
    public int modifyUserStatusToZero(User user) throws SQLException;
    
    /**
     * 获得所有用户列表
     * @return
     */
    public List<User> getUsersList();
    
    /**
     * 后台停用用户
     * @param id 用户id
     * @return 影响行数
     */
    public int FreeAndRecovery(Integer id,Integer status) throws SQLException;
    
    /**
     * 添加后台人员功能
     * @param user 后台人员对象
     * @return
     * @throws SQLException 
     */
    public int addBackUser(User user) throws SQLException;
}
