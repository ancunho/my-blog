package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@ToString
public class TbSkuDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer skuId;
    private Integer spuId;
    private String skuName;
    private String skuIntro;
    private BigDecimal skuPrice;
    private String skuCode;
    private String skuBarcode;
    private Integer skuStock;
    private Integer skuUnit;
    private String skuUnitName;
    private BigDecimal price;
    private BigDecimal vipPrice;
    private String status;
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

    private String spuName;
    private List<TbSkuAttributeDto> lstSkuAttr;
    private List<TbAttributeDto> lstAttr;
    private List<TbAttributeValueDto> lstAttrValue;
    private List<Map<String, Object>> lstSkuMap;

}
