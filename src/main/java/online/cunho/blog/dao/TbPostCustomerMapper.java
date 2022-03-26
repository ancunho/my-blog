package online.cunho.blog.dao;

import online.cunho.blog.entity.TbPostCustomer;

public interface TbPostCustomerMapper {
    int deleteByPrimaryKey(Integer postCustomerId);

    int insert(TbPostCustomer record);

    int insertSelective(TbPostCustomer record);

    TbPostCustomer selectByPrimaryKey(Integer postCustomerId);

    int updateByPrimaryKeySelective(TbPostCustomer record);

    int updateByPrimaryKey(TbPostCustomer record);
}