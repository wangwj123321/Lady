package cn.beautylady.entity;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class NewProduct {
	private Integer id;//id值
    private String productNo;//商品编号
    private String productName;//商品名称
    private String unit;//公司名 
    private Double costPrice;//成本价格
    private Double tagPrice;//售卖价格
    private Integer year;//商品年份
    private Integer quarter;//商品季节
    private String categoryNo;//大类编号
    private String categoryName;//大类名称
    private String subclassesNo;
    private String subclassesName;
    private String colorNo1;
    private String colorName1;
    private String colorNo2;
    private String colorName2;
    private String sizeNo;
    private String sizeName;
    private String bandNo;
    private String bandName;
    private String themeNo;
    private String themeName;
    private String seriesNo;
    private String seriesName;
    private String mainpic;//首页图片
    private String pic1;//小图1
    private String pic2;//小图2
    private String pic3;//小图3
    private String pic4;//小图4
    private String detailpic1;//细节图1
    private String detailpic2;//细节图2
    private String detailpic3;//细节图3
    private String magnifypic1;//放大镜1
    private String magnifypic2;//放大镜2
    private String colorpic1;//本商品颜色款式图
    private String colorpic2;//其他颜色款式图
    private List<Pic> picList;//图片名称集合
    private Integer status;
    private String picpath;
    private String createdBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate;
    
	public NewProduct() {
	}
	public NewProduct(String productNo, String productName, Double costPrice, Double tagPrice, Integer year, Integer quarter,
			String categoryNo, String categoryName, String subclassesNo, String subclassesName, String colorNo1,
			String colorName1, String colorNo2, String colorName2, String sizeNo, String sizeName, String bandNo,
			String bandName, String themeNo, String themeName, String seriesNo, String seriesName, String mainpic,
			String pic1, String pic2, String pic3, String pic4, String detailpic1, String detailpic2, String detailpic3,
			String magnifypic1, String magnifypic2, String colorpic1, String colorpic2,List<Pic> picList,String createdBy) {
		this.productNo = productNo;
		this.productName = productName;
		this.costPrice = costPrice;
		this.tagPrice = tagPrice;
		this.year = year;
		this.quarter = quarter;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.subclassesNo = subclassesNo;
		this.subclassesName = subclassesName;
		this.colorNo1 = colorNo1;
		this.colorName1 = colorName1;
		this.colorNo2 = colorNo2;
		this.colorName2 = colorName2;
		this.sizeNo = sizeNo;
		this.sizeName = sizeName;
		this.bandNo = bandNo;
		this.bandName = bandName;
		this.themeNo = themeNo;
		this.themeName = themeName;
		this.seriesNo = seriesNo;
		this.seriesName = seriesName;
		this.mainpic = mainpic;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.pic4 = pic4;
		this.detailpic1 = detailpic1;
		this.detailpic2 = detailpic2;
		this.detailpic3 = detailpic3;
		this.magnifypic1 = magnifypic1;
		this.magnifypic2 = magnifypic2;
		this.colorpic1 = colorpic1;
		this.colorpic2 = colorpic2;
		this.picList = picList;
		this.createdBy = createdBy;
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
		this.mainpic = this.productNo+"_list_1";
		this.pic1 = this.getProductNo()+"_m_1";
		this.pic2 = this.getProductNo()+"_m_2";
		this.pic3 = this.getProductNo()+"_m_3";
		this.pic4 = this.getProductNo()+"_m_4";
		this.detailpic1 = this.getProductNo()+"_m_5";
		this.detailpic2 = this.getProductNo()+"_m_6";
		this.detailpic3 = this.getProductNo()+"_m_7";
		this.magnifypic1 = this.getProductNo()+"_m_8";
		this.magnifypic2 = this.getProductNo()+"_b_8";
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
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
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
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubclassesNo() {
		return subclassesNo;
	}
	public void setSubclassesNo(String subclassesNo) {
		this.subclassesNo = subclassesNo;
	}
	public String getSubclassesName() {
		return subclassesName;
	}
	public void setSubclassesName(String subclassesName) {
		this.subclassesName = subclassesName;
	}
	public String getColorNo1() {
		return colorNo1;
	}
	public void setColorNo1(String colorNo1) {
		this.colorNo1 = colorNo1;
		this.colorpic1 = this.getProductNo()+"_list_"+this.colorNo1;
	}
	public String getColorName1() {
		return colorName1;
	}
	public void setColorName1(String colorName1) {
		this.colorName1 = colorName1;
	}
	public String getColorNo2() {
		return colorNo2;
	}
	public void setColorNo2(String colorNo2) {
		this.colorNo2 = colorNo2;
		this.colorpic2 = this.getProductNo()+"_list_"+this.colorNo2;
	}
	public String getColorName2() {
		return colorName2;
	}
	public void setColorName2(String colorName2) {
		this.colorName2 = colorName2;
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
	public String getBandNo() {
		return bandNo;
	}
	public void setBandNo(String bandNo) {
		this.bandNo = bandNo;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public String getThemeNo() {
		return themeNo;
	}
	public void setThemeNo(String themeNo) {
		this.themeNo = themeNo;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public String getMainpic() {
		return mainpic;
	}
	public void setMainpic(String mainpic) {
		this.mainpic = mainpic;
	}
	public String getPic1() {
		return pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
	}
	public String getDetailpic1() {
		return detailpic1;
	}
	public String getDetailpic2() {
		return detailpic2;
	}
	public String getDetailpic3() {
		return detailpic3;
	}
	public String getMagnifypic1() {
		return magnifypic1;
	}
	public String getMagnifypic2() {
		return magnifypic2;
	}
	public String getColorpic1() {
		return colorpic1;
	}
	public String getColorpic2() {
		return colorpic2;
	}
	public List<Pic> getPicList() {
		return picList;
	}
	public void setPicList(List<Pic> picList) {
		this.picList = picList;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
	
}
