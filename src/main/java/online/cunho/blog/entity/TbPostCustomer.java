package online.cunho.blog.entity;

import java.util.Date;

public class TbPostCustomer {
    private Integer postCustomerId;

    private Integer postId;

    private Integer customerId;

    private String paidYn;

    private String joinedYn;

    private Date joinedTime;

    private String pcOrderNo;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getPostCustomerId() {
        return postCustomerId;
    }

    public void setPostCustomerId(Integer postCustomerId) {
        this.postCustomerId = postCustomerId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPaidYn() {
        return paidYn;
    }

    public void setPaidYn(String paidYn) {
        this.paidYn = paidYn;
    }

    public String getJoinedYn() {
        return joinedYn;
    }

    public void setJoinedYn(String joinedYn) {
        this.joinedYn = joinedYn;
    }

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
    }

    public String getPcOrderNo() {
        return pcOrderNo;
    }

    public void setPcOrderNo(String pcOrderNo) {
        this.pcOrderNo = pcOrderNo;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postCustomerId=").append(postCustomerId);
        sb.append(", postId=").append(postId);
        sb.append(", customerId=").append(customerId);
        sb.append(", paidYn=").append(paidYn);
        sb.append(", joinedYn=").append(joinedYn);
        sb.append(", joinedTime=").append(joinedTime);
        sb.append(", pcOrderNo=").append(pcOrderNo);
        sb.append(", option01=").append(option01);
        sb.append(", option02=").append(option02);
        sb.append(", option03=").append(option03);
        sb.append(", option04=").append(option04);
        sb.append(", option05=").append(option05);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}