package online.cunho.blog.service;

import online.cunho.blog.dto.TbCustomerDto;
import online.cunho.blog.dto.TbCustomerShopDto;
import online.cunho.blog.entity.TbCustomer;
import online.cunho.blog.entity.TbCustomerShop;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    public Boolean insertTbCustomer(TbCustomer tbCustomer);
    public Boolean updateTbCustomer(TbCustomer tbCustomer);
    public Boolean isExistMobileNo(Map<String, Object> mapParams);

    List<TbCustomerDto> getAllCustomerList();
    TbCustomerDto getCustomerInfoByCustomerId(Integer customerId);

    public void deleteCustomerByCustomerId(Integer customerId);

    void insertTbCustomerShop(TbCustomerShop tbCustomerShop);

    void deleteTbCustomerShopByCustomerId(Integer customerId);

    List<TbCustomerShopDto> getCustomerShopListByCustomerId(Integer customerId);
}
