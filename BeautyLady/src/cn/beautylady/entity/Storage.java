package cn.beautylady.entity;
/**
 * 库存类
 * @author acsars
 *
 */
public class Storage {
	private Integer id;//库存编号
	private Integer productNo;//商品编号
	private String sizeNo;//尺码尺码
	private String colorNo;//颜色编号
	private Integer storageNum;//库存数量
	private Double totalMoney;//金额
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
	public Integer getStorageNum() {
		return storageNum;
	}
	public void setStorageNum(Integer storageNum) {
		this.storageNum = storageNum;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
