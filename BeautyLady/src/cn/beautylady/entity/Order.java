package cn.beautylady.entity;

import java.util.Date;

/**
 * 订单类
 * @author acsars
 *
 */
public class Order {
	private Integer id;//序列号
	private Integer OrderNo;//订单编号
	private String colorName;//颜色名称
	private String  sizeName;//尺码名称
	private Double payPrice;//付款金额
	private Double discount;//打折
	private Double totalPrice;//总价
	private Integer productNum;//商品数量
	private Date sendDate;//发货日期
	private String comment;//评论
	private boolean isReceived;//确认收货
	private User user;//用户账号
	private Date payDate;//付款日期
	   public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(Integer orderNo) {
		OrderNo = orderNo;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public Double getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Double payPrice) {
		this.payPrice = payPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@Override
	    public String toString() {
	        return "Order{" +
	        		"id'" + id + '\'' +
	                "OrderNo='" + OrderNo + '\'' +
	                ", colorName='" + colorName + '\'' +
	                ", sizeName='" + sizeName + '\'' +
	                ", payPrice='" + payPrice + '\'' +
	                ", discount='" + discount + '\'' +
	                ", totalPrice='" + totalPrice + '\'' +
	                ", productNum='" + productNum + '\'' +
	                ", sendDate=" + sendDate.toString() +
	                ", comment='" + comment + '\'' +
	                ", isReceived=" + isReceived +
	                ", user='" + user.getUserName() + '\'' +
	                ", payDate=" + payDate.toString() +
	                '}';
	    }
}
