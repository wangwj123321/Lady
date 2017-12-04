package cn.beautylady.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/25.
 */
public class Product {
	private Integer id;
    private String productNo;
    private String productName;
    private String unit;
    private Double tagPrice;
    private Double costPrice;
    private String categoryNo;
    private String subclassesNo;
    private String bandNo;
    private String themeNo;
    private String seriesNo;
    private Integer year;
    private Integer quarter;
    private Integer status;
    private String picpath;
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
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getSubclassesNo() {
		return subclassesNo;
	}
	public void setSubclassesNo(String subclassesNo) {
		this.subclassesNo = subclassesNo;
	}
	public String getBandNo() {
		return bandNo;
	}
	public void setBandNo(String bandNo) {
		this.bandNo = bandNo;
	}
	public String getThemeNo() {
		return themeNo;
	}
	public void setThemeNo(String themeNo) {
		this.themeNo = themeNo;
	}
	public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
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
		return "Product [id=" + id + ", productNo=" + productNo + ", productName=" + productName + ", unit=" + unit
				+ ", tagPrice=" + tagPrice + ", costPrice=" + costPrice + ", categoryNo=" + categoryNo
				+ ", subclassesNo=" + subclassesNo + ", bandNo=" + bandNo + ", themeNo=" + themeNo + ", seriesNo="
				+ seriesNo + ", year=" + year + ", quarter=" + quarter + ", status=" + status + ", picpath=" + picpath
				+ ", createdBy=" + createdBy + ", createDate=" + createDate + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + "]";
	}
	
    
	
}
