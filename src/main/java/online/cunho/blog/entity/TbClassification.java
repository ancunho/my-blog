package online.cunho.blog.entity;

import java.util.Date;

public class TbClassification {
    private Integer classificationId;

    private Integer parentClassificationId;

    private String classificationName;

    private String classificationType;

    private String classificationImage;

    private Integer sortOrder;

    private Integer depthNum;

    private String status;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getParentClassificationId() {
        return parentClassificationId;
    }

    public void setParentClassificationId(Integer parentClassificationId) {
        this.parentClassificationId = parentClassificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getClassificationImage() {
        return classificationImage;
    }

    public void setClassificationImage(String classificationImage) {
        this.classificationImage = classificationImage;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getDepthNum() {
        return depthNum;
    }

    public void setDepthNum(Integer depthNum) {
        this.depthNum = depthNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOption01() {
        return option01;
    }

    public void setOption01(String option01) {
        this.option01 = option01;
    }

    public String getOption02() {
        return option02;
    }

    public void setOption02(String option02) {
        this.option02 = option02;
    }

    public String getOption03() {
        return option03;
    }

    public void setOption03(String option03) {
        this.option03 = option03;
    }

    public String getOption04() {
        return option04;
    }

    public void setOption04(String option04) {
        this.option04 = option04;
    }

    public String getOption05() {
        return option05;
    }

    public void setOption05(String option05) {
        this.option05 = option05;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TbClassification{" +
                "classificationId=" + classificationId +
                ", parentClassificationId=" + parentClassificationId +
                ", classificationName='" + classificationName + '\'' +
                ", classificationType='" + classificationType + '\'' +
                ", classificationImage='" + classificationImage + '\'' +
                ", sortOrder=" + sortOrder +
                ", depthNum=" + depthNum +
                ", status='" + status + '\'' +
                ", option01='" + option01 + '\'' +
                ", option02='" + option02 + '\'' +
                ", option03='" + option03 + '\'' +
                ", option04='" + option04 + '\'' +
                ", option05='" + option05 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}