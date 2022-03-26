package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbShopDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer shopId;
    private String shopName;
    private String shopIntro;
    private String managerName;
    private String managerMobile;
    private String shopMobile;
    private String shopStatus;
    private String statusName;
    private String shopProvince;
    private String shopCity;
    private String shopDistrict;
    private String shopAddress;
    private String shopImage;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

}