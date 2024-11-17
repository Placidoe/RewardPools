package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName active_sku
 */
@TableName(value ="active_sku")
public class ActiveSku implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * skuid
     */
    private String skuId;

    /**
     * sku名字
     */
    private String skuName;

    /**
     * sku描述
     */
    private String descripe;

    /**
     * sku价格
     */
    private String price;

    /**
     * skuinfoid
     */
    private String priceinfoId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * skuid
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * skuid
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * sku名字
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * sku名字
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    /**
     * sku描述
     */
    public String getDescripe() {
        return descripe;
    }

    /**
     * sku描述
     */
    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }

    /**
     * sku价格
     */
    public String getPrice() {
        return price;
    }

    /**
     * sku价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * skuinfoid
     */
    public String getPriceinfoId() {
        return priceinfoId;
    }

    /**
     * skuinfoid
     */
    public void setPriceinfoId(String priceinfoId) {
        this.priceinfoId = priceinfoId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ActiveSku other = (ActiveSku) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getSkuName() == null ? other.getSkuName() == null : this.getSkuName().equals(other.getSkuName()))
            && (this.getDescripe() == null ? other.getDescripe() == null : this.getDescripe().equals(other.getDescripe()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPriceinfoId() == null ? other.getPriceinfoId() == null : this.getPriceinfoId().equals(other.getPriceinfoId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getSkuName() == null) ? 0 : getSkuName().hashCode());
        result = prime * result + ((getDescripe() == null) ? 0 : getDescripe().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPriceinfoId() == null) ? 0 : getPriceinfoId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skuId=").append(skuId);
        sb.append(", skuName=").append(skuName);
        sb.append(", descripe=").append(descripe);
        sb.append(", price=").append(price);
        sb.append(", priceinfoId=").append(priceinfoId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}