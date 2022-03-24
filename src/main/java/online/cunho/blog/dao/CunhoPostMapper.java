package online.cunho.blog.dao;

import online.cunho.blog.entity.CunhoPost;

public interface CunhoPostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(CunhoPost record);

    int insertSelective(CunhoPost record);

    CunhoPost selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(CunhoPost record);

    int updateByPrimaryKey(CunhoPost record);
}