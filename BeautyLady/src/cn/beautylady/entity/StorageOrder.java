package cn.beautylady.entity;

import java.util.Date;

/**
 * 入库单
 * @author acsars
 *
 */
public class StorageOrder {
	private Integer id;			//主键id
	private String orderNo;		//订单编号
	private String productNo;	//商品编号
	private String colorNo;		//颜色编号
	private String sizeNo;		//尺码编号
	private Integer number;		//入库数量
	private Double totalMoney;	//入库金额
	private Date storageDate;	//入库时间
	private String userName;	//入库操作用户
	private String desc;		//订单描述
	private Integer status;		//状体
	private String createdBy;	//创建时间
	private Date createDate;	//创建时间
	private String modifyBy;	//修改者
	private Date modifyDate;	//修改时间
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
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return "StorageOrder [id=" + id + ", orderNo=" + orderNo + ", productNo=" + productNo + ", colorNo=" + colorNo
				+ ", sizeNo=" + sizeNo + ", number=" + number + ", totalMoney=" + totalMoney + ", storageDate="
				+ storageDate + ", userName=" + userName + ", desc=" + desc + ", status=" + status + ", createdBy="
				+ createdBy + ", createDate=" + createDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ "]";
	}
	
	
	
}
