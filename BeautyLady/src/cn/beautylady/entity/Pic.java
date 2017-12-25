package cn.beautylady.entity;

public class Pic {
	private Integer id;
	private String productNo;
	private String colorNo;
	private String picpath;
	public Pic() {
	}
	
	public Pic(String productNo, String colorNo, String picpath) {
		super();
		this.productNo = productNo;
		this.colorNo = colorNo;
		this.picpath = picpath;
	}

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
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
}
