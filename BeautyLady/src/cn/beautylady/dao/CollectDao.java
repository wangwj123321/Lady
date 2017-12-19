package cn.beautylady.dao;

import java.util.List;

import cn.beautylady.entity.Collect;

public interface CollectDao {
	/**
	 * 增加收藏
	 * @param collect
	 * @return
	 */
	public int addCollect(Collect collect);
	/**
	 * 获得用户收藏商品
	 * @param userAccount
	 * @return
	 */
	public List<Collect> getCollectList(String userAccount);
	/**
	 * 通过id删除收藏
	 * @param id
	 * @return
	 */
	public int delCollect(int id);
}
