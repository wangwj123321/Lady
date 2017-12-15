package cn.beautylady.entity;

import java.util.Date;

/**
 * 订单类
 * @author acsars
 *
 */
public class Order {
	private Integer id;
	private String orderNo;
	private String userAccount;
	private String userName;
	private Integer addressID;
	private Date createDate;
	private Double costPrice;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	public Integer getAddressID() {
		return addressID;
	}
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Order(Integer id, String orderNo, String userAccount, String userName, Integer addressID, Date createDate,
			Double costPrice, Integer status) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userAccount = userAccount;
		this.userName = userName;
		this.addressID = addressID;
		this.createDate = createDate;
		this.costPrice = costPrice;
		this.status = status;
	}
	public Order() {
		super();
	}
	
}
