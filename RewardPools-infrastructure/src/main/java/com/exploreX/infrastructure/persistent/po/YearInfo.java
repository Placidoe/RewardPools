package com.exploreX.infrastructure.persistent.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName year_info
 */
@TableName(value ="year_info")
public class YearInfo implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * day_start_of_year_id
     */
    private String dayStartOfYearId;

    /**
     * 一年中的第几天
     */
    private Long dayStartOfYear;

    /**
     * 包含的节日id
     */
    private String festivalIds;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
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
     * day_start_of_year_id
     */
    public String getDayStartOfYearId() {
        return dayStartOfYearId;
    }

    /**
     * day_start_of_year_id
     */
    public void setDayStartOfYearId(String dayStartOfYearId) {
        this.dayStartOfYearId = dayStartOfYearId;
    }

    /**
     * 一年中的第几天
     */
    public Long getDayStartOfYear() {
        return dayStartOfYear;
    }

    /**
     * 一年中的第几天
     */
    public void setDayStartOfYear(Long dayStartOfYear) {
        this.dayStartOfYear = dayStartOfYear;
    }

    /**
     * 包含的节日id
     */
    public List<String> getFestivalIds() {
        return List.of(festivalIds.split(","));
    }

    /**
     * 包含的节日id
     */
    public void setFestivalIds(String festivalIds) {
        this.festivalIds = festivalIds;
    }

    /**
     * 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日期
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
        YearInfo other = (YearInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDayStartOfYearId() == null ? other.getDayStartOfYearId() == null : this.getDayStartOfYearId().equals(other.getDayStartOfYearId()))
            && (this.getDayStartOfYear() == null ? other.getDayStartOfYear() == null : this.getDayStartOfYear().equals(other.getDayStartOfYear()))
            && (this.getFestivalIds() == null ? other.getFestivalIds() == null : this.getFestivalIds().equals(other.getFestivalIds()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDayStartOfYearId() == null) ? 0 : getDayStartOfYearId().hashCode());
        result = prime * result + ((getDayStartOfYear() == null) ? 0 : getDayStartOfYear().hashCode());
        result = prime * result + ((getFestivalIds() == null) ? 0 : getFestivalIds().hashCode());
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
        sb.append(", dayStartOfYearId=").append(dayStartOfYearId);
        sb.append(", dayStartOfYear=").append(dayStartOfYear);
        sb.append(", festivalIds=").append(festivalIds);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}