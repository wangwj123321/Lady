package cn.beautylady.entity;

/**
 * 订单明细类
 * @author 王
 *
 */
public class StorageOrderDetail {
	private Integer id;
	private String orderNo;
	private String productNo;
	private String colorName;
	private String colorNo;
	private String sizeName;
	private String sizeNo;
	private Integer number;
	private Double totalMoney;
	
	public StorageOrderDetail() {
	}
	public StorageOrderDetail(String order, String productNo, String colorNo, String sizeNo, Integer number,
			Double totalMoney) {
		this.orderNo=order;
		this.productNo=productNo;
		this.colorNo=colorNo;
		this.sizeNo=sizeNo;
		this.number=number;
		this.totalMoney=totalMoney;
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
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
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
	@Override
	public String toString() {
		return "StorageOrderDetail [id=" + id + ", orderNo=" + orderNo + ", productNo=" + productNo + ", colorName="
				+ colorName + ", colorNo=" + colorNo + ", sizeName=" + sizeName + ", sizeNo=" + sizeNo + ", number="
				+ number + ", totalMoney=" + totalMoney + "]";
	}
	
	
}
