package online.cunho.blog.dao;

import online.cunho.blog.entity.TbBrand;

public interface TbBrandMapper {
    int deleteByPrimaryKey(Integer brandId);

    int insert(TbBrand record);

    int insertSelective(TbBrand record);

    TbBrand selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(TbBrand record);

    int updateByPrimaryKey(TbBrand record);
}