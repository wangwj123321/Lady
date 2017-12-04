package cn.beautylady.entity;

import java.util.List;

/**
 * Created by 王 on 2017/11/26.
 */
public class Role {
	private Integer id;
	private String roleName;
	private Integer status;
	private String description;
	private List<Privilege> privilegeList;
	
	
	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", status=" + status + ", description=" + description
				+ "]";
	}
	
	
}
