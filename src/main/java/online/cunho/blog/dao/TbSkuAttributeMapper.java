package online.cunho.blog.dao;

import online.cunho.blog.dto.TbSkuAttributeDto;
import online.cunho.blog.entity.TbSkuAttribute;

import java.util.List;

public interface TbSkuAttributeMapper {
    int deleteByPrimaryKey(Integer skuAttrId);

    int insert(TbSkuAttribute record);

    int insertSelective(TbSkuAttribute record);

    TbSkuAttribute selectByPrimaryKey(Integer skuAttrId);

    int updateByPrimaryKeySelective(TbSkuAttribute record);

    int updateByPrimaryKey(TbSkuAttribute record);

    List<TbSkuAttributeDto> lstTbSkuAttribute(TbSkuAttributeDto tbSkuAttributeDto);

    TbSkuAttributeDto getTbSkuAttributeBySkuAttrId(Integer skuAttrId);

    List<TbSkuAttributeDto> lstTbSkuAttributeBySkuId(Integer skuId);

    List<TbSkuAttributeDto> lstTbSkuAttributeByAttrValueId(Integer attrValueId);

    int deleteTbSkuAttributeBySkuId(Integer skuId);
}