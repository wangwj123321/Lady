package cn.beautylady.entity;
/**
 * 库存类
 * @author acsars
 *
 */
public class Storage {
	private Integer id;//库存编号
	private Integer productNo;//商品编号
	private String sizeName;//尺码名称
	private String colorName;//颜色名称
	private Integer storageNum;//库存数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Integer getStorageNum() {
		return storageNum;
	}
	public void setStorageNum(Integer storageNum) {
		this.storageNum = storageNum;
	}
	@Override
    public String toString() {
        return "Storage{" +
        		"id'" + id + '\'' +
                "productNo='" + productNo + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", colorName=" + colorName +
                ", storageNum='" + storageNum + '\'' +
                '}';
    }
}
