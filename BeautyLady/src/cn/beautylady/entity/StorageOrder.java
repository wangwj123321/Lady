package cn.beautylady.entity;

import java.util.Date;

/**
 * 入库单
 * @author acsars
 *
 */
public class StorageOrder {

	private Integer id;
	private String orderNo;
	private Double totalMoney;
	private Integer number;
	private Integer status;
	private Date storageDate;
	private String userName;
	private String desc;
	private Date createDate;
	private String createdBy;
	private String modifyBy;
	private Date modifyDate;
	
	
	
	public StorageOrder() {
	}
	public StorageOrder(String order ,String userName, Integer totalNum, Double totalMoney, String desc) {
		this.orderNo=order;
		this.createdBy=userName;
		this.number=totalNum;
		this.totalMoney=totalMoney;
		this.desc=desc;
		
	}
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
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStorageDate() {
		return storageDate;
	}
	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "StorageOrder [id=" + id + ", orderNo=" + orderNo + ", totalMoney=" + totalMoney + ", number=" + number
				+ ", status=" + status + ", storageDate=" + storageDate + ", userName=" + userName + ", desc=" + desc
				+ ", createDate=" + createDate + ", createdBy=" + createdBy + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
}
