package cn.beautylady.dao;

import java.util.List;

import cn.beautylady.entity.BuyCar;

public interface BuyCarDao {
	/**
	 * 用户添加商品到购物车
	 * @param buyCar 购物车
	 * @return 影响的行数
	 */
	public int addBuyCar(BuyCar buyCar);
	/**
	 * 根据用户编号和商品编号获得购物车记录
	 * @param productNo 商品编号
	 * @param userAccount 用户编号
	 * @return 购物车记录
	 */
	public BuyCar getBuyCar(String productNo,String userAccount,String colorNo,String sizeNo);
	/**
	 * 修改购物车商品的数量+1
	 * @param id 购物车记录id
	 * @return 影响行数
	 */
	public int updateBuyCarCount(int id);
	/**
	 * 获取用户的购物车的商品列表
	 * @param userAccount 用户名
	 * @return 商品列表
	 */
	public List<BuyCar> getBuyCarByUserAccount(String userAccount);
	/**
	 * 删除购物车商品
	 * @param id 购物车记录id 
	 * @return 影响行数 
	 */
	public int delBuyCar(int id);
	/**
	 * 修改购物车商品数量
	 * @param id 购物车记录id 
	 * @param count 修改的数量
	 * @return 影响行数
	 */
	public int updateCount(int id,int count);
	/**
	 * 通过id获取购物车记录
	 * @param id 记录id
	 * @return 购物车记录对象
	 */
	public BuyCar getBuyCarById(int id);
	/**
	 * 修改购物车记录为已结算
	 * @param id 购物车记录id
	 * @return 影响行数
	 */
	public int updateBuyCarStatus(int id);
	
}
