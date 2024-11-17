package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName active
 */
@TableName(value ="active")
public class Active implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动id
     */
    private String activeId;

    /**
     * 活动名称
     */
    private String activeName;

    /**
     * 策略id
     */
    private String strategyId;

    /**
     * 活动描述
     */
    private String descripe;

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
     * 活动id
     */
    public String getActiveId() {
        return activeId;
    }

    /**
     * 活动id
     */
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    /**
     * 活动名称
     */
    public String getActiveName() {
        return activeName;
    }

    /**
     * 活动名称
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    /**
     * 策略id
     */
    public String getStrategyId() {
        return strategyId;
    }

    /**
     * 策略id
     */
    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * 活动描述
     */
    public String getDescripe() {
        return descripe;
    }

    /**
     * 活动描述
     */
    public void setDescripe(String descripe) {
        this.descripe = descripe;
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
        Active other = (Active) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActiveId() == null ? other.getActiveId() == null : this.getActiveId().equals(other.getActiveId()))
            && (this.getActiveName() == null ? other.getActiveName() == null : this.getActiveName().equals(other.getActiveName()))
            && (this.getStrategyId() == null ? other.getStrategyId() == null : this.getStrategyId().equals(other.getStrategyId()))
            && (this.getDescripe() == null ? other.getDescripe() == null : this.getDescripe().equals(other.getDescripe()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActiveId() == null) ? 0 : getActiveId().hashCode());
        result = prime * result + ((getActiveName() == null) ? 0 : getActiveName().hashCode());
        result = prime * result + ((getStrategyId() == null) ? 0 : getStrategyId().hashCode());
        result = prime * result + ((getDescripe() == null) ? 0 : getDescripe().hashCode());
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
        sb.append(", activeId=").append(activeId);
        sb.append(", activeName=").append(activeName);
        sb.append(", strategyId=").append(strategyId);
        sb.append(", descripe=").append(descripe);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}