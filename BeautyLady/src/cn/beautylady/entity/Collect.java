package cn.beautylady.entity;
/**
 * 收藏实体类
 * @author Administrator
 *
 */

import java.util.Date;

public class Collect {
	private Integer id;
	private String userAccount;
	private String userName;
	private String productNo;
	private String subClassesName;
	private Date createDate;
	private String picpath;
	private Double tagPrice; 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public String getSubClassesName() {
		return subClassesName;
	}
	public void setSubClassesName(String subClassesName) {
		this.subClassesName = subClassesName;
	}
	
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	public Collect(Integer id, String userAccount, String userName, String productNo, String subClassesName,
			Date createDate) {
		super();
		this.id = id;
		this.userAccount = userAccount;
		this.userName = userName;
		this.productNo = productNo;
		this.subClassesName = subClassesName;
		this.createDate = createDate;
	}
	public Collect() {
		super();
	}
	
}
