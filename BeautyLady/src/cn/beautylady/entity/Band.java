package cn.beautylady.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/25.
 */
public class Band {
	private Integer id;
    private String bandNo;
    private String bandName;
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
	public String getBandNo() {
		return bandNo;
	}
	public void setBandNo(String bandNo) {
		this.bandNo = bandNo;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
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
        return "Band{" +
        		"id'" + id + '\'' +
                "bandNo='" + bandNo + '\'' +
                ", bandName='" + bandName + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
               ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
