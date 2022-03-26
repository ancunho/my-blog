package online.cunho.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class WechatGoodsDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String classificationId;
    private String classificationName;
    private String spuId;
    private String spuName;
    private String skuId;
    private String skuName;
    private String price;
    private String pricePlus;
    private String attrId;
    private String attrValueId;
    private String attrName;
    private String attrValue;

//    private List<TbSpuDto> lstSpu;
//    private List<TbSkuDto> lstSku;
//    private List<TbAttributeDto> lstAttribute;
//    private List<TbAttributeValueDto> lstAttributeValue;
    private List<Map<String, Object>> lstSkuMap;
}
