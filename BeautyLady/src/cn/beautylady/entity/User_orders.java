package cn.beautylady.entity;

   /**
    * Mon Dec 18 16:55:40 CST 2017 
    */ 
public class User_orders{
	private Integer id;
	private String orderNo;
	private String address;
	private String name;
	private String phone;
	private String productNo;
	private String productName;
	private String picpath;
	private Double tagPrice;
	private Integer count;
	private Double amount;
	private String colorName;
	private String sizeName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setOrderNo(String orderNo){
		this.orderNo=orderNo;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setProductNo(String productNo){
		this.productNo=productNo;
	}
	public String getProductNo(){
		return productNo;
	}
	public void setProductName(String productName){
		this.productName=productName;
	}
	public String getProductName(){
		return productName;
	}
	public void setPicpath(String picpath){
		this.picpath=picpath;
	}
	public String getPicpath(){
		return picpath;
	}
	public void setTagPrice(Double tagPrice){
		this.tagPrice=tagPrice;
	}
	public Double getTagPrice(){
		return tagPrice;
	}
	public void setCount(Integer count){
		this.count=count;
	}
	public Integer getCount(){
		return count;
	}
	public void setAmount(Double amount){
		this.amount=amount;
	}
	public Double getAmount(){
		return amount;
	}
	public void setColorName(String colorName){
		this.colorName=colorName;
	}
	public String getColorName(){
		return colorName;
	}
	public void setSizeName(String sizeName){
		this.sizeName=sizeName;
	}
	public String getSizeName(){
		return sizeName;
	}
	
}

