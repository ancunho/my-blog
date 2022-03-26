package online.cunho.blog.service;

import online.cunho.blog.dto.TbShopDto;
import online.cunho.blog.entity.TbShop;

import java.util.List;
import java.util.Map;

public interface ShopService {

    public Boolean insertTbShop(TbShop tbShop);
    public Boolean updateTbCustomer(TbShop tbShop);

    public Boolean isExistShopName(Map<String, Object> mapParams);

    public List<TbShopDto> getAllShopList();
    public TbShopDto getShopInfoByShopId(Integer shopId);
    public void deleteShopByShopId(Integer shopId);
}
