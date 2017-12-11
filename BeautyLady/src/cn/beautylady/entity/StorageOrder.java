package cn.beautylady.entity;

import java.util.Date;

/**
 * 入库单
 * @author acsars
 *
 */
public class StorageOrder {
	private Integer id;//入库单号
	private Integer productNo;//商品编号
	private String colorName;//颜色名称
	private String sizeName;//尺码名称
	private Integer storageNum;//入库数量
	private Date storageDate;//入库时间
	private Customer customer;//客户账号
    private Integer status;
    private String createdBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate; 
	@Override
    public String toString() {
        return "StorageOrder{" +
        		"id'" + id + '\'' +
                "productNo='" + productNo + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", storageNum='" + storageNum + '\'' +
                ", storageDate='" + storageDate.toString() + '\'' +
                ", customer='" + customer + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate.toString() +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate.toString() +
                '}';
    }
}
