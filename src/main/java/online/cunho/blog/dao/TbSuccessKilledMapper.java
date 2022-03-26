package online.cunho.blog.dao;

import online.cunho.blog.entity.TbSuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface TbSuccessKilledMapper {
    int deleteByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") String userPhone);

    int insert(TbSuccessKilled record);

    int insertSelective(TbSuccessKilled record);

    TbSuccessKilled selectByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") String userPhone);

    int updateByPrimaryKeySelective(TbSuccessKilled record);

    int updateByPrimaryKey(TbSuccessKilled record);

    /**
     * 插入购买明细， 可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(long seckillId, String userPhone);

    TbSuccessKilled getTbSuccessKilledByseckillIdWithSeckill(long seckillId);
}