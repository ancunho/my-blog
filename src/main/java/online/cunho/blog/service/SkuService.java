package online.cunho.blog.service;

import online.cunho.blog.dto.*;
import online.cunho.blog.entity.*;

import java.util.List;
import java.util.Map;

public interface SkuService {

    // TB_SPU
    public List<TbSpuDto> lstTbSpu(TbSpuDto tbSpuDto);
    public TbSpuDto getTbSpuInfoBySpuId(Integer spuId);
    public Boolean insertTbSpu(TbSpu tbSpu);
    public Boolean updateTbSpu(TbSpu tbSpu);

    // TB_SKU
    public List<TbSkuDto> lstTbSku(TbSkuDto tbSkuDto);
    public TbSkuDto getTbSkuInfoBySkuId(Integer skuId);
    public List<TbSkuDto> lstTbSkuBySpuId(Integer spuId);
    public Boolean insertTbSku(TbSku tbSku);
    public Boolean updateTbSku(TbSku tbSku);

    // TB_SPU_ATTRIBUTE
    public List<TbSpuAttributeDto> lstTbSpuAttribute(TbSpuAttributeDto tbSpuAttributeDto);
    public TbSpuAttributeDto getTbSpuAttributeInfoBySpuAttrId(Integer spuAttrId);
    public List<TbSpuAttributeDto> lstTbSpuAttributeBySpuId(Integer spuId);
    public List<TbSpuAttributeDto> lstTbSpuAttributeByAttrId(Integer attrId);
    public Boolean insertTbSpuAttribute(TbSpuAttribute tbSpuAttribute);
    public Boolean updateTbSpuAttribute(TbSpuAttribute tbSpuAttribute);

    // TB_SKU_ATTRIBUTE
    public List<TbSkuAttributeDto> lstTbSkuAttribute(TbSkuAttributeDto tbSkuAttributeDto);
    public TbSkuAttributeDto getTbSkuAttributeBySkuAttrId(Integer skuAttrId);
    public List<TbSkuAttributeDto> lstTbSkuAttributeBySkuId(Integer skuId);
    public List<TbSkuAttributeDto> lstTbSkuAttributeByAttrValueId(Integer attrValueId);
    public Boolean insertTbSkuAttribute(TbSkuAttribute tbSkuAttribute);
    public Boolean updateTbSkuAttribute(TbSkuAttribute tbSkuAttribute);
    public Boolean deleteTbSkuAttributeBySkuId(Integer skuId);

    // TB_ATTRIBUTE
    public List<TbAttributeDto> lstTbAttribute(TbAttributeDto tbAttributeDto);
    public List<Map<String, Object>> lstTbAttributeType2(TbAttributeDto tbAttributeDto);
    public TbAttributeDto getTbAttributeInfoByAttrId(Integer attrId);
    public Boolean insertTbAttribute(TbAttribute tbAttribute);
    public Boolean updateTbAttribute(TbAttribute tbAttribute);

    // TB_ATTRIBUTE_VALUE
    public List<TbAttributeValueDto> lstTbAttributeValue(TbAttributeValueDto tbAttributeValueDto);
    public List<TbAttributeValueDto> lstTbAttributeValueByAttrId(TbAttributeValueDto tbAttributeValueDto);
    public TbAttributeValueDto getTbAttributeValueInfoByAttrValueId(Integer attrValueId);
    public Boolean insertTbAttributeValue(TbAttributeValue tbAttributeValue);
    public Boolean updateTbAttributeValue(TbAttributeValue tbAttributeValue);
    public Boolean deleteTbAttributeValueByAttrValueId(Integer attrValueId);

    //TB_CLASSIFICATION
    public List<TbClassificationDto> lstTbClassification(TbClassificationDto tbClassificationDto);
    public TbClassificationDto getTbClassificationInfoByClassificationId(Integer classificationId);
    public List<TbClassificationDto> getTbClassificationInfoByParentClassificationId(Integer parentClassificationId);
    public Boolean insertTbClassification(TbClassification tbClassification);
    public Boolean updateTbClassification(TbClassification tbClassification);

}
