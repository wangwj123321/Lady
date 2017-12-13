package cn.beautylady.entity;

import java.util.Date;
import java.util.List;

/**
 * 鐢ㄦ埛琛�
 * Created by 鐜� on 2017/11/26.
 */
public class User {
    private Integer id;
    private String userAccount;
    private String userName;
    private String password;
    private Integer status;
    private String createdBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate;
    private String acode;
    private String email;
    /**
     * 涓�涓敤鎴锋湁澶氫釜瑙掕壊
     * 瑙掕壊鐨勯泦鍚�
     */
    private List<Role> RoleList;
    public List<Role> getRoleList() {
		return RoleList;
	}
	public void setRoleList(List<Role> roleList) {
		RoleList = roleList;
	}

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public String getAcode() {
		return acode;
	}
    
	public void setAcode(String acode) {
		this.acode = acode;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
