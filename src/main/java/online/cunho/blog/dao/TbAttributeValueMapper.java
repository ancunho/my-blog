package online.cunho.blog.dao;

import online.cunho.blog.dto.TbAttributeValueDto;
import online.cunho.blog.entity.TbAttributeValue;

import java.util.List;

public interface TbAttributeValueMapper {
    int deleteByPrimaryKey(Integer attrValueId);

    int insert(TbAttributeValue record);

    int insertSelective(TbAttributeValue record);

    TbAttributeValue selectByPrimaryKey(Integer attrValueId);

    int updateByPrimaryKeySelective(TbAttributeValue record);

    int updateByPrimaryKey(TbAttributeValue record);

    List<TbAttributeValueDto> lstTbAttributeValue(TbAttributeValueDto tbAttributeValueDto);

    TbAttributeValueDto getTbAttributeValueInfoByAttrValueId(Integer attrValueId);

    List<TbAttributeValueDto> lstTbAttributeValueByAttrId(TbAttributeValueDto tbAttributeValueDto);
}