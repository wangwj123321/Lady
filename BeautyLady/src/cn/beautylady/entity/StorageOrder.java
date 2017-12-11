package cn.beautylady.entity;

import java.util.Date;

/**
 * 入库单
 * @author acsars
 *
 */
public class StorageOrder {
<<<<<<< HEAD
	private Integer id;//入库单号
	private Integer productNo;//商品编号
	private String colorName;//颜色名称
	private String sizeName;//尺码名称
	private Integer storageNum;//入库数量
	private Date storageDate;//入库时间
	private Customer customer;//客户账号
    private Integer status;
    private String createdBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate; 
	@Override
    public String toString() {
        return "StorageOrder{" +
        		"id'" + id + '\'' +
                "productNo='" + productNo + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", storageNum='" + storageNum + '\'' +
                ", storageDate='" + storageDate.toString() + '\'' +
                ", customer='" + customer + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
=======
	private Integer id;
	private String orderNo;
	private String productNo;
	private String colorNo;
	private String sizeNo;
	private Integer number;
	private Double totalMoney;
	private Date storageDate;
	private String userName;
	private Integer status;
	private String createdBy;
	private Date createDate;
	private String modifyBy;
	private Date modifyDate;
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
				+ storageDate + ", userName=" + userName + ", status=" + status + ", createdBy=" + createdBy
				+ ", createDate=" + createDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	
	
	
	
>>>>>>> parent of 328ac1a... 添加了入库单实体类
}
