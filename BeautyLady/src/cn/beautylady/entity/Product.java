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
    private Double tagprice;
    private Double costprice;
    private String categoryid;
    private String subclassesid;
    private String bandid;
    private String themeid;
    private String seriesid;
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
	public Double getTagprice() {
		return tagprice;
	}
	public void setTagprice(Double tagprice) {
		this.tagprice = tagprice;
	}
	public Double getCostprice() {
		return costprice;
	}
	public void setCostprice(Double costprice) {
		this.costprice = costprice;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getSubclassesid() {
		return subclassesid;
	}
	public void setSubclassesid(String subclassesid) {
		this.subclassesid = subclassesid;
	}
	public String getBandid() {
		return bandid;
	}
	public void setBandid(String bandid) {
		this.bandid = bandid;
	}
	public String getThemeid() {
		return themeid;
	}
	public void setThemeid(String themeid) {
		this.themeid = themeid;
	}
	public String getSeriesid() {
		return seriesid;
	}
	public void setSeriesid(String seriesid) {
		this.seriesid = seriesid;
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
        return "Product{" +
        		"id'" + id + '\'' +
                "productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", unit=" + unit +
                ", tagprice='" + tagprice + '\'' +
                ", costprice=" + costprice +
                ", categoryid='" + categoryid + '\'' +
                ", subclassesid='" + subclassesid + '\'' +
                ", bandid='" + bandid + '\'' +
                ", themeid='" + themeid + '\'' +
                ", seriesid='" + seriesid + '\'' +
                ", year='" + year + '\'' +
                ", quarter='" + quarter + '\'' +
                ", status='" + status + '\'' +
                ", picpath='" + picpath + '\'' +
                ", createdBy='" + createdBy + '\'' +
               ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
