package cn.beautylady.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/25.
 */
public class Category {
	private Integer id;
    private String categoryNo;
    private String categoryName;
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
        return "Category{" +
        		"id'" + id + '\'' +
                "categoryNo='" + categoryNo + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
