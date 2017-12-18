package cn.beautylady.entity;
/**
 * 订单详情类
 * @author acsars
 *
 */
public class OrderDetail {
	private Integer id;
	private String orderNo;
	private String colorNo;
	private String sizeNo;
	private String productNo;
	private Double tagPrice;
	private Integer count;
	private Double amount;
	private Double zk;
	private Product product;
	private Color color;
	private Size size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getColorNo() {
		return colorNo;
	}
	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}
	public String getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String sizeNo) {
		this.sizeNo = sizeNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public Double getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(Double tagPrice) {
		this.tagPrice = tagPrice;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getZk() {
		return zk;
	}
	public void setZk(Double zk) {
		this.zk = zk;
	}
	public OrderDetail(Integer id, String orderNo, String colorNo, String sizeNo, String productNo, Double tagPrice,
			Integer count, Double amount, Double zk) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.colorNo = colorNo;
		this.sizeNo = sizeNo;
		this.productNo = productNo;
		this.tagPrice = tagPrice;
		this.count = count;
		this.amount = amount;
		this.zk = zk;
	}
	public OrderDetail() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	
}
