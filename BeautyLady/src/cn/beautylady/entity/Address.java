package cn.beautylady.entity;
/**
 * 地址类
 * @author acsars
 *
 */
public class Address {
	private Integer id;
	private String userAccount;
	private String address;
	private String name;
	private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address(Integer id, String userAccount, String address, String name, String phone) {
		super();
		this.id = id;
		this.userAccount = userAccount;
		this.address = address;
		this.name = name;
		this.phone = phone;
	}
	public Address() {
		super();
	}
	
	

	
}
