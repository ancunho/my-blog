package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class TbAttributeValueDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer attrValueId;
    private Integer attrId;
    private String attrValue;
    private BigDecimal price;
    private BigDecimal vipPrice;
    private BigDecimal deliveryPrice;
    private String deliveryType;
    private String status;
    private String attrValueImage;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;


}
