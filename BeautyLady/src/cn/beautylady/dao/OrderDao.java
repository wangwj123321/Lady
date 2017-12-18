package cn.beautylady.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.beautylady.entity.Order;
import cn.beautylady.entity.OrderDetail;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order 订单对象
	 * @return 影响行数
	 */
	public int addOrder(Order order);
	/**
	 * 获取指定订单号的订单
	 * @param orderNo 订单号
	 * @return
	 */
	public Order getOrderByOrderNo(String orderNo);
	/**
	 * 获取用户最后一次添加的订单
	 * @param userAccount 用户名
	 * @return 订单对象
	 */
	public Order getUserAccountLastOrder(String userAccount);
	/**
	 * 添加订单详情
	 * @param orderDetail 订单详情对象
	 * @return 影响行数
	 */
	public int addOrderDetail(OrderDetail orderDetail);
	
	/**
	 * 获取用户订单列表
	 * @param userAccount 用户登录名
	 * @return 对应用户的订单列表
	 */
	public List<Order> getOrderByUserAccount(String userAccount);
	
	/**
	 * 获取订单详情列表
	 * @param OrderNo 订单号
	 * @return 订单详情列表
	 */
	public List<OrderDetail> getOrderDetailByOrderNo(String orderNo);
	
	/**
	 * 按照id查找订单
	 * @return 订单详情
	 */
	public OrderDetail getOrderDetailById(Integer id) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException;
}
