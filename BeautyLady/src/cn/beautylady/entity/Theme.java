package cn.beautylady.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/25.
 */
public class Theme {
	private Integer id;
    private String themeNo;
    private String themeName;
    private Integer status;
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
	@Override
    public String toString() {
        return "Theme{" +
        		"id'" + id + '\'' +
                "themeNo='" + themeNo + '\'' +
                ", themeName='" + themeName + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
