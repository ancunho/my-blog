package online.cunho.blog.dao;

import online.cunho.blog.entity.TbPostTag;

public interface TbPostTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(TbPostTag record);

    int insertSelective(TbPostTag record);

    TbPostTag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(TbPostTag record);

    int updateByPrimaryKey(TbPostTag record);
}