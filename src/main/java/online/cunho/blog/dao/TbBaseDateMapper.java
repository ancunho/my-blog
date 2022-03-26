package online.cunho.blog.dao;

import online.cunho.blog.entity.TbBaseDate;

public interface TbBaseDateMapper {
    int deleteByPrimaryKey(String baseYmd);

    int insert(TbBaseDate record);

    int insertSelective(TbBaseDate record);

    TbBaseDate selectByPrimaryKey(String baseYmd);

    int updateByPrimaryKeySelective(TbBaseDate record);

    int updateByPrimaryKeyWithBLOBs(TbBaseDate record);

    int updateByPrimaryKey(TbBaseDate record);
}