package cn.beautylady.entity;

import java.util.Date;

public class BuyCar {
	private Integer id;
	private String colorNo;
	private String sizeNo;
	private String productNo;
	private String userAccount;
	private Integer status;
	private Date createDate;
	private Double tagPrice;
	private Double zk;
	private Double amount;
	private String userName;
	private Integer count;
	private String productName;
	private String colorName;
	private String sizeName;
	private String picpath;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	public Double getZk() {
		return zk;
	}
	public void setZk(Double zk) {
		this.zk = zk;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public BuyCar(Integer id, String colorNo, String sizeNo, String productNo, String userAccount, Integer status,
			Date createDate, Double tagPrice, Double zk, Double amount, String userName, Integer count) {
		super();
		this.id = id;
		this.colorNo = colorNo;
		this.sizeNo = sizeNo;
		this.productNo = productNo;
		this.userAccount = userAccount;
		this.status = status;
		this.createDate = createDate;
		this.tagPrice = tagPrice;
		this.zk = zk;
		this.amount = amount;
		this.userName = userName;
		this.count = count;
	}
	public BuyCar() {
		super();
	}
	
	
}
