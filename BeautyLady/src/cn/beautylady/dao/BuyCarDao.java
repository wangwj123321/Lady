package cn.beautylady.dao;

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
	 * 修改购物车商品的数量
	 * @param id 购物车记录id
	 * @return 影响行数
	 */
	public int updateBuyCarCount(int id);
}
