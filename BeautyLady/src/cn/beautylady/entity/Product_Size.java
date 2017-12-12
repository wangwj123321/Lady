package cn.beautylady.entity;

public class Product_Size {
	private Integer id;
	private String productNo;
	private String sizeNo;
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
	@Override
	public String toString() {
		return "Product_Size [id=" + id + ", productNo=" + productNo + ", sizeNo=" + sizeNo + "]";
	}
	
	
}
