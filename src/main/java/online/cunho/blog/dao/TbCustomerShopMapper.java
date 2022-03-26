package online.cunho.blog.dao;

import online.cunho.blog.dto.TbCustomerShopDto;
import online.cunho.blog.entity.TbCustomerShop;

import java.util.List;

public interface TbCustomerShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCustomerShop record);

    int insertSelective(TbCustomerShop record);

    TbCustomerShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCustomerShop record);

    int updateByPrimaryKey(TbCustomerShop record);

    void deleteByCustomerId(Integer customerId);

    List<TbCustomerShopDto> getCustomerShopListByCustomerId(Integer customerId);
}