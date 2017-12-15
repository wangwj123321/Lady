package cn.beautylady.dao;

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
}
