package cn.beautylady.service;

import java.util.List;

import cn.beautylady.entity.BuyCar;

public interface BuyCarService {
	/**
	 * 添加购物车记录 
	 * @param buyCar 购物车对象
	 * @return 是否添加成功
	 */
	public boolean addBuyCar(BuyCar buyCar);
	/**
	 * 根据用户编号和商品编号获得购物车记录
	 * @param productNo 商品编号
	 * @param userAccount 用户编号
	 * @return 购物车记录
	 */
	public BuyCar getBuyCar(String productNo,String userAccount,String colorNo,String sizeNo);
	/**
	 * 购物车商品数量加1
	 * @param id 购物id
	 * @return 是否更新成功
	 */
	public boolean updateBuyCarCount(int id);
	/**
	 * 获取用户的购物车的商品列表
	 * @param userAccount 用户名
	 * @return 商品列表
	 */
	public List<BuyCar> getBuyCarByUserAccount(String userAccount);
	/**
	 * 删除购物车商品
	 * @param id 购物车记录id 
	 * @return 是否成功 
	 */
	public boolean delBuyCar(int id);
	/**
	 * 修改购物车商品数量
	 * @param id 购物车记录id 
	 * @param count 修改的数量
	 * @return 是否成功
	 */
	public boolean updateCount(int id,int count);
	/**
	 * 通过id获取购物车记录
	 * @param id 记录id
	 * @return 购物车记录对象
	 */
	public BuyCar getBuyCarById(int id);
	/**
	 * 修改购物车记录为已结算
	 * @param id 购物车记录id
	 * @return 是否成功
	 */
	public boolean updateBuyCarStatus(int id);
}
