package cn.beautylady.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/28.
 */
public class Series {
	private Integer id;
    private String seriesNo;
    private String seriesName;
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
	public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
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
        return "Series{" +
        		"id='" + id + '\'' +
                "seriesNo='" + seriesNo + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
               ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
