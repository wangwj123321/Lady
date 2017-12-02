package cn.beautylady.entity;

import java.util.Date;

/**
 * 顾客类
 * @author acsars
 *
 */
public class Customer {
	private Integer id;//序列号
	private String customerAccount;//客户账号
	private String customerName;//客户姓名
	private String customerPwd;//密码
	private String mobile;//手机号
	private String[] addresses;//送货地址
    private Integer status;//状态信息
    private String createdBy;//创建者
    private Date createDate;//创建时间
    private String modifyBy;//修改者
    private Date modifyDate;//修改时间  
	@Override
    public String toString() {
        return "Customer{" +
        		"id'" + id + '\'' +
                "customerAccount='" + customerAccount + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPwd='" + customerPwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", addresses='" + addresses.toString() + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
