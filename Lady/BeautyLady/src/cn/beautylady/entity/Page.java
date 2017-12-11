package cn.beautylady.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页页面类
 * @author acsars
 * @param <T>
 *
 */
public class Page<T>{
	private int pageNo;//当前页码
	private int dataCount;//总行数
	private int pageSize;//每页行数
	private int pageCount;//总页码数
	private String type;//当前页存储数据类型
	private List<T> list;//当前页的数据列表
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
			pageCount = dataCount%pageSize == 0 ? dataCount/pageSize : dataCount/pageSize + 1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
