package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbBookingDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private String changeTime;
    private String customerChangeTime;
    private String bookingTime;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

    private String roomName;
    private String shopName;
    private String bookingStatusName;
    private String payStatusName;
    private String bookingTypeName;
    private String bookingOrderStatusName;

}
