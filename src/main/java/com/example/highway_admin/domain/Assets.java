package com.example.highway_admin.domain;

import com.example.highway_admin.base.base;

import java.io.Serializable;
import java.util.Date;

public class Assets extends base implements Serializable {
    private Integer id;

    private String assetsName;

    private String assetsCode;

    private String assetsType;

    private Date createTime;

    private String state;

    private String remark;

    private String userId;

    private Date finishTime;

    private String assetsData;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName == null ? null : assetsName.trim();
    }

    public String getAssetsCode() {
        return assetsCode;
    }

    public void setAssetsCode(String assetsCode) {
        this.assetsCode = assetsCode == null ? null : assetsCode.trim();
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType == null ? null : assetsType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getAssetsData() {
        return assetsData;
    }

    public void setAssetsData(String assetsData) {
        this.assetsData = assetsData == null ? null : assetsData.trim();
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
        Assets other = (Assets) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssetsName() == null ? other.getAssetsName() == null : this.getAssetsName().equals(other.getAssetsName()))
            && (this.getAssetsCode() == null ? other.getAssetsCode() == null : this.getAssetsCode().equals(other.getAssetsCode()))
            && (this.getAssetsType() == null ? other.getAssetsType() == null : this.getAssetsType().equals(other.getAssetsType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getAssetsData() == null ? other.getAssetsData() == null : this.getAssetsData().equals(other.getAssetsData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAssetsName() == null) ? 0 : getAssetsName().hashCode());
        result = prime * result + ((getAssetsCode() == null) ? 0 : getAssetsCode().hashCode());
        result = prime * result + ((getAssetsType() == null) ? 0 : getAssetsType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getAssetsData() == null) ? 0 : getAssetsData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assetsName=").append(assetsName);
        sb.append(", assetsCode=").append(assetsCode);
        sb.append(", assetsType=").append(assetsType);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append(", userId=").append(userId);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", assetsData=").append(assetsData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}