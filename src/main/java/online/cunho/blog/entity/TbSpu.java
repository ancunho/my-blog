package online.cunho.blog.entity;

import java.util.Date;

public class TbSpu {
    private Integer spuId;

    private Integer classificationId;

    private Integer brandId;

    private String spuName;

    private String spuType;

    private String status;

    private Integer depth01Id;

    private Integer depth02Id;

    private Integer depth03Id;

    private String depth01Name;

    private String depth02Name;

    private String depth03Name;

    private String mainImage01;

    private String mainImage02;

    private String mainImage03;

    private String subImage01;

    private String subImage02;

    private String subImage03;

    private String subImage04;

    private String subImage05;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuType() {
        return spuType;
    }

    public void setSpuType(String spuType) {
        this.spuType = spuType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDepth01Id() {
        return depth01Id;
    }

    public void setDepth01Id(Integer depth01Id) {
        this.depth01Id = depth01Id;
    }

    public Integer getDepth02Id() {
        return depth02Id;
    }

    public void setDepth02Id(Integer depth02Id) {
        this.depth02Id = depth02Id;
    }

    public Integer getDepth03Id() {
        return depth03Id;
    }

    public void setDepth03Id(Integer depth03Id) {
        this.depth03Id = depth03Id;
    }

    public String getDepth01Name() {
        return depth01Name;
    }

    public void setDepth01Name(String depth01Name) {
        this.depth01Name = depth01Name;
    }

    public String getDepth02Name() {
        return depth02Name;
    }

    public void setDepth02Name(String depth02Name) {
        this.depth02Name = depth02Name;
    }

    public String getDepth03Name() {
        return depth03Name;
    }

    public void setDepth03Name(String depth03Name) {
        this.depth03Name = depth03Name;
    }

    public String getMainImage01() {
        return mainImage01;
    }

    public void setMainImage01(String mainImage01) {
        this.mainImage01 = mainImage01;
    }

    public String getMainImage02() {
        return mainImage02;
    }

    public void setMainImage02(String mainImage02) {
        this.mainImage02 = mainImage02;
    }

    public String getMainImage03() {
        return mainImage03;
    }

    public void setMainImage03(String mainImage03) {
        this.mainImage03 = mainImage03;
    }

    public String getSubImage01() {
        return subImage01;
    }

    public void setSubImage01(String subImage01) {
        this.subImage01 = subImage01;
    }

    public String getSubImage02() {
        return subImage02;
    }

    public void setSubImage02(String subImage02) {
        this.subImage02 = subImage02;
    }

    public String getSubImage03() {
        return subImage03;
    }

    public void setSubImage03(String subImage03) {
        this.subImage03 = subImage03;
    }

    public String getSubImage04() {
        return subImage04;
    }

    public void setSubImage04(String subImage04) {
        this.subImage04 = subImage04;
    }

    public String getSubImage05() {
        return subImage05;
    }

    public void setSubImage05(String subImage05) {
        this.subImage05 = subImage05;
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
        return "TbSpu{" +
                "spuId=" + spuId +
                ", classificationId=" + classificationId +
                ", brandId=" + brandId +
                ", spuName='" + spuName + '\'' +
                ", spuType='" + spuType + '\'' +
                ", status='" + status + '\'' +
                ", depth01Id=" + depth01Id +
                ", depth02Id=" + depth02Id +
                ", depth03Id=" + depth03Id +
                ", depth01Name='" + depth01Name + '\'' +
                ", depth02Name='" + depth02Name + '\'' +
                ", depth03Name='" + depth03Name + '\'' +
                ", mainImage01='" + mainImage01 + '\'' +
                ", mainImage02='" + mainImage02 + '\'' +
                ", mainImage03='" + mainImage03 + '\'' +
                ", subImage01='" + subImage01 + '\'' +
                ", subImage02='" + subImage02 + '\'' +
                ", subImage03='" + subImage03 + '\'' +
                ", subImage04='" + subImage04 + '\'' +
                ", subImage05='" + subImage05 + '\'' +
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