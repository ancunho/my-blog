package online.cunho.blog.controller.backend;

import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbShopDto;
import online.cunho.blog.entity.TbShop;
import online.cunho.blog.service.ShopService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/proc")
    public BaseResponse procTB_SHOP(BaseRequest baseRequest, @RequestBody TbShopDto tbShopDto) {
        if (StringUtils.isEmpty(tbShopDto.getShopName())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbShopDto.getShopId() == null) {
                Map<String, Object> mapParams = new HashMap<>();
                mapParams.put("shopName", tbShopDto.getShopName());
                boolean isExistShopName = shopService.isExistShopName(mapParams);
                if (isExistShopName) {
                    return BaseResponse.valueOfFailureMessage("此门店名已使用");
                }

                TbShop tbShop = new TbShop();
                tbShop.setShopName(tbShopDto.getShopName());
                tbShop.setShopIntro(tbShopDto.getShopIntro());
                tbShop.setManagerName(tbShopDto.getManagerName());
                tbShop.setManagerMobile(tbShopDto.getManagerMobile());
                tbShop.setShopMobile(tbShopDto.getShopMobile());
                tbShop.setShopStatus(tbShopDto.getShopStatus());
                tbShop.setShopProvince(tbShopDto.getShopProvince());
                tbShop.setShopCity(tbShopDto.getShopCity());
                tbShop.setShopDistrict(tbShopDto.getShopDistrict());
                tbShop.setShopAddress(tbShopDto.getShopAddress());
                tbShop.setOption01(tbShopDto.getOption01());
                tbShop.setOption02(tbShopDto.getOption02());
                tbShop.setOption03(tbShopDto.getOption03());
                tbShop.setOption04(tbShopDto.getOption04());
                tbShop.setOption05(tbShopDto.getOption05());

                boolean isSuccessInsert = shopService.insertTbShop(tbShop);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                Map<String, Object> mapParams = new HashMap<>();
                mapParams.put("shopId", tbShopDto.getShopId());
                mapParams.put("shopName", tbShopDto.getShopName());
                boolean isExistShopName = shopService.isExistShopName(mapParams);
                if (isExistShopName) {
                    return BaseResponse.valueOfFailureMessage("此门店名已使用");
                }

                TbShop tbShop = new TbShop();
                tbShop.setShopId(tbShopDto.getShopId());
                tbShop.setShopName(tbShopDto.getShopName());
                tbShop.setShopIntro(tbShopDto.getShopIntro());
                tbShop.setManagerName(tbShopDto.getManagerName());
                tbShop.setManagerMobile(tbShopDto.getManagerMobile());
                tbShop.setShopMobile(tbShopDto.getShopMobile());
                tbShop.setShopStatus(tbShopDto.getShopStatus());
                tbShop.setShopProvince(tbShopDto.getShopProvince());
                tbShop.setShopCity(tbShopDto.getShopCity());
                tbShop.setShopDistrict(tbShopDto.getShopDistrict());
                tbShop.setShopAddress(tbShopDto.getShopAddress());
                tbShop.setOption01(tbShopDto.getOption01());
                tbShop.setOption02(tbShopDto.getOption02());
                tbShop.setOption03(tbShopDto.getOption03());
                tbShop.setOption04(tbShopDto.getOption04());
                tbShop.setOption05(tbShopDto.getOption05());

                boolean isSuccessUpdate = shopService.updateTbCustomer(tbShop);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.ERROR.getDesc());
        }

    }

    /**
     * 매장리스트
     * @param baseRequest
     * @return
     */
    @GetMapping(value = "/list")
    public BaseResponse getAllShopList(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbShopDto> returnData = shopService.getAllShopList();
        return BaseResponse.valueOfSuccessList(returnData);
    }

    /**
     * 매장정보
     * @param shopId
     * @return
     */
    @GetMapping(value = "/info")
    public BaseResponse getShopInfoByShopId(@RequestParam("shopId") Integer shopId) {
        if (shopId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbShopDto tbShopDto = shopService.getShopInfoByShopId(shopId);
        return BaseResponse.valueOfSuccess(tbShopDto);
    }

    /**
     * 매장삭제
     * @param shopId
     * @return
     */
    @GetMapping(value = "/delete")
    public BaseResponse deleteShopByShopId(@RequestParam("shopId") Integer shopId) {
        if (shopId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            shopService.deleteShopByShopId(shopId);
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
        }
    }
}
