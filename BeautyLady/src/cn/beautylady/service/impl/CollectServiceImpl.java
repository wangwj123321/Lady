package cn.beautylady.service.impl;

import java.util.List;

import cn.beautylady.dao.CollectDao;
import cn.beautylady.dao.impl.CollectDaoImpl;
import cn.beautylady.entity.Collect;
import cn.beautylady.service.CollectService;

public class CollectServiceImpl implements CollectService{
	private CollectDao collectDao=new CollectDaoImpl();
	@Override
	public boolean addCollect(Collect collect) {
		int count=collectDao.addCollect(collect);
		return count==1?true:false;
	}
	@Override
	public List<Collect> getCollectList(String userAccount) {
		return collectDao.getCollectList(userAccount);
	}
	@Override
	public boolean delCollect(int id) {
		int count=collectDao.delCollect(id);
		return count==1?true:false;
	}
	
}
