package cn.beautylady.service;

import java.util.List;

import cn.beautylady.entity.Collect;

public interface CollectService {
	/**
	 * 增加收藏
	 * @param collect
	 * @return
	 */
	public boolean addCollect(Collect collect);
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
	public boolean delCollect(int id);
}
