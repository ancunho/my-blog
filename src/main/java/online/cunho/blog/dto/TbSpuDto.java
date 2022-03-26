package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbSpuDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private String createTime;
    private String updateTime;

    private String classificationName;



}
