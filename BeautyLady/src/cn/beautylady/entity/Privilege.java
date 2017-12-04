package cn.beautylady.entity;

/**
 * Created by 王 on 2017/11/26.
 */
public class Privilege {
	private Integer id;
	private String privilegeName;
	private String resource;
	private String description;
	private String stuffix;
	private String params;
	private Integer type;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStuffix() {
		return stuffix;
	}
	public void setStuffix(String stuffix) {
		this.stuffix = stuffix;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Privileges [id=" + id + ", privilegeName=" + privilegeName + ", resource=" + resource + ", description="
				+ description + ", stuffix=" + stuffix + ", params=" + params + ", type=" + type + ", status=" + status
				+ "]";
	}
	
	
}
