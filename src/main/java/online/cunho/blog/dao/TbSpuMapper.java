package online.cunho.blog.dao;

import online.cunho.blog.dto.TbSpuDto;
import online.cunho.blog.entity.TbSpu;

import java.util.List;

public interface TbSpuMapper {
    int deleteByPrimaryKey(Integer spuId);

    int insert(TbSpu record);

    int insertSelective(TbSpu record);

    TbSpu selectByPrimaryKey(Integer spuId);

    int updateByPrimaryKeySelective(TbSpu record);

    int updateByPrimaryKey(TbSpu record);

    List<TbSpuDto> lstTbSpu(TbSpuDto tbSpuDto);

    TbSpuDto getTbSpuInfoBySpuId(Integer spuId);


}