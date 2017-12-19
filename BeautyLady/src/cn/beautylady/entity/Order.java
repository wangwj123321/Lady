package cn.beautylady.entity;

import java.util.Date;
import java.util.List;

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
	private List<User_orders> user_Orders;
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
	public List<User_orders> getUser_Orders() {
		return user_Orders;
	}
	public void setUser_Orders(List<User_orders> user_Orders) {
		this.user_Orders = user_Orders;
	}
	
}
