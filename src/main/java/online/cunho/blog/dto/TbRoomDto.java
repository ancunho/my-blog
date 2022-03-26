package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbRoomDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roomId;
    private Integer shopId;
    private String roomType;
    private String roomName;
    private String roomThumbnail;
    private String roomIntro;
    private String roomCode;
    private String roomCapacity;
    private String roomStatus;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

    private String shopName;
    private String statusName;
    private String roomTypeName;

}
