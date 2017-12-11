package cn.beautylady.entity;
/**
 * 库存类
 * @author acsars
 *
 */
public class Storage {
	private Integer id;//库存编号
	private Integer productNo;//商品编号
	private String colorNo;//颜色编号
	private String sizeNo;//尺码编号
	private Integer number;//库存数量
	private Double tagPrice;
	private Double totalMoney;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
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
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "Storage [id=" + id + ", productNo=" + productNo + ", colorNo=" + colorNo + ", sizeNo=" + sizeNo
				+ ", number=" + number + ", tagPrice=" + tagPrice + ", totalMoney=" + totalMoney + "]";
	}
	
	
	
}
