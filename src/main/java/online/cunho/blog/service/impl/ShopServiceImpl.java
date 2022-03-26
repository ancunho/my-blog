package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbShopMapper;
import online.cunho.blog.dto.TbShopDto;
import online.cunho.blog.entity.TbShop;
import online.cunho.blog.service.ShopService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private TbShopMapper tbShopMapper;

    @Transactional
    public Boolean insertTbShop(TbShop tbShop) {
        int insertCount = tbShopMapper.insertSelective(tbShop);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbCustomer(TbShop tbShop) {
        int updateCount = tbShopMapper.updateByPrimaryKeySelective(tbShop);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public void deleteShopByShopId(Integer shopId) {
        tbShopMapper.deleteByPrimaryKey(shopId);
    }

    public Boolean isExistShopName(Map<String, Object> mapParams) {
        Integer isExistShopName = tbShopMapper.isExistShopName(mapParams);
        if (isExistShopName == null) {
            return false;
        }
        return true;
    }

    public List<TbShopDto> getAllShopList() {
        return tbShopMapper.getAllShopList();
    }

    public TbShopDto getShopInfoByShopId(Integer shopId) {
        return tbShopMapper.getShopInfoByShopId(shopId);
    }



}
