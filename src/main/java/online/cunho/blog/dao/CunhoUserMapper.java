package online.cunho.blog.dao;

import online.cunho.blog.entity.CunhoUser;

public interface CunhoUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(CunhoUser record);

    int insertSelective(CunhoUser record);

    CunhoUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(CunhoUser record);

    int updateByPrimaryKey(CunhoUser record);
}