package online.cunho.blog.dao;

import online.cunho.blog.dto.TbAttributeDto;
import online.cunho.blog.entity.TbAttribute;

import java.util.List;
import java.util.Map;

public interface TbAttributeMapper {
    int deleteByPrimaryKey(Integer attrId);

    int insert(TbAttribute record);

    int insertSelective(TbAttribute record);

    TbAttribute selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(TbAttribute record);

    int updateByPrimaryKey(TbAttribute record);

    List<TbAttributeDto> lstTbAttribute(TbAttributeDto tbAttributeDto);

    List<Map<String, Object>> lstTbAttributeType2(TbAttributeDto tbAttributeDto);

    TbAttributeDto getTbAttributeInfoByAttrId(Integer attrId);
}