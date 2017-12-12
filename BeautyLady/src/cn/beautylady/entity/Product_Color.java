package cn.beautylady.entity;

public class Product_Color {
	private Integer id;
	private String productNo;
	private String colorNo;
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
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	@Override
	public String toString() {
		return "Product_Color [id=" + id + ", productNo=" + productNo + ", colorNo=" + colorNo + "]";
	}
	
	

}
