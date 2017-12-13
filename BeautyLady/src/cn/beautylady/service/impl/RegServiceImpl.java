package cn.beautylady.service.impl;

import cn.beautylady.dao.RegDAO;
import cn.beautylady.dao.impl.RegDaoImpl;
import cn.beautylady.entity.User;
import cn.beautylady.service.IRegService;

public class RegServiceImpl implements IRegService{
	//依赖注入
	private RegDAO dao = new RegDaoImpl();
	@Override
	public User reg(User user) {
		return dao.reg(user);
	}
	@Override
	public int active(String acode) {
		return dao.active(acode);
	}
}
