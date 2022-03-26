package online.cunho.blog.entity;

import java.util.Date;

public class TbBooking {
    private Long bookingId;

    private String bookingOrderNo;

    private String bookingOrderStatus;

    private String bookingType;

    private Integer shopId;

    private Integer roomId;

    private Integer customerId;

    private String bookingPersonCount;

    private String bookingStartday;

    private String bookingEndday;

    private String bookingStarttime;

    private String bookingEndtime;

    private String bookingStatus;

    private String bookingMobile;

    private String bookingPersonName;

    private String payStatus;

    private String remark;

    private String comment;

    private Integer changeUserId;

    private Date changeTime;

    private Date customerChangeTime;

    private Date bookingTime;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingOrderNo() {
        return bookingOrderNo;
    }

    public void setBookingOrderNo(String bookingOrderNo) {
        this.bookingOrderNo = bookingOrderNo;
    }

    public String getBookingOrderStatus() {
        return bookingOrderStatus;
    }

    public void setBookingOrderStatus(String bookingOrderStatus) {
        this.bookingOrderStatus = bookingOrderStatus;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getBookingPersonCount() {
        return bookingPersonCount;
    }

    public void setBookingPersonCount(String bookingPersonCount) {
        this.bookingPersonCount = bookingPersonCount;
    }

    public String getBookingStartday() {
        return bookingStartday;
    }

    public void setBookingStartday(String bookingStartday) {
        this.bookingStartday = bookingStartday;
    }

    public String getBookingEndday() {
        return bookingEndday;
    }

    public void setBookingEndday(String bookingEndday) {
        this.bookingEndday = bookingEndday;
    }

    public String getBookingStarttime() {
        return bookingStarttime;
    }

    public void setBookingStarttime(String bookingStarttime) {
        this.bookingStarttime = bookingStarttime;
    }

    public String getBookingEndtime() {
        return bookingEndtime;
    }

    public void setBookingEndtime(String bookingEndtime) {
        this.bookingEndtime = bookingEndtime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingMobile() {
        return bookingMobile;
    }

    public void setBookingMobile(String bookingMobile) {
        this.bookingMobile = bookingMobile;
    }

    public String getBookingPersonName() {
        return bookingPersonName;
    }

    public void setBookingPersonName(String bookingPersonName) {
        this.bookingPersonName = bookingPersonName;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getChangeUserId() {
        return changeUserId;
    }

    public void setChangeUserId(Integer changeUserId) {
        this.changeUserId = changeUserId;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Date getCustomerChangeTime() {
        return customerChangeTime;
    }

    public void setCustomerChangeTime(Date customerChangeTime) {
        this.customerChangeTime = customerChangeTime;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
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
        sb.append(", bookingId=").append(bookingId);
        sb.append(", bookingOrderNo=").append(bookingOrderNo);
        sb.append(", bookingOrderStatus=").append(bookingOrderStatus);
        sb.append(", bookingType=").append(bookingType);
        sb.append(", shopId=").append(shopId);
        sb.append(", roomId=").append(roomId);
        sb.append(", customerId=").append(customerId);
        sb.append(", bookingPersonCount=").append(bookingPersonCount);
        sb.append(", bookingStartday=").append(bookingStartday);
        sb.append(", bookingEndday=").append(bookingEndday);
        sb.append(", bookingStarttime=").append(bookingStarttime);
        sb.append(", bookingEndtime=").append(bookingEndtime);
        sb.append(", bookingStatus=").append(bookingStatus);
        sb.append(", bookingMobile=").append(bookingMobile);
        sb.append(", bookingPersonName=").append(bookingPersonName);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", remark=").append(remark);
        sb.append(", comment=").append(comment);
        sb.append(", changeUserId=").append(changeUserId);
        sb.append(", changeTime=").append(changeTime);
        sb.append(", customerChangeTime=").append(customerChangeTime);
        sb.append(", bookingTime=").append(bookingTime);
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