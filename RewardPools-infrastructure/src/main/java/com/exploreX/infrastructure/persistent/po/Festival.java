package com.exploreX.infrastructure.persistent.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName festival
 */
@TableName(value ="festival")
@Slf4j
public class Festival implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 节日id
     */
    private String festivalId;

    /**
     * 节日描述
     */
    private String festivalDescrip;

    /**
     * 节日日期id
     */
    private String dayStartOfYearId;
    /*活动ids*/
    private String activeIds;
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
     * 节日id
     */
    public String getFestivalId() {
        return festivalId;
    }

    /**
     * 节日id
     */
    public void setFestivalId(String festivalId) {
        this.festivalId = festivalId;
    }

    /**
     * 节日描述
     */
    public String getFestivalDescrip() {
        return festivalDescrip;
    }

    /**
     * 节日描述
     */
    public void setFestivalDescrip(String festivalDescrip) {
        this.festivalDescrip = festivalDescrip;
    }

    /**
     * 节日日期id
     */
    public String getDayStartOfYearId() {
        return dayStartOfYearId;
    }

    /**
     * 节日日期id
     */
    public void setDayStartOfYearId(String dayStartOfYearId) {
        this.dayStartOfYearId = dayStartOfYearId;
    }

    public String[] getActiveIds() {
        return activeIds.split(",");
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
        Festival other = (Festival) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFestivalId() == null ? other.getFestivalId() == null : this.getFestivalId().equals(other.getFestivalId()))
            && (this.getFestivalDescrip() == null ? other.getFestivalDescrip() == null : this.getFestivalDescrip().equals(other.getFestivalDescrip()))
            && (this.getDayStartOfYearId() == null ? other.getDayStartOfYearId() == null : this.getDayStartOfYearId().equals(other.getDayStartOfYearId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFestivalId() == null) ? 0 : getFestivalId().hashCode());
        result = prime * result + ((getFestivalDescrip() == null) ? 0 : getFestivalDescrip().hashCode());
        result = prime * result + ((getDayStartOfYearId() == null) ? 0 : getDayStartOfYearId().hashCode());
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
        sb.append(", festivalId=").append(festivalId);
        sb.append(", festivalDescrip=").append(festivalDescrip);
        sb.append(", dayStartOfYearId=").append(dayStartOfYearId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}