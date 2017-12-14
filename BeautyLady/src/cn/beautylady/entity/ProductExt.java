package cn.beautylady.entity;

import java.util.Date;

/**
 * 商品的扩展类
 * 多个颜色编号和颜色名称用逗号隔开的
 * @author 王
 *
 */
public class ProductExt {
	private String productNo ;         
	private String productName ;          
	private String unit  ;        
	private String colorNo ;         
	private String colorName ;           
	private String sizeNo ;        
	private String sizeName ;        
	private Double tagPrice ;          
	private Double costPrice ;       
	private String categoryName ;         
	private String subclassesName ;          
	private String bandName ;          
	private String themeName;           
	private String seriesName ;          
	private Integer year ;          
	private Integer quarter;     
	private Integer status;           
	private String picpath ;          
	private String createdBy;          
	private Date createDate;          
	private String modifyBy;          
	private Date modifyDate;
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubclassesName() {
		return subclassesName;
	}
	public void setSubclassesName(String subclassesName) {
		this.subclassesName = subclassesName;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getQuarter() {
		return quarter;
	}
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
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
		return "ProductExt [productNo=" + productNo + ", productName=" + productName + ", unit=" + unit + ", colorNo="
				+ colorNo + ", colorName=" + colorName + ", sizeNo=" + sizeNo + ", sizeName=" + sizeName + ", tagPrice="
				+ tagPrice + ", costPrice=" + costPrice + ", categoryName=" + categoryName + ", subclassesName="
				+ subclassesName + ", bandName=" + bandName + ", themeName=" + themeName + ", seriesName=" + seriesName
				+ ", year=" + year + ", quarter=" + quarter + ", status=" + status + ", picpath=" + picpath
				+ ", createdBy=" + createdBy + ", createDate=" + createDate + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
}
