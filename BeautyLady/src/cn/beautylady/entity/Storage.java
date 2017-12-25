package cn.beautylady.entity;
/**
 * 库存类
 * @author acsars
 *
 */
public class Storage {
	private Integer id;//库存编号
	private String productNo;//商品编号
	private String sizeNo;//尺码尺码
	private String colorNo;//颜色编号
	private Integer number;//库存数量
	private Double totalMoney;//金额
	private Double tagPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
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
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	
	
	
}
